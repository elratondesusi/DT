package abductionapi.exception;

/**
 * @author Zuzana Hlávková, hlavkovazuz@gmail.com
 */
public class AxiomAbducibleException extends CommonException {

    public AxiomAbducibleException(String message) {
        super("Solver does not support " + message + ".");
    }
}
