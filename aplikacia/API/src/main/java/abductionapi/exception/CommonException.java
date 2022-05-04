package abductionapi.exception;

/**
 * @author Zuzana Hlávková, hlavkovazuz@gmail.com
 */
public class CommonException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CommonException(String message, Exception ex) {
        super(message, ex);
    }

    public CommonException(String message) {
        super(message, null);
    }
}
