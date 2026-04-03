package in.farmersmarket.auth.repository;

import in.farmersmarket.auth.entity.RoleEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class RoleRepository implements PanacheRepositoryBase<RoleEntity, UUID> {

    public Optional<RoleEntity> findByName(String name) {
        return find("name", name).firstResultOptional();
    }
}
