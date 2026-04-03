package in.farmersmarket.labour.entity;

import in.farmersmarket.auth.entity.UserEntity;
import in.farmersmarket.common.model.BaseEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "labour_bookings")
public class LabourBooking extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "labour_id", nullable = false)
    private LabourProfile labour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booked_by", nullable = false)
    private UserEntity bookedBy;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "total_cost", precision = 10, scale = 2)
    private BigDecimal totalCost;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private BookingStatus status = BookingStatus.PENDING;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    public LabourProfile getLabour() { return labour; }
    public void setLabour(LabourProfile labour) { this.labour = labour; }
    public UserEntity getBookedBy() { return bookedBy; }
    public void setBookedBy(UserEntity bookedBy) { this.bookedBy = bookedBy; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public BigDecimal getTotalCost() { return totalCost; }
    public void setTotalCost(BigDecimal totalCost) { this.totalCost = totalCost; }
    public BookingStatus getStatus() { return status; }
    public void setStatus(BookingStatus status) { this.status = status; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
