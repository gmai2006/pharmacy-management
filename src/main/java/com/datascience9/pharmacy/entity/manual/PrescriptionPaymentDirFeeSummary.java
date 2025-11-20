package com.datascience9.pharmacy.entity.manual;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "v_prescription_payment_dir_fee_summary")
@Immutable // Optional (Hibernate); marks it as read-only
public class PrescriptionPaymentDirFeeSummary {

    @Id
    @Column(name = "prescription_id", nullable = false)
    private UUID prescriptionId;

    @Column(name = "total_pos_amount")
    private BigDecimal totalPosAmount;

    @Column(name = "pos_created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private OffsetDateTime posCreatedAt;

    @Column(name = "total_payments")
    private BigDecimal totalPayments;

    @Column(name = "total_dir_fees")
    private BigDecimal totalDirFees;

    @Column(name = "net_after_dir_fees")
    private BigDecimal netAfterDirFees;

    // --- Getters and Setters ---

    public UUID getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(UUID prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public BigDecimal getTotalPosAmount() {
        return totalPosAmount;
    }

    public void setTotalPosAmount(BigDecimal totalPosAmount) {
        this.totalPosAmount = totalPosAmount;
    }

    public OffsetDateTime getPosCreatedAt() {
        return posCreatedAt;
    }

    public void setPosCreatedAt(OffsetDateTime posCreatedAt) {
        this.posCreatedAt = posCreatedAt;
    }

    public BigDecimal getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(BigDecimal totalPayments) {
        this.totalPayments = totalPayments;
    }

    public BigDecimal getTotalDirFees() {
        return totalDirFees;
    }

    public void setTotalDirFees(BigDecimal totalDirFees) {
        this.totalDirFees = totalDirFees;
    }

    public BigDecimal getNetAfterDirFees() {
        return netAfterDirFees;
    }

    public void setNetAfterDirFees(BigDecimal netAfterDirFees) {
        this.netAfterDirFees = netAfterDirFees;
    }
}
