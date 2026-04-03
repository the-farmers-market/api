package in.farmersmarket.order.entity;

import in.farmersmarket.catalog.entity.ProductVariant;
import in.farmersmarket.common.model.BaseEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
public class OrderItem extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_variant_id", nullable = false)
    private ProductVariant productVariant;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price_per_unit", precision = 12, scale = 2, nullable = false)
    private BigDecimal pricePerUnit;

    @Column(name = "subtotal", precision = 12, scale = 2, nullable = false)
    private BigDecimal subtotal;

    public OrderEntity getOrder() { return order; }
    public void setOrder(OrderEntity order) { this.order = order; }
    public ProductVariant getProductVariant() { return productVariant; }
    public void setProductVariant(ProductVariant productVariant) { this.productVariant = productVariant; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public BigDecimal getPricePerUnit() { return pricePerUnit; }
    public void setPricePerUnit(BigDecimal pricePerUnit) { this.pricePerUnit = pricePerUnit; }
    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
}
