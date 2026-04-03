package in.farmersmarket.common.exception;

public class PhoneAlreadyExistsException extends ApiException {
    public PhoneAlreadyExistsException(String message) {
        super(message, 409, "PHONE_ALREADY_EXISTS");
    }
}
