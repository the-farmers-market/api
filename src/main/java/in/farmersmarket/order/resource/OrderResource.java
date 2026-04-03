package in.farmersmarket.order.resource;

import in.farmersmarket.order.entity.OrderStatus;
import in.farmersmarket.order.repository.OrderRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.UUID;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/api/v1/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Orders")
@SecurityRequirement(name = "jwt")
public class OrderResource {

    @Inject OrderRepository orderRepository;

    @GET
    @Path("/buyer/{buyerId}")
    @RolesAllowed({"BUYER", "ADMIN"})
    @Operation(summary = "List orders by buyer")
    public Response listByBuyer(@PathParam("buyerId") UUID buyerId) {
        return Response.ok(orderRepository.findByBuyerId(buyerId)).build();
    }

    @GET
    @Path("/seller/{sellerId}")
    @RolesAllowed({"SELLER", "ADMIN"})
    @Operation(summary = "List orders by seller")
    public Response listBySeller(@PathParam("sellerId") UUID sellerId) {
        return Response.ok(orderRepository.findBySellerId(sellerId)).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"BUYER", "SELLER", "ADMIN"})
    @Operation(summary = "Get order by ID")
    public Response getById(@PathParam("id") UUID id) {
        return orderRepository.findByIdOptional(id)
                .map(order -> Response.ok(order).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @GET
    @Path("/status/{status}")
    @RolesAllowed("ADMIN")
    @Operation(summary = "List orders by status", description = "Admin-only: filter orders by status (PLACED, CONFIRMED, PROCESSING, SHIPPED, DELIVERED, CANCELLED)")
    public Response listByStatus(@PathParam("status") OrderStatus status) {
        return Response.ok(orderRepository.findByStatus(status)).build();
    }
}
