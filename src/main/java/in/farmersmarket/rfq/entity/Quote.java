package in.farmersmarket.rfq.entity;

import in.farmersmarket.auth.entity.UserEntity;
import in.farmersmarket.common.model.BaseEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "quotes")
public class Quote extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rfq_id", nullable = false)
    private Rfq rfq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    private UserEntity seller;

    @Column(name = "price_per_unit", precision = 12, scale = 2, nullable = false)
    private BigDecimal pricePerUnit;

    @Column(name = "total_price", precision = 12, scale = 2, nullable = false)
    private BigDecimal totalPrice;

    @Column(name = "valid_until")
    private LocalDateTime validUntil;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private QuoteStatus status = QuoteStatus.PENDING;

    public Rfq getRfq() { return rfq; }
    public void setRfq(Rfq rfq) { this.rfq = rfq; }
    public UserEntity getSeller() { return seller; }
    public void setSeller(UserEntity seller) { this.seller = seller; }
    public BigDecimal getPricePerUnit() { return pricePerUnit; }
    public void setPricePerUnit(BigDecimal pricePerUnit) { this.pricePerUnit = pricePerUnit; }
    public BigDecimal getTotalPrice() { return totalPrice; }
    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }
    public LocalDateTime getValidUntil() { return validUntil; }
    public void setValidUntil(LocalDateTime validUntil) { this.validUntil = validUntil; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public QuoteStatus getStatus() { return status; }
    public void setStatus(QuoteStatus status) { this.status = status; }
}
