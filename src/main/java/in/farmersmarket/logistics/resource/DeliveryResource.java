package in.farmersmarket.logistics.resource;

import in.farmersmarket.logistics.repository.DeliveryRepository;
import in.farmersmarket.logistics.repository.DeliveryTrackingRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.UUID;

@Path("/api/v1/deliveries")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeliveryResource {

    @Inject DeliveryRepository deliveryRepository;
    @Inject DeliveryTrackingRepository trackingRepository;

    @GET
    @Path("/order/{orderId}")
    @RolesAllowed({"BUYER", "SELLER", "LOGISTICS", "ADMIN"})
    public Response getByOrder(@PathParam("orderId") UUID orderId) {
        return deliveryRepository.findByOrderId(orderId)
                .map(d -> Response.ok(d).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @GET
    @Path("/partner/{partnerId}")
    @RolesAllowed({"LOGISTICS", "ADMIN"})
    public Response listByPartner(@PathParam("partnerId") UUID partnerId) {
        return Response.ok(deliveryRepository.findByPartnerId(partnerId)).build();
    }

    @GET
    @Path("/{deliveryId}/tracking")
    @RolesAllowed({"BUYER", "SELLER", "LOGISTICS", "ADMIN"})
    public Response getTracking(@PathParam("deliveryId") UUID deliveryId) {
        return Response.ok(trackingRepository.findByDeliveryId(deliveryId)).build();
    }
}
