-- ============================================================================
-- Pharmacy Management System - Device Fingerprint & Station Mapping Schema
-- ============================================================================

-- Drop existing tables if they exist (for fresh installation)
DROP TABLE IF EXISTS fingerprint_history CASCADE;
DROP TABLE IF EXISTS device_fingerprints CASCADE;
DROP TABLE IF EXISTS stations CASCADE;

-- ============================================================================
-- 1. STATIONS TABLE - Stores station configuration
-- ============================================================================
CREATE TABLE IF NOT EXISTS stations (
    id SERIAL PRIMARY KEY,
    station_prefix VARCHAR(10) NOT NULL,
    department VARCHAR(50) NOT NULL,
    location VARCHAR(100),
    starting_number INTEGER DEFAULT 1,
    current_number INTEGER DEFAULT 1,
    max_stations INTEGER,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT unique_station_config UNIQUE(station_prefix, department, location)
);

-- ============================================================================
-- 2. DEVICE_FINGERPRINTS TABLE - Core table for device fingerprint mapping
-- ============================================================================
CREATE TABLE IF NOT EXISTS device_fingerprints (
    id SERIAL PRIMARY KEY,

    -- Station assignment
    station_id SERIAL UNIQUE NOT NULL,

    -- Device fingerprint
    device_fingerprint VARCHAR(255) UNIQUE NOT NULL,
    fingerprint_hash VARCHAR(64) UNIQUE NOT NULL,

    -- Device characteristics
    browser_user_agent TEXT,
    screen_resolution VARCHAR(50),
    timezone VARCHAR(50),
    language VARCHAR(20),

    -- Canvas and WebGL fingerprints
    canvas_fingerprint TEXT,
    webgl_fingerprint VARCHAR(255),

    -- Device metadata
    department VARCHAR(50) NOT NULL,
    location VARCHAR(100),

    -- Tracking information
    assigned_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_seen TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active BOOLEAN DEFAULT TRUE,

    -- Statistics
    access_count INTEGER DEFAULT 1,

    -- Foreign key
    FOREIGN KEY (station_id) REFERENCES stations(id) ON DELETE CASCADE
);

-- ============================================================================
-- 3. FINGERPRINT_HISTORY TABLE - Track fingerprint changes
-- ============================================================================
CREATE TABLE IF NOT EXISTS fingerprint_history (
    id SERIAL PRIMARY KEY,

    station_id SERIAL NOT NULL,

    -- Fingerprint comparison
    old_fingerprint_hash VARCHAR(64),
    new_fingerprint_hash VARCHAR(64) NOT NULL,

    -- Change details
    change_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    reason VARCHAR(255),
    similarity_percentage NUMERIC(5, 2),

    -- Browser info
    browser_user_agent TEXT,
    screen_resolution VARCHAR(50),
    timezone VARCHAR(50),

    -- Admin notes
    notes TEXT,
    verified_by VARCHAR(100),

    FOREIGN KEY (station_id) REFERENCES device_fingerprints(station_id) ON DELETE CASCADE
);

-- -- ============================================================================
-- -- 4. CREATE INDEXES FOR PERFORMANCE
-- -- ============================================================================

-- -- Primary lookup indexes
-- CREATE INDEX IF NOT EXISTS idx_device_fingerprints_hash ON device_fingerprints(fingerprint_hash);
-- CREATE INDEX IF NOT EXISTS idx_device_fingerprints_station_id ON device_fingerprints(station_id);
-- CREATE INDEX IF NOT EXISTS idx_device_fingerprints_department ON device_fingerprints(department);

-- -- Activity tracking indexes
-- CREATE INDEX IF NOT EXISTS idx_device_fingerprints_last_seen ON device_fingerprints(last_seen);
-- CREATE INDEX IF NOT EXISTS idx_device_fingerprints_is_active ON device_fingerprints(is_active);
-- CREATE INDEX IF NOT EXISTS idx_device_fingerprints_assigned_date ON device_fingerprints(assigned_date);

-- -- History tracking indexes
-- CREATE INDEX IF NOT EXISTS idx_fingerprint_history_station_id ON fingerprint_history(station_id);
-- CREATE INDEX IF NOT EXISTS idx_fingerprint_history_change_date ON fingerprint_history(change_date);

