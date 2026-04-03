package in.farmersmarket.auth.repository;

import in.farmersmarket.auth.entity.UserEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<UserEntity, UUID> {

    public Optional<UserEntity> findByEmail(String email) {
        return find("email", email).firstResultOptional();
    }

    public Optional<UserEntity> findByPhone(String phone) {
        return find("phone", phone).firstResultOptional();
    }

    public boolean existsByEmail(String email) {
        return count("email", email) > 0;
    }

    public boolean existsByPhone(String phone) {
        return count("phone", phone) > 0;
    }
}
