package in.farmersmarket.auth.entity;

import in.farmersmarket.common.model.BaseEntity;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone", unique = true)
    private String phone;

    @Column(name = "country")
    private String country;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "gst_number")
    private String gstNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    @Column(name = "is_verified", nullable = false)
    private boolean isVerified = false;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<UserRoleEntity> userRoles = new HashSet<>();

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getBusinessName() { return businessName; }
    public void setBusinessName(String businessName) { this.businessName = businessName; }
    public String getGstNumber() { return gstNumber; }
    public void setGstNumber(String gstNumber) { this.gstNumber = gstNumber; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getPincode() { return pincode; }
    public void setPincode(String pincode) { this.pincode = pincode; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
    public boolean isVerified() { return isVerified; }
    public void setVerified(boolean verified) { isVerified = verified; }
    public Set<UserRoleEntity> getUserRoles() { return userRoles; }
    public void setUserRoles(Set<UserRoleEntity> userRoles) { this.userRoles = userRoles; }
}
