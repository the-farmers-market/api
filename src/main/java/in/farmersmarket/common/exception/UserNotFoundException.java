package in.farmersmarket.common.exception;

public class UserNotFoundException extends ApiException {
    public UserNotFoundException(String message) {
        super(message, 404, "USER_NOT_FOUND");
    }
}
