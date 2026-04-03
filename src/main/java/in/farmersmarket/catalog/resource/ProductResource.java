package in.farmersmarket.catalog.resource;

import in.farmersmarket.catalog.entity.Product;
import in.farmersmarket.catalog.service.ProductService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.UUID;

@Path("/api/v1/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject ProductService productService;

    @GET
    public Response listApproved() {
        return Response.ok(productService.listApproved()).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") UUID id) {
        return Response.ok(productService.getById(id)).build();
    }

    @GET
    @Path("/seller/{sellerId}")
    @RolesAllowed({"SELLER", "ADMIN"})
    public Response listBySeller(@PathParam("sellerId") UUID sellerId) {
        return Response.ok(productService.listBySeller(sellerId)).build();
    }

    @GET
    @Path("/pending")
    @RolesAllowed("ADMIN")
    public Response listPending() {
        return Response.ok(productService.listPending()).build();
    }

    @POST
    @RolesAllowed("SELLER")
    public Response create(Product product) {
        Product created = productService.create(product);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @PUT
    @Path("/{id}/approve")
    @RolesAllowed("ADMIN")
    public Response approve(@PathParam("id") UUID id) {
        return Response.ok(productService.approve(id, null)).build();
    }

    @PUT
    @Path("/{id}/reject")
    @RolesAllowed("ADMIN")
    public Response reject(@PathParam("id") UUID id) {
        return Response.ok(productService.reject(id)).build();
    }
}
