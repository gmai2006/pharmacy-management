package com.datascience9.pharmacy.service.manual;

import com.google.zxing.WriterException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/**
 * Service for managing prescription barcode generation Handles validation, generation, caching, and
 * retrieval
 */
public class PrescriptionBarcodeService {

    private static final Logger logger =
            Logger.getLogger(PrescriptionBarcodeService.class.getName());

    private static final String BARCODE_OUTPUT_DIR =
            System.getProperty("barcode.output.dir", "barcodes");

    private static final boolean CACHE_ENABLED =
            Boolean.parseBoolean(System.getProperty("barcode.cache.enabled", "true"));

    // Cache for generated barcode metadata
    private final Map<String, BarcodeMetadata> barcodeCache = new ConcurrentHashMap<>();

    public PrescriptionBarcodeService() {
        logger.info("PrescriptionBarcodeService initialized");
        logger.info("Output directory: " + BARCODE_OUTPUT_DIR);
        logger.info("Cache enabled: " + CACHE_ENABLED);
    }

    /**
     * Generate barcodes for a prescription
     *
     * @param prescriptionData The prescription and patient data
     * @return Map containing paths to generated barcode files
     * @throws WriterException If barcode generation fails
     * @throws IOException If file I/O fails
     */
    public Map<String, String> generatePrescriptionBarcodes(Map<String, Object> prescriptionData)
            throws WriterException, IOException {

        // Validate data
        if (!validatePrescriptionData(prescriptionData)) {
            throw new IllegalArgumentException("Invalid prescription data");
        }

        String prescriptionId = (String) prescriptionData.get("prescriptionId");

        // Check cache
        if (CACHE_ENABLED && barcodeCache.containsKey(prescriptionId)) {
            BarcodeMetadata metadata = barcodeCache.get(prescriptionId);
            if (metadata.isValid()) {
                logger.info("Using cached barcode for prescription: " + prescriptionId);
                return metadata.getBarcodePaths();
            }
        }

        logger.info("Generating new barcodes for prescription: " + prescriptionId);

        // Generate barcodes
        Map<String, String> barcodes =
                PrescriptionBarcodeGenerator.generatePrescriptionBarcode(
                        mapToPrescriptionData(prescriptionData), BARCODE_OUTPUT_DIR);

        // Cache the result
        if (CACHE_ENABLED) {
            barcodeCache.put(prescriptionId, new BarcodeMetadata(prescriptionId, barcodes));
            logger.info("Barcode cached for prescription: " + prescriptionId);
        }

        return barcodes;
    }

    /**
     * Validate prescription data
     *
     * @param data The prescription data to validate
     * @return true if valid, false otherwise
     */
    public boolean validatePrescriptionData(Map<String, Object> data) {
        if (data == null || data.isEmpty()) {
            logger.warning("Prescription data is null or empty");
            return false;
        }

        String[] requiredFields = {
            "prescriptionId", "patientMrn", "firstName", "lastName", "drugName", "patientDob"
        };

        for (String field : requiredFields) {
            if (!data.containsKey(field) || data.get(field) == null) {
                logger.warning("Required field missing: " + field);
                return false;
            }
        }

        // Validate DOB format
        Object dobObj = data.get("patientDob");
        if (dobObj instanceof List) {
            List<?> dobList = (List<?>) dobObj;
            if (dobList.size() != 3) {
                logger.warning("Patient DOB must contain [year, month, day]");
                return false;
            }
        } else if (dobObj instanceof int[]) {
            int[] dobArray = (int[]) dobObj;
            if (dobArray.length != 3) {
                logger.warning("Patient DOB must contain [year, month, day]");
                return false;
            }
        } else {
            logger.warning("Patient DOB must be array or list format");
            return false;
        }

        return true;
    }

    /**
     * Get barcode file path
     *
     * @param prescriptionId The prescription ID
     * @param type The barcode type (code128 or qrcode)
     * @return Full path to the barcode file
     */
    public String getBarcodePath(String prescriptionId, String type) {
        String shortId = prescriptionId.substring(0, Math.min(8, prescriptionId.length()));
        String filename = String.format("prescription_%s_%s.png", shortId, type);
        return BARCODE_OUTPUT_DIR + "/" + filename;
    }

