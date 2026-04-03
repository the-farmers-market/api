package in.farmersmarket.order.resource;

import in.farmersmarket.order.entity.OrderStatus;
import in.farmersmarket.order.repository.OrderRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.UUID;

@Path("/api/v1/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    @Inject OrderRepository orderRepository;

    @GET
    @Path("/buyer/{buyerId}")
    @RolesAllowed({"BUYER", "ADMIN"})
    public Response listByBuyer(@PathParam("buyerId") UUID buyerId) {
        return Response.ok(orderRepository.findByBuyerId(buyerId)).build();
    }

    @GET
    @Path("/seller/{sellerId}")
    @RolesAllowed({"SELLER", "ADMIN"})
    public Response listBySeller(@PathParam("sellerId") UUID sellerId) {
        return Response.ok(orderRepository.findBySellerId(sellerId)).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"BUYER", "SELLER", "ADMIN"})
    public Response getById(@PathParam("id") UUID id) {
        return orderRepository.findByIdOptional(id)
                .map(order -> Response.ok(order).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @GET
    @Path("/status/{status}")
    @RolesAllowed("ADMIN")
    public Response listByStatus(@PathParam("status") OrderStatus status) {
        return Response.ok(orderRepository.findByStatus(status)).build();
    }
}
