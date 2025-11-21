package exceptions;

public class OffenceNotFoundException extends RuntimeException {

    public OffenceNotFoundException(String message) {
        super(message);
    }
}
