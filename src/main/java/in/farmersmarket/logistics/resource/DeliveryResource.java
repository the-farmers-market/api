package in.farmersmarket.logistics.resource;

import in.farmersmarket.logistics.repository.DeliveryRepository;
import in.farmersmarket.logistics.repository.DeliveryTrackingRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.UUID;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/api/v1/deliveries")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Logistics")
@SecurityRequirement(name = "jwt")
public class DeliveryResource {

    @Inject DeliveryRepository deliveryRepository;
    @Inject DeliveryTrackingRepository trackingRepository;

    @GET
    @Path("/order/{orderId}")
    @RolesAllowed({"BUYER", "SELLER", "LOGISTICS", "ADMIN"})
    @Operation(summary = "Get delivery by order ID", description = "Returns the delivery record for a specific order")
    public Response getByOrder(@PathParam("orderId") UUID orderId) {
        return deliveryRepository.findByOrderId(orderId)
                .map(d -> Response.ok(d).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @GET
    @Path("/partner/{partnerId}")
    @RolesAllowed({"LOGISTICS", "ADMIN"})
    @Operation(summary = "List deliveries by partner", description = "Returns all deliveries assigned to a logistics partner")
    public Response listByPartner(@PathParam("partnerId") UUID partnerId) {
        return Response.ok(deliveryRepository.findByPartnerId(partnerId)).build();
    }

    @GET
    @Path("/{deliveryId}/tracking")
    @RolesAllowed({"BUYER", "SELLER", "LOGISTICS", "ADMIN"})
    @Operation(summary = "Get delivery tracking history", description = "Returns all tracking events for a delivery, newest first")
    public Response getTracking(@PathParam("deliveryId") UUID deliveryId) {
        return Response.ok(trackingRepository.findByDeliveryId(deliveryId)).build();
    }
}
