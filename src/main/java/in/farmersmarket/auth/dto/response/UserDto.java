package in.farmersmarket.auth.dto.response;

import java.util.List;
import java.util.UUID;

public class UserDto {
    private UUID id;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String businessName;
    private String city;
    private String state;
    private boolean isActive;
    private boolean isVerified;
    private List<String> roles;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getBusinessName() { return businessName; }
    public void setBusinessName(String businessName) { this.businessName = businessName; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
    public boolean isVerified() { return isVerified; }
    public void setVerified(boolean verified) { isVerified = verified; }
    public List<String> getRoles() { return roles; }
    public void setRoles(List<String> roles) { this.roles = roles; }
}
