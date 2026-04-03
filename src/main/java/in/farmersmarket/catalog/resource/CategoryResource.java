package in.farmersmarket.catalog.resource;

import in.farmersmarket.catalog.repository.CategoryRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/api/v1/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Categories")
public class CategoryResource {

    @Inject CategoryRepository categoryRepository;

    @GET
    @Operation(summary = "List root categories", description = "Returns top-level active categories")
    public Response listRootCategories() {
        return Response.ok(categoryRepository.findRootCategories()).build();
    }
}
