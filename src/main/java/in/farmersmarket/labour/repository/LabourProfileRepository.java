package in.farmersmarket.labour.repository;

import in.farmersmarket.labour.entity.AvailabilityStatus;
import in.farmersmarket.labour.entity.LabourProfile;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class LabourProfileRepository implements PanacheRepositoryBase<LabourProfile, UUID> {

    public Optional<LabourProfile> findByUserId(UUID userId) {
        return find("user.id", userId).firstResultOptional();
    }

    public List<LabourProfile> findAvailable() {
        return list("availabilityStatus", AvailabilityStatus.AVAILABLE);
    }

    public List<LabourProfile> findByServiceArea(String area) {
        return list("serviceArea", area);
    }
}
