package in.farmersmarket.labour.resource;

import in.farmersmarket.labour.repository.LabourBookingRepository;
import in.farmersmarket.labour.repository.LabourProfileRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.UUID;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/api/v1/labour")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Labour")
public class LabourResource {

    @Inject LabourProfileRepository profileRepository;
    @Inject LabourBookingRepository bookingRepository;

    @GET
    @Path("/available")
    @Operation(summary = "List available labour", description = "Returns all labour profiles with AVAILABLE status")
    public Response listAvailable() {
        return Response.ok(profileRepository.findAvailable()).build();
    }

    @GET
    @Path("/profile/{userId}")
    @Operation(summary = "Get labour profile by user ID")
    public Response getProfile(@PathParam("userId") UUID userId) {
        return profileRepository.findByUserId(userId)
                .map(p -> Response.ok(p).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @GET
    @Path("/area/{area}")
    @Operation(summary = "List labour by service area", description = "Returns labour profiles serving a specific area")
    public Response listByArea(@PathParam("area") String area) {
        return Response.ok(profileRepository.findByServiceArea(area)).build();
    }

    @GET
    @Path("/bookings/labour/{labourId}")
    @RolesAllowed({"LABOUR", "ADMIN"})
    @Operation(summary = "List bookings for a labourer")
    @SecurityRequirement(name = "jwt")
    public Response listBookingsByLabour(@PathParam("labourId") UUID labourId) {
        return Response.ok(bookingRepository.findByLabourId(labourId)).build();
    }

    @GET
    @Path("/bookings/user/{userId}")
    @RolesAllowed({"BUYER", "SELLER", "ADMIN"})
    @Operation(summary = "List bookings made by a user")
    @SecurityRequirement(name = "jwt")
    public Response listBookingsByUser(@PathParam("userId") UUID userId) {
        return Response.ok(bookingRepository.findByBookedBy(userId)).build();
    }
}
