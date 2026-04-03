package in.farmersmarket.auth;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AuthResourceTest {

    @Test
    public void testRegisterEndpoint() {
        given()
            .contentType("application/json")
            .body("{\"email\":\"test@test.com\",\"password\":\"test123\",\"firstName\":\"Test\",\"lastName\":\"User\",\"role\":\"BUYER\"}")
            .when().post("/api/v1/auth/register")
            .then()
            .statusCode(201);
    }
}
