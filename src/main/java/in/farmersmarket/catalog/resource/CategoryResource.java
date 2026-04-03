package in.farmersmarket.catalog.resource;

import in.farmersmarket.catalog.repository.CategoryRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {

    @Inject CategoryRepository categoryRepository;

    @GET
    public Response listRootCategories() {
        return Response.ok(categoryRepository.findRootCategories()).build();
    }
}
