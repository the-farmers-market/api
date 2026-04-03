package in.farmersmarket.common.config;

import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@OpenAPIDefinition(
    info = @Info(
        title = "Farmers Market API",
        version = "1.0.0",
        description = "B2B agricultural ecommerce platform connecting farmers, buyers, logistics partners, and labour",
        contact = @Contact(name = "Farmers Market", url = "https://farmersmarket.in")
    ),
    tags = {
        @Tag(name = "Auth", description = "Registration, login, and OTP verification"),
        @Tag(name = "Products", description = "Product catalog management and approval workflow"),
        @Tag(name = "Categories", description = "Product category management"),
        @Tag(name = "RFQs", description = "Request for quotes and seller quoting"),
        @Tag(name = "Orders", description = "Order lifecycle and payment tracking"),
        @Tag(name = "Logistics", description = "Delivery management and tracking"),
        @Tag(name = "Labour", description = "Labour profiles, availability, and bookings"),
        @Tag(name = "Notifications", description = "User notifications")
    }
)
@SecurityScheme(
    securitySchemeName = "jwt",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "JWT"
)
public class OpenApiConfig extends Application {
}
