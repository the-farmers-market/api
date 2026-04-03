package in.farmersmarket.notification.resource;

import in.farmersmarket.notification.repository.NotificationRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Map;
import java.util.UUID;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/api/v1/notifications")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Notifications")
@SecurityRequirement(name = "jwt")
@RolesAllowed({"BUYER", "SELLER", "ADMIN", "LOGISTICS", "LABOUR"})
public class NotificationResource {

    @Inject NotificationRepository notificationRepository;

    @GET
    @Path("/user/{userId}")
    @Operation(summary = "List notifications for a user", description = "Returns all notifications, newest first")
    public Response listByUser(@PathParam("userId") UUID userId) {
        return Response.ok(notificationRepository.findByUserId(userId)).build();
    }

    @GET
    @Path("/user/{userId}/unread")
    @Operation(summary = "List unread notifications")
    public Response listUnread(@PathParam("userId") UUID userId) {
        return Response.ok(notificationRepository.findUnreadByUserId(userId)).build();
    }

    @GET
    @Path("/user/{userId}/unread/count")
    @Operation(summary = "Count unread notifications")
    public Response countUnread(@PathParam("userId") UUID userId) {
        long count = notificationRepository.countUnreadByUserId(userId);
        return Response.ok(Map.of("count", count)).build();
    }

    @PUT
    @Path("/{id}/read")
    @Transactional
    @Operation(summary = "Mark notification as read")
    public Response markAsRead(@PathParam("id") UUID id) {
        return notificationRepository.findByIdOptional(id)
                .map(n -> {
                    n.setRead(true);
                    return Response.ok(n).build();
                })
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }
}
