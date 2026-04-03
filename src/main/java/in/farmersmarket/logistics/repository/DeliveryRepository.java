package in.farmersmarket.logistics.repository;

import in.farmersmarket.logistics.entity.Delivery;
import in.farmersmarket.logistics.entity.DeliveryStatus;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class DeliveryRepository implements PanacheRepositoryBase<Delivery, UUID> {

    public Optional<Delivery> findByOrderId(UUID orderId) {
        return find("order.id", orderId).firstResultOptional();
    }

    public List<Delivery> findByPartnerId(UUID partnerId) {
        return list("partner.id", partnerId);
    }

    public List<Delivery> findByStatus(DeliveryStatus status) {
        return list("status", status);
    }
}
