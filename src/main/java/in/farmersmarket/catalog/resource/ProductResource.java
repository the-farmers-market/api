package in.farmersmarket.catalog.resource;

import in.farmersmarket.catalog.entity.Product;
import in.farmersmarket.catalog.service.ProductService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.UUID;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/api/v1/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Products")
public class ProductResource {

    @Inject ProductService productService;

    @GET
    @Operation(summary = "List approved products", description = "Returns all products with APPROVED status — public endpoint")
    public Response listApproved() {
        return Response.ok(productService.listApproved()).build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get product by ID")
    public Response getById(@PathParam("id") UUID id) {
        return Response.ok(productService.getById(id)).build();
    }

    @GET
    @Path("/seller/{sellerId}")
    @RolesAllowed({"SELLER", "ADMIN"})
    @Operation(summary = "List products by seller")
    @SecurityRequirement(name = "jwt")
    public Response listBySeller(@PathParam("sellerId") UUID sellerId) {
        return Response.ok(productService.listBySeller(sellerId)).build();
    }

    @GET
    @Path("/pending")
    @RolesAllowed("ADMIN")
    @Operation(summary = "List pending products", description = "Admin-only: returns products awaiting approval")
    @SecurityRequirement(name = "jwt")
    public Response listPending() {
        return Response.ok(productService.listPending()).build();
    }

    @POST
    @RolesAllowed("SELLER")
    @Operation(summary = "Create a product", description = "Seller creates a new product listing (starts as DRAFT)")
    @SecurityRequirement(name = "jwt")
    public Response create(Product product) {
        Product created = productService.create(product);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @PUT
    @Path("/{id}/approve")
    @RolesAllowed("ADMIN")
    @Operation(summary = "Approve a product", description = "Admin approves a pending product for listing")
    @SecurityRequirement(name = "jwt")
    public Response approve(@PathParam("id") UUID id) {
        return Response.ok(productService.approve(id, null)).build();
    }

    @PUT
    @Path("/{id}/reject")
    @RolesAllowed("ADMIN")
    @Operation(summary = "Reject a product", description = "Admin rejects a pending product")
    @SecurityRequirement(name = "jwt")
    public Response reject(@PathParam("id") UUID id) {
        return Response.ok(productService.reject(id)).build();
    }
}
