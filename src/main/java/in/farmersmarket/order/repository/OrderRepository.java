package in.farmersmarket.order.repository;

import in.farmersmarket.order.entity.OrderEntity;
import in.farmersmarket.order.entity.OrderStatus;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class OrderRepository implements PanacheRepositoryBase<OrderEntity, UUID> {

    public List<OrderEntity> findByBuyerId(UUID buyerId) {
        return list("buyer.id", buyerId);
    }

    public List<OrderEntity> findBySellerId(UUID sellerId) {
        return list("seller.id", sellerId);
    }

    public List<OrderEntity> findByStatus(OrderStatus status) {
        return list("status", status);
    }
}
