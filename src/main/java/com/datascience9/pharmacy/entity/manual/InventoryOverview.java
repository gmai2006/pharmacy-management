package com.datascience9.pharmacy.entity.manual;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * Read-only view entity for v_inventory_overview combining inventory_items, inventory_batches, and
 * reorder_rules with calculated fields. This entity is immutable and designed for querying
 * aggregated inventory data.
 */
@Entity
@Table(name = "v_inventory_overview")
@Immutable
public class InventoryOverview {

    // ==================== Composite Key Setup ====================
    /**
     * Using a composite key of itemId and batchId since the view can have multiple rows per item
     * (one per batch)
     */
    @Id
    @Column(name = "item_id")
    private UUID itemId;

    @Column(name = "batch_id", nullable = false)
    private UUID batchId;

    // ==================== Inventory Item Fields ====================
    @Column(name = "ndc")
    private String ndc;

    @Column(name = "sku")
    private String sku;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "strength")
    private String strength;

    @Column(name = "form")
    private String form;

    @Column(name = "pack_size")
    private Integer packSize;

    @Column(name = "attributes")
    @JdbcTypeCode(SqlTypes.JSON)
    private JsonNode attributes;

    // ==================== Inventory Batch Fields ====================
    @Column(name = "lot_number")
    private String lotNumber;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "quantity_on_hand")
    private Integer quantityOnHand;

    @Column(name = "location")
    private String location;

    @Column(name = "wholesaler_id")
    private Integer wholesalerId;

    @Column(name = "last_order")
    private Instant lastOrder;

    // ==================== Reorder Rule Fields ====================
    @Column(name = "min_level")
    private Integer minLevel;

    @Column(name = "max_level")
    private Integer maxLevel;

    @Column(name = "preferred_wholesalers")
    @JdbcTypeCode(SqlTypes.ARRAY)
    private Integer[] preferredWholesalers;

    // ==================== Calculated Fields - Expiry ====================
    @Column(name = "days_until_expiry")
    private Integer daysUntilExpiry;

    @Column(name = "expiry_status")
    @Enumerated(EnumType.STRING)
    private ExpiryStatus expiryStatus;

    // ==================== Calculated Fields - Reorder ====================
    @Column(name = "needs_reorder")
    private Boolean needsReorder;

    @Column(name = "reorder_quantity")
    private Integer reorderQuantity;

    // ==================== Calculated Fields - Order Frequency ====================
    @Column(name = "days_since_last_order")
    private Integer daysSinceLastOrder;

    @Column(name = "order_frequency_status")
    @Enumerated(EnumType.STRING)
    private OrderFrequencyStatus orderFrequencyStatus;

    // ==================== Timestamp Fields ====================
    @Column(name = "item_created_at")
    private Instant itemCreatedAt;

    @Column(name = "batch_created_at")
    private Instant batchCreatedAt;

    // ==================== Constructors ====================
    public InventoryOverview() {}

    // ==================== Getters ====================
    public UUID getItemId() {
        return itemId;
    }

    public UUID getBatchId() {
        return batchId;
    }

    public String getNdc() {
        return ndc;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public String getStrength() {
        return strength;
    }

    public String getForm() {
        return form;
    }

    public Integer getPackSize() {
        return packSize;
    }

    public JsonNode getAttributes() {
        return attributes;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public Integer getQuantityOnHand() {
        return quantityOnHand;
    }

    public String getLocation() {
        return location;
    }

    public Integer getWholesalerId() {
        return wholesalerId;
    }

    public Instant getLastOrder() {
        return lastOrder;
    }

    public Integer getMinLevel() {
        return minLevel;
    }

    public Integer getMaxLevel() {
        return maxLevel;
    }

    public Integer[] getPreferredWholesalers() {
        return preferredWholesalers;
    }

    public Integer getDaysUntilExpiry() {
        return daysUntilExpiry;
    }

    public ExpiryStatus getExpiryStatus() {
        return expiryStatus;
    }

    public Boolean getNeedsReorder() {
        return needsReorder;
    }

    public Integer getReorderQuantity() {
        return reorderQuantity;
    }

    public Integer getDaysSinceLastOrder() {
        return daysSinceLastOrder;
    }

    public OrderFrequencyStatus getOrderFrequencyStatus() {
        return orderFrequencyStatus;
    }

    public Instant getItemCreatedAt() {
        return itemCreatedAt;
    }

    public Instant getBatchCreatedAt() {
        return batchCreatedAt;
    }

    // ==================== Enums ====================
    /** Enum representing the expiry status of an inventory batch */
    public enum ExpiryStatus {
        URGENT, // Less than 30 days until expiry
        WARNING, // 30-89 days until expiry
        OK, // 90+ days until expiry
        NO_EXPIRY // No expiry date set
    }

    /** Enum representing how frequently an item has been ordered */
    public enum OrderFrequencyStatus {
        NEVER_ORDERED, // Item has never been ordered
        RECENTLY_ORDERED, // Ordered less than 7 days ago
        ORDERED_THIS_MONTH, // Ordered 7-29 days ago
        ORDERED_THIS_QUARTER, // Ordered 30-89 days ago
        LONG_TIME_AGO // Ordered 90+ days ago
    }

    // ==================== toString ====================
    @Override
    public String toString() {
        return "InventoryOverviewEntity{"
                + "itemId="
                + itemId
                + ", batchId="
                + batchId
                + ", name='"
                + name
                + '\''
                + ", sku='"
                + sku
                + '\''
                + ", lotNumber='"
                + lotNumber
                + '\''
                + ", quantityOnHand="
                + quantityOnHand
                + ", needsReorder="
                + needsReorder
                + ", expiryStatus="
                + expiryStatus
                + ", orderFrequencyStatus="
                + orderFrequencyStatus
                + ", daysUntilExpiry="
                + daysUntilExpiry
                + ", daysSinceLastOrder="
                + daysSinceLastOrder
                + '}';
    }

    // ==================== Helper Methods ====================
    /** Checks if the item is critically low and needs immediate reorder */
    public boolean isCriticalReorder() {
        return needsReorder && daysUntilExpiry != null && daysUntilExpiry < 30;
    }

    /** Checks if the item has been recently ordered */
    public boolean isRecentlyOrdered() {
        return orderFrequencyStatus == OrderFrequencyStatus.RECENTLY_ORDERED
                || orderFrequencyStatus == OrderFrequencyStatus.ORDERED_THIS_MONTH;
    }

    /** Calculates the percentage of max level currently in stock */
    public double getStockPercentage() {
        if (maxLevel == null || maxLevel == 0) {
            return 0;
        }
        return (double) quantityOnHand / maxLevel * 100;
    }

    /** Checks if batch is expiring soon */
    public boolean isExpiringCritical() {
        return expiryStatus == ExpiryStatus.URGENT;
    }
}
