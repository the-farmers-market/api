package in.farmersmarket.auth.resource;

import in.farmersmarket.auth.dto.request.LoginRequest;
import in.farmersmarket.auth.dto.request.RegisterRequest;
import in.farmersmarket.auth.dto.response.AuthResponse;
import in.farmersmarket.auth.service.AuthService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/api/v1/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Auth")
public class AuthResource {

    @Inject AuthService authService;

    @POST
    @Path("/register")
    @Operation(summary = "Register a new user", description = "Creates a new user account with the specified role (BUYER, SELLER, ADMIN, LOGISTICS, LABOUR)")
    @APIResponse(responseCode = "201", description = "User registered successfully", content = @Content(schema = @Schema(implementation = AuthResponse.class)))
    @APIResponse(responseCode = "409", description = "Email or phone already exists")
    public Response register(RegisterRequest request) {
        AuthResponse response = authService.register(request);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @POST
    @Path("/login")
    @Operation(summary = "Login", description = "Authenticate with email and password, returns a JWT token")
    @APIResponse(responseCode = "200", description = "Login successful", content = @Content(schema = @Schema(implementation = AuthResponse.class)))
    @APIResponse(responseCode = "401", description = "Invalid credentials")
    public Response login(LoginRequest request) {
        AuthResponse response = authService.login(request);
        return Response.ok(response).build();
    }
}
