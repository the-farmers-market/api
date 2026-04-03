package in.farmersmarket.common.exception;

public class ValidationException extends ApiException {
    public ValidationException(String message) {
        super(message, 400, "VALIDATION_ERROR");
    }
}
