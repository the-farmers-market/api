package in.farmersmarket.catalog.entity;

import in.farmersmarket.common.model.BaseEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product_variants")
public class ProductVariant extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "sku", unique = true)
    private String sku;

    @Column(name = "price_per_unit", precision = 12, scale = 2, nullable = false)
    private BigDecimal pricePerUnit;

    @Column(name = "stock_qty")
    private Integer stockQty;

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }
    public BigDecimal getPricePerUnit() { return pricePerUnit; }
    public void setPricePerUnit(BigDecimal pricePerUnit) { this.pricePerUnit = pricePerUnit; }
    public Integer getStockQty() { return stockQty; }
    public void setStockQty(Integer stockQty) { this.stockQty = stockQty; }
}
