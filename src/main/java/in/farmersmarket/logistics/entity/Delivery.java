package in.farmersmarket.logistics.entity;

import in.farmersmarket.auth.entity.UserEntity;
import in.farmersmarket.common.model.BaseEntity;
import in.farmersmarket.order.entity.OrderEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "deliveries")
public class Delivery extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_id")
    private UserEntity partner;

    @Column(name = "pickup_address", columnDefinition = "TEXT")
    private String pickupAddress;

    @Column(name = "delivery_address", columnDefinition = "TEXT")
    private String deliveryAddress;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status = DeliveryStatus.ASSIGNED;

    @Column(name = "estimated_delivery")
    private LocalDateTime estimatedDelivery;

    @Column(name = "actual_delivery")
    private LocalDateTime actualDelivery;

    public OrderEntity getOrder() { return order; }
    public void setOrder(OrderEntity order) { this.order = order; }
    public UserEntity getPartner() { return partner; }
    public void setPartner(UserEntity partner) { this.partner = partner; }
    public String getPickupAddress() { return pickupAddress; }
    public void setPickupAddress(String pickupAddress) { this.pickupAddress = pickupAddress; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }
    public DeliveryStatus getStatus() { return status; }
    public void setStatus(DeliveryStatus status) { this.status = status; }
    public LocalDateTime getEstimatedDelivery() { return estimatedDelivery; }
    public void setEstimatedDelivery(LocalDateTime estimatedDelivery) { this.estimatedDelivery = estimatedDelivery; }
    public LocalDateTime getActualDelivery() { return actualDelivery; }
    public void setActualDelivery(LocalDateTime actualDelivery) { this.actualDelivery = actualDelivery; }
}
