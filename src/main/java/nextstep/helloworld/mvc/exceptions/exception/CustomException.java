package nextstep.helloworld.mvc.exceptions.exception;

public class CustomException extends RuntimeException {

    private static final String MESSAGE = "CustomException";

    public CustomException() {
        super(MESSAGE);
    }
}
