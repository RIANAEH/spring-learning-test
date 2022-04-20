package nextstep.helloworld.mvc.exceptions.exception;

public class HelloException extends RuntimeException {

    private static final String MESSAGE = "HelloException";

    public HelloException() {
        super(MESSAGE);
    }

}