-- ============================================================================
-- 5. SAMPLE DATA INSERTION
-- ============================================================================



-- ============================================================================
-- 6. UTILITY VIEWS
-- ============================================================================

-- View: All active stations summary
CREATE OR REPLACE VIEW active_stations_summary AS
SELECT
    df.station_id,
    df.department,
    df.location,
    df.browser_user_agent,
    df.screen_resolution,
    df.timezone,
    df.assigned_date,
    df.last_seen,
    df.access_count,
    EXTRACT(DAY FROM (CURRENT_TIMESTAMP - df.last_seen)) as days_inactive
FROM device_fingerprints df
WHERE df.is_active = TRUE
ORDER BY df.assigned_date DESC;

-- View: Inactive stations (not accessed in 30 days)
CREATE OR REPLACE VIEW inactive_stations AS
SELECT
    df.station_id,
    df.department,
    df.location,
    df.last_seen,
    EXTRACT(DAY FROM (CURRENT_TIMESTAMP - df.last_seen)) as days_inactive
FROM device_fingerprints df
WHERE df.is_active = TRUE
AND CURRENT_TIMESTAMP - df.last_seen > INTERVAL '30 days'
ORDER BY df.last_seen ASC;

-- View: Stations by department
CREATE OR REPLACE VIEW stations_by_department AS
SELECT
    df.department,
    df.location,
    COUNT(*) as total_stations,
    SUM(CASE WHEN df.is_active = TRUE THEN 1 ELSE 0 END) as active_stations,
    SUM(CASE WHEN df.is_active = FALSE THEN 1 ELSE 0 END) as inactive_stations,
    MAX(df.access_count) as max_access_count,
    AVG(df.access_count) as avg_access_count
FROM device_fingerprints df
GROUP BY df.department, df.location
ORDER BY df.department, df.location;

-- View: Fingerprint change history by station
CREATE OR REPLACE VIEW fingerprint_changes_by_station AS
SELECT
    fh.station_id,
    COUNT(*) as change_count,
    MAX(fh.change_date) as last_change,
    AVG(fh.similarity_percentage) as avg_similarity
FROM fingerprint_history fh
GROUP BY fh.station_id
ORDER BY change_count DESC;

-- ============================================================================
-- 7. UTILITY FUNCTIONS
-- ============================================================================

-- Function: Find station by fingerprint hash
CREATE OR REPLACE FUNCTION find_station_by_fingerprint(p_fingerprint_hash VARCHAR(64))
RETURNS TABLE(station_id VARCHAR, department VARCHAR, location VARCHAR, last_seen TIMESTAMP) AS $$
BEGIN
    RETURN QUERY
    SELECT
        df.station_id,
        df.department,
        df.location,
        df.last_seen
    FROM device_fingerprints df
    WHERE df.fingerprint_hash = p_fingerprint_hash
    AND df.is_active = TRUE;
END;
$$ LANGUAGE plpgsql;

-- Function: Update access count and last seen
CREATE OR REPLACE FUNCTION update_device_access(p_station_id VARCHAR(50))
RETURNS VOID AS $$
BEGIN
    UPDATE device_fingerprints
    SET
        last_seen = CURRENT_TIMESTAMP,
        access_count = access_count + 1
    WHERE station_id = p_station_id;
END;
$$ LANGUAGE plpgsql;

-- Function: Deactivate inactive stations (automatic cleanup)
CREATE OR REPLACE FUNCTION deactivate_inactive_stations(p_days_inactive INTEGER DEFAULT 60)
RETURNS TABLE(station_id VARCHAR, deactivation_date TIMESTAMP) AS $$
BEGIN
    RETURN QUERY
    UPDATE device_fingerprints
    SET is_active = FALSE
    WHERE is_active = TRUE
    AND CURRENT_TIMESTAMP - last_seen > (p_days_inactive || ' days')::INTERVAL
    RETURNING station_id, CURRENT_TIMESTAMP;
END;
$$ LANGUAGE plpgsql;

