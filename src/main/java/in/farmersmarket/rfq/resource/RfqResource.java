package in.farmersmarket.rfq.resource;

import in.farmersmarket.rfq.repository.RfqRepository;
import in.farmersmarket.rfq.repository.QuoteRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.UUID;

@Path("/api/v1/rfqs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RfqResource {

    @Inject RfqRepository rfqRepository;
    @Inject QuoteRepository quoteRepository;

    @GET
    @Path("/buyer/{buyerId}")
    @RolesAllowed({"BUYER", "ADMIN"})
    public Response listByBuyer(@PathParam("buyerId") UUID buyerId) {
        return Response.ok(rfqRepository.findByBuyerId(buyerId)).build();
    }

    @GET
    @Path("/seller/{sellerId}")
    @RolesAllowed({"SELLER", "ADMIN"})
    public Response listBySeller(@PathParam("sellerId") UUID sellerId) {
        return Response.ok(rfqRepository.findByProductSellerId(sellerId)).build();
    }

    @GET
    @Path("/{rfqId}/quotes")
    @RolesAllowed({"BUYER", "SELLER", "ADMIN"})
    public Response listQuotes(@PathParam("rfqId") UUID rfqId) {
        return Response.ok(quoteRepository.findByRfqId(rfqId)).build();
    }
}
