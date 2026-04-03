package in.farmersmarket.auth.dto.request;

public class SendOTPRequest {
    private String phone;
    private String email;
    private String country;
    private String purpose;

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }
}
