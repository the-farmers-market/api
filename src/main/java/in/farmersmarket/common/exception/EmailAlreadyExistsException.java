package in.farmersmarket.common.exception;

public class EmailAlreadyExistsException extends ApiException {
    public EmailAlreadyExistsException(String message) {
        super(message, 409, "EMAIL_ALREADY_EXISTS");
    }
}
