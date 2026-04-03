package in.farmersmarket.logistics.entity;

import in.farmersmarket.common.model.BaseEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "delivery_tracking")
public class DeliveryTracking extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id", nullable = false)
    private Delivery delivery;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @Column(name = "location_lat", precision = 10, scale = 7)
    private BigDecimal locationLat;

    @Column(name = "location_lng", precision = 10, scale = 7)
    private BigDecimal locationLng;

    @Column(name = "notes")
    private String notes;

    public Delivery getDelivery() { return delivery; }
    public void setDelivery(Delivery delivery) { this.delivery = delivery; }
    public DeliveryStatus getStatus() { return status; }
    public void setStatus(DeliveryStatus status) { this.status = status; }
    public BigDecimal getLocationLat() { return locationLat; }
    public void setLocationLat(BigDecimal locationLat) { this.locationLat = locationLat; }
    public BigDecimal getLocationLng() { return locationLng; }
    public void setLocationLng(BigDecimal locationLng) { this.locationLng = locationLng; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
