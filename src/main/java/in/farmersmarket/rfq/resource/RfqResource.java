package in.farmersmarket.rfq.resource;

import in.farmersmarket.rfq.repository.RfqRepository;
import in.farmersmarket.rfq.repository.QuoteRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.UUID;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/api/v1/rfqs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "RFQs")
public class RfqResource {

    @Inject RfqRepository rfqRepository;
    @Inject QuoteRepository quoteRepository;

    @GET
    @Path("/buyer/{buyerId}")
    @RolesAllowed({"BUYER", "ADMIN"})
    @Operation(summary = "List RFQs by buyer", description = "Returns all RFQs created by the specified buyer")
    @SecurityRequirement(name = "jwt")
    public Response listByBuyer(@PathParam("buyerId") UUID buyerId) {
        return Response.ok(rfqRepository.findByBuyerId(buyerId)).build();
    }

    @GET
    @Path("/seller/{sellerId}")
    @RolesAllowed({"SELLER", "ADMIN"})
    @Operation(summary = "List RFQs for seller", description = "Returns RFQs for products owned by the specified seller")
    @SecurityRequirement(name = "jwt")
    public Response listBySeller(@PathParam("sellerId") UUID sellerId) {
        return Response.ok(rfqRepository.findByProductSellerId(sellerId)).build();
    }

    @GET
    @Path("/{rfqId}/quotes")
    @RolesAllowed({"BUYER", "SELLER", "ADMIN"})
    @Operation(summary = "List quotes for an RFQ", description = "Returns all seller quotes submitted against the specified RFQ")
    @SecurityRequirement(name = "jwt")
    public Response listQuotes(@PathParam("rfqId") UUID rfqId) {
        return Response.ok(quoteRepository.findByRfqId(rfqId)).build();
    }
}
