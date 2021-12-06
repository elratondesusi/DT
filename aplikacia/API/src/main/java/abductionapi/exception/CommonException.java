package abductionapi.exception;

public class CommonException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CommonException(String message, Exception ex) {
        super(message, ex);
    }
}
