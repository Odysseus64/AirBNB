package plasma.swagger.exam.exception;

public class CustomRuntimeException extends RuntimeException {

    public CustomRuntimeException(String message) {
        super(message);
    }
}