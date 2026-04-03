package in.farmersmarket.auth.entity;

import in.farmersmarket.common.model.BaseEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "otp_verifications")
public class OTPEntity extends BaseEntity {

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "country")
    private String country;

    @Column(name = "otp_code", nullable = false)
    private String otpCode;

    @Column(name = "purpose", nullable = false)
    private String purpose;

    @Column(name = "is_verified", nullable = false)
    private boolean isVerified = false;

    @Column(name = "expires_at", nullable = false)
    private LocalDateTime expiresAt;

    @Column(name = "attempts", nullable = false)
    private int attempts = 0;

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getOtpCode() { return otpCode; }
    public void setOtpCode(String otpCode) { this.otpCode = otpCode; }
    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }
    public boolean isVerified() { return isVerified; }
    public void setVerified(boolean verified) { isVerified = verified; }
    public LocalDateTime getExpiresAt() { return expiresAt; }
    public void setExpiresAt(LocalDateTime expiresAt) { this.expiresAt = expiresAt; }
    public int getAttempts() { return attempts; }
    public void setAttempts(int attempts) { this.attempts = attempts; }
}
