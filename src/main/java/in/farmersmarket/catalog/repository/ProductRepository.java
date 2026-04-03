package in.farmersmarket.catalog.repository;

import in.farmersmarket.catalog.entity.Product;
import in.farmersmarket.catalog.entity.ProductStatus;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ProductRepository implements PanacheRepositoryBase<Product, UUID> {

    public List<Product> findBySellerId(UUID sellerId) {
        return list("seller.id", sellerId);
    }

    public List<Product> findByStatus(ProductStatus status) {
        return list("status", status);
    }

    public List<Product> findApproved() {
        return list("status", ProductStatus.APPROVED);
    }

    public List<Product> findByCategoryId(UUID categoryId) {
        return list("category.id = ?1 AND status = ?2", categoryId, ProductStatus.APPROVED);
    }
}
