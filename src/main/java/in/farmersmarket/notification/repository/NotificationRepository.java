package in.farmersmarket.notification.repository;

import in.farmersmarket.notification.entity.Notification;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class NotificationRepository implements PanacheRepositoryBase<Notification, UUID> {

    public List<Notification> findByUserId(UUID userId) {
        return list("user.id ORDER BY createdAt DESC", userId);
    }

    public List<Notification> findUnreadByUserId(UUID userId) {
        return list("user.id = ?1 AND isRead = false ORDER BY createdAt DESC", userId);
    }

    public long countUnreadByUserId(UUID userId) {
        return count("user.id = ?1 AND isRead = false", userId);
    }
}
