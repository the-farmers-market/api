package in.farmersmarket.auth.dto.request;

public class VerifyOTPRequest {
    private String phone;
    private String email;
    private String country;
    private String otpCode;

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getOtpCode() { return otpCode; }
    public void setOtpCode(String otpCode) { this.otpCode = otpCode; }
}
