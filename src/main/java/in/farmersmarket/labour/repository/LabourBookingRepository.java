package in.farmersmarket.labour.repository;

import in.farmersmarket.labour.entity.LabourBooking;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class LabourBookingRepository implements PanacheRepositoryBase<LabourBooking, UUID> {

    public List<LabourBooking> findByLabourId(UUID labourId) {
        return list("labour.id", labourId);
    }

    public List<LabourBooking> findByBookedBy(UUID userId) {
        return list("bookedBy.id", userId);
    }
}
