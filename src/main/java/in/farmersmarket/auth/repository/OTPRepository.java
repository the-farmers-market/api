package in.farmersmarket.auth.repository;

import in.farmersmarket.auth.entity.OTPEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class OTPRepository implements PanacheRepositoryBase<OTPEntity, UUID> {

    public Optional<OTPEntity> findLatestByPhone(String phone, String purpose) {
        return find("phone = ?1 AND purpose = ?2 AND isVerified = false ORDER BY createdAt DESC",
                phone, purpose).firstResultOptional();
    }

    public Optional<OTPEntity> findLatestByEmail(String email, String purpose) {
        return find("email = ?1 AND purpose = ?2 AND isVerified = false ORDER BY createdAt DESC",
                email, purpose).firstResultOptional();
    }
}
