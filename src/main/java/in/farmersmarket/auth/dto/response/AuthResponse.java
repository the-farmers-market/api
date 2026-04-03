package in.farmersmarket.auth.dto.response;

import java.util.List;

public class AuthResponse {
    private String token;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private List<String> roles;

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public List<String> getRoles() { return roles; }
    public void setRoles(List<String> roles) { this.roles = roles; }
}
