package in.farmersmarket.catalog.entity;

import in.farmersmarket.auth.entity.UserEntity;
import in.farmersmarket.common.model.BaseEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    private UserEntity seller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "slug", unique = true, nullable = false)
    private String slug;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "unit", nullable = false)
    private String unit;

    @Column(name = "price_per_unit", precision = 12, scale = 2)
    private BigDecimal pricePerUnit;

    @Column(name = "min_order_qty")
    private Integer minOrderQty;

    @Column(name = "images", columnDefinition = "TEXT")
    private String images;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductStatus status = ProductStatus.PENDING;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approved_by")
    private UserEntity approvedBy;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductVariant> variants = new ArrayList<>();

    public UserEntity getSeller() { return seller; }
    public void setSeller(UserEntity seller) { this.seller = seller; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
    public BigDecimal getPricePerUnit() { return pricePerUnit; }
    public void setPricePerUnit(BigDecimal pricePerUnit) { this.pricePerUnit = pricePerUnit; }
    public Integer getMinOrderQty() { return minOrderQty; }
    public void setMinOrderQty(Integer minOrderQty) { this.minOrderQty = minOrderQty; }
    public String getImages() { return images; }
    public void setImages(String images) { this.images = images; }
    public ProductStatus getStatus() { return status; }
    public void setStatus(ProductStatus status) { this.status = status; }
    public UserEntity getApprovedBy() { return approvedBy; }
    public void setApprovedBy(UserEntity approvedBy) { this.approvedBy = approvedBy; }
    public List<ProductVariant> getVariants() { return variants; }
    public void setVariants(List<ProductVariant> variants) { this.variants = variants; }
}
