package in.farmersmarket.rfq.entity;

import in.farmersmarket.auth.entity.UserEntity;
import in.farmersmarket.catalog.entity.Product;
import in.farmersmarket.common.model.BaseEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "rfqs")
public class Rfq extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id", nullable = false)
    private UserEntity buyer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "desired_price", precision = 12, scale = 2)
    private BigDecimal desiredPrice;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(name = "delivery_location")
    private String deliveryLocation;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private RfqStatus status = RfqStatus.OPEN;

    public UserEntity getBuyer() { return buyer; }
    public void setBuyer(UserEntity buyer) { this.buyer = buyer; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public BigDecimal getDesiredPrice() { return desiredPrice; }
    public void setDesiredPrice(BigDecimal desiredPrice) { this.desiredPrice = desiredPrice; }
    public LocalDate getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(LocalDate deliveryDate) { this.deliveryDate = deliveryDate; }
    public String getDeliveryLocation() { return deliveryLocation; }
    public void setDeliveryLocation(String deliveryLocation) { this.deliveryLocation = deliveryLocation; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public RfqStatus getStatus() { return status; }
    public void setStatus(RfqStatus status) { this.status = status; }
}
