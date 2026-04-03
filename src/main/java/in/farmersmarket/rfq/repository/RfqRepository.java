package in.farmersmarket.rfq.repository;

import in.farmersmarket.rfq.entity.Rfq;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class RfqRepository implements PanacheRepositoryBase<Rfq, UUID> {

    public List<Rfq> findByBuyerId(UUID buyerId) {
        return list("buyer.id", buyerId);
    }

    public List<Rfq> findByProductSellerId(UUID sellerId) {
        return list("product.seller.id", sellerId);
    }
}
