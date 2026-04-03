package in.farmersmarket.labour.entity;

import in.farmersmarket.auth.entity.UserEntity;
import in.farmersmarket.common.model.BaseEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "labour_profiles")
public class LabourProfile extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private UserEntity user;

    @Column(name = "skills", columnDefinition = "TEXT")
    private String skills;

    @Column(name = "experience_years")
    private Integer experienceYears;

    @Column(name = "daily_rate", precision = 10, scale = 2)
    private BigDecimal dailyRate;

    @Column(name = "availability_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private AvailabilityStatus availabilityStatus = AvailabilityStatus.AVAILABLE;

    @Column(name = "service_area")
    private String serviceArea;

    public UserEntity getUser() { return user; }
    public void setUser(UserEntity user) { this.user = user; }
    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }
    public Integer getExperienceYears() { return experienceYears; }
    public void setExperienceYears(Integer experienceYears) { this.experienceYears = experienceYears; }
    public BigDecimal getDailyRate() { return dailyRate; }
    public void setDailyRate(BigDecimal dailyRate) { this.dailyRate = dailyRate; }
    public AvailabilityStatus getAvailabilityStatus() { return availabilityStatus; }
    public void setAvailabilityStatus(AvailabilityStatus availabilityStatus) { this.availabilityStatus = availabilityStatus; }
    public String getServiceArea() { return serviceArea; }
    public void setServiceArea(String serviceArea) { this.serviceArea = serviceArea; }
}