-- Function: Get fingerprint statistics
CREATE OR REPLACE FUNCTION get_fingerprint_statistics()
RETURNS TABLE(
    total_devices INTEGER,
    active_devices INTEGER,
    inactive_devices INTEGER,
    total_changes INTEGER,
    avg_access_count NUMERIC,
    last_registration TIMESTAMP
) AS $$
BEGIN
    RETURN QUERY
    SELECT
        (SELECT COUNT(*) FROM device_fingerprints)::INTEGER,
        (SELECT COUNT(*) FROM device_fingerprints WHERE is_active = TRUE)::INTEGER,
        (SELECT COUNT(*) FROM device_fingerprints WHERE is_active = FALSE)::INTEGER,
        (SELECT COUNT(*) FROM fingerprint_history)::INTEGER,
        (SELECT AVG(access_count) FROM device_fingerprints)::NUMERIC,
        (SELECT MAX(assigned_date) FROM device_fingerprints)::TIMESTAMP;
END;
$$ LANGUAGE plpgsql;

-- ============================================================================
-- 8. HELPFUL QUERIES
-- ============================================================================

-- Query 1: Find all active devices
-- SELECT * FROM active_stations_summary;

-- Query 2: Find devices by department
-- SELECT * FROM stations_by_department WHERE department = 'Pharmacy';

-- Query 3: Find station by fingerprint
-- SELECT * FROM find_station_by_fingerprint('sha256_hash_rx001_abc123def456');

-- Query 4: Get all fingerprint changes for a station
-- SELECT * FROM fingerprint_history WHERE station_id = 'RX-001' ORDER BY change_date DESC;

-- Query 5: Update device access
-- SELECT update_device_access('RX-001');

-- Query 6: Get overall statistics
-- SELECT * FROM get_fingerprint_statistics();

-- Query 7: Find duplicate fingerprints (security check)
-- SELECT fingerprint_hash, COUNT(*) FROM device_fingerprints GROUP BY fingerprint_hash HAVING COUNT(*) > 1;

-- Query 8: Find stations without activity for 7 days
-- SELECT * FROM device_fingerprints WHERE CURRENT_TIMESTAMP - last_seen > INTERVAL '7 days' AND is_active = TRUE;

-- Query 9: List all stations with their access history
-- SELECT df.station_id, df.department, df.location, df.access_count, df.last_seen, COUNT(fh.id) as change_count
-- FROM device_fingerprints df
-- LEFT JOIN fingerprint_history fh ON df.station_id = fh.station_id
-- GROUP BY df.station_id, df.department, df.location, df.access_count, df.last_seen;

-- Query 10: Generate daily activity report
-- SELECT
--     CURRENT_DATE as report_date,
--     COUNT(*) as active_stations,
--     SUM(CASE WHEN access_count > 1 THEN 1 ELSE 0 END) as stations_accessed_today,
--     AVG(access_count) as avg_access_count
-- FROM device_fingerprints
-- WHERE DATE(last_seen) = CURRENT_DATE;

-- ============================================================================
-- 9. CONSTRAINTS & RULES
-- ============================================================================

-- Check constraint: Station ID format validation
-- ALTER TABLE device_fingerprints
-- ADD CONSTRAINT check_station_id_format CHECK (station_id ~ '^[A-Z]{2}-[0-9]{3}$');

-- Check constraint: Access count must be positive
-- ALTER TABLE device_fingerprints
-- ADD CONSTRAINT check_access_count CHECK (access_count > 0);

-- ============================================================================
-- 10. TRIGGERS (Optional - Auto-update timestamp)
-- ============================================================================

-- Create trigger function for updating the updated_date field
CREATE OR REPLACE FUNCTION update_stations_timestamp()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_date = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Create trigger on stations table
CREATE TRIGGER trigger_update_stations_timestamp
BEFORE UPDATE ON stations
FOR EACH ROW
EXECUTE FUNCTION update_stations_timestamp();

-- ============================================================================
-- 11. GRANT PERMISSIONS (Adjust as needed)
-- ============================================================================

-- GRANT SELECT, INSERT, UPDATE ON device_fingerprints TO pharmacy_user;
-- GRANT SELECT, INSERT ON fingerprint_history TO pharmacy_user;
-- GRANT SELECT ON stations TO pharmacy_user;
-- GRANT EXECUTE ON ALL FUNCTIONS IN SCHEMA public TO pharmacy_user;

-- ============================================================================
-- END OF SCHEMA
-- ============================================================================