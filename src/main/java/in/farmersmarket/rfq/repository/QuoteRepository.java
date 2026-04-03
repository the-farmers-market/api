package in.farmersmarket.rfq.repository;

import in.farmersmarket.rfq.entity.Quote;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class QuoteRepository implements PanacheRepositoryBase<Quote, UUID> {

    public List<Quote> findByRfqId(UUID rfqId) {
        return list("rfq.id", rfqId);
    }

    public List<Quote> findBySellerId(UUID sellerId) {
        return list("seller.id", sellerId);
    }
}
