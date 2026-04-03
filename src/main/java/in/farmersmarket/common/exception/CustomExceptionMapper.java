package in.farmersmarket.common.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CustomExceptionMapper implements ExceptionMapper<ApiException> {

    @Override
    public Response toResponse(ApiException exception) {
        ErrorResponse error = new ErrorResponse(
            exception.getStatusCode(),
            exception.getErrorCode(),
            exception.getMessage()
        );
        return Response.status(exception.getStatusCode()).entity(error).build();
    }
}
