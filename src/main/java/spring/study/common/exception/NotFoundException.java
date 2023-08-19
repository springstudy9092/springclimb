package spring.study.common.exception;

// RuntimeException
public class NotFoundException extends RuntimeException {
    public NotFoundException(final String message) {
        super(message);
    }
}