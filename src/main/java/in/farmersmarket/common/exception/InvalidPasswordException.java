package in.farmersmarket.common.exception;

public class InvalidPasswordException extends ApiException {
    public InvalidPasswordException(String message) {
        super(message, 401, "INVALID_PASSWORD");
    }
}