    /**
     * Get barcode generation status
     *
     * @param prescriptionId The prescription ID
     * @return Map containing status information
     */
    public Map<String, Object> getBarcodeStatus(String prescriptionId) {
        Map<String, Object> status = new LinkedHashMap<>();
        status.put("prescriptionId", prescriptionId);
        status.put("generated", false);
        status.put("timestamp", null);
        status.put("files", new HashMap<String, Object>());

        if (barcodeCache.containsKey(prescriptionId)) {
            BarcodeMetadata metadata = barcodeCache.get(prescriptionId);
            status.put("generated", metadata.isValid());
            status.put("timestamp", metadata.getGeneratedAt());

            Map<String, Object> files = new HashMap<>();
            for (Map.Entry<String, String> entry : metadata.getBarcodePaths().entrySet()) {
                boolean exists = Files.exists(Paths.get(entry.getValue()));
                files.put(entry.getKey(), Map.of("path", entry.getValue(), "exists", exists));
            }
            status.put("files", files);
        }

        return status;
    }

    /** Clear barcode cache */
    public void clearCache() {
        barcodeCache.clear();
        logger.info("Barcode cache cleared");
    }

    /**
     * Clear specific barcode from cache
     *
     * @param prescriptionId The prescription ID
     */
    public void clearCacheEntry(String prescriptionId) {
        barcodeCache.remove(prescriptionId);
        logger.info("Cache entry cleared for prescription: " + prescriptionId);
    }

    /**
     * Get cache statistics
     *
     * @return Map containing cache statistics
     */
    public Map<String, Object> getCacheStatistics() {
        Map<String, Object> stats = new LinkedHashMap<>();
        stats.put("cacheEnabled", CACHE_ENABLED);
        stats.put("cachedItems", barcodeCache.size());
        stats.put(
                "validItems",
                barcodeCache.values().stream().filter(BarcodeMetadata::isValid).count());
        stats.put("outputDirectory", BARCODE_OUTPUT_DIR);
        return stats;
    }

    /**
     * Convert Map to PrescriptionData object
     *
     * @param data The map data
     * @return PrescriptionData object
     */
    @SuppressWarnings("unchecked")
    private PrescriptionBarcodeGenerator.PrescriptionData mapToPrescriptionData(
            Map<String, Object> data) {
        PrescriptionBarcodeGenerator.PrescriptionData prescription =
                new PrescriptionBarcodeGenerator.PrescriptionData();

        prescription.prescriptionId = (String) data.getOrDefault("prescriptionId", "");
        prescription.issueDate = ((Number) data.getOrDefault("issueDate", 0L)).longValue();
        prescription.status = (String) data.getOrDefault("status", "");
        prescription.priority = (String) data.getOrDefault("priority", "");
        prescription.drugName = (String) data.getOrDefault("drugName", "");
        prescription.drugStrength = (String) data.getOrDefault("drugStrength", "");
        prescription.drugForm = (String) data.getOrDefault("drugForm", "");
        prescription.firstName = (String) data.getOrDefault("firstName", "");
        prescription.lastName = (String) data.getOrDefault("lastName", "");
        prescription.patientMrn = (String) data.getOrDefault("patientMrn", "");
        prescription.patientGender = (String) data.getOrDefault("patientGender", "");
        prescription.prescriberName = (String) data.getOrDefault("prescriberName", "");
        prescription.insuranceCompanyName = (String) data.getOrDefault("insuranceCompanyName", "");
        prescription.copayFixed = ((Number) data.getOrDefault("copayFixed", 0.0)).doubleValue();

        // Handle DOB conversion
        Object dobObj = data.get("patientDob");
        if (dobObj instanceof List) {
            List<Integer> dobList = (List<Integer>) dobObj;
            prescription.patientDob = new int[] {dobList.get(0), dobList.get(1), dobList.get(2)};
        } else if (dobObj instanceof int[]) {
            prescription.patientDob = (int[]) dobObj;
        }

        return prescription;
    }

    /** Inner class for barcode metadata and caching */
    public static class BarcodeMetadata {
        private final String prescriptionId;
        private final Map<String, String> barcodePaths;
        private final long generatedAt;
        private static final long CACHE_VALIDITY_MS = 24 * 60 * 60 * 1000; // 24 hours

        public BarcodeMetadata(String prescriptionId, Map<String, String> barcodePaths) {
            this.prescriptionId = prescriptionId;
            this.barcodePaths = new HashMap<>(barcodePaths);
            this.generatedAt = System.currentTimeMillis();
        }

        public boolean isValid() {
            return (System.currentTimeMillis() - generatedAt) < CACHE_VALIDITY_MS;
        }

        public String getPrescriptionId() {
            return prescriptionId;
        }

        public Map<String, String> getBarcodePaths() {
            return new HashMap<>(barcodePaths);
        }

        public long getGeneratedAt() {
            return generatedAt;
        }
    }
}
