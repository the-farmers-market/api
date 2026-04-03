package in.farmersmarket.order.entity;

import in.farmersmarket.auth.entity.UserEntity;
import in.farmersmarket.common.model.BaseEntity;
import in.farmersmarket.rfq.entity.Quote;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id", nullable = false)
    private UserEntity buyer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    private UserEntity seller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quote_id")
    private Quote quote;

    @Column(name = "order_number", unique = true, nullable = false)
    private String orderNumber;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PLACED;

    @Column(name = "total_amount", precision = 12, scale = 2, nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "payment_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    @Column(name = "delivery_address", columnDefinition = "TEXT")
    private String deliveryAddress;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    public UserEntity getBuyer() { return buyer; }
    public void setBuyer(UserEntity buyer) { this.buyer = buyer; }
    public UserEntity getSeller() { return seller; }
    public void setSeller(UserEntity seller) { this.seller = seller; }
    public Quote getQuote() { return quote; }
    public void setQuote(Quote quote) { this.quote = quote; }
    public String getOrderNumber() { return orderNumber; }
    public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    public PaymentStatus getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(PaymentStatus paymentStatus) { this.paymentStatus = paymentStatus; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }
    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }
}
