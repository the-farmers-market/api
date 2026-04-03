package in.farmersmarket.logistics.repository;

import in.farmersmarket.logistics.entity.DeliveryTracking;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class DeliveryTrackingRepository implements PanacheRepositoryBase<DeliveryTracking, UUID> {

    public List<DeliveryTracking> findByDeliveryId(UUID deliveryId) {
        return list("delivery.id ORDER BY createdAt DESC", deliveryId);
    }
}
