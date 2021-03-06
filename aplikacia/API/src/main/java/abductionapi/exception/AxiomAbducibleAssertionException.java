package abductionapi.exception;

/**
 * @author Zuzana Hlávková, hlavkovazuz@gmail.com
 */
public class AxiomAbducibleAssertionException extends CommonException {

    public AxiomAbducibleAssertionException(Exception ex) {
        super("Solver does not support this type of abducible assertion: ", ex);
    }

    public AxiomAbducibleAssertionException(String message) {
        super("Solver does not support this type of abducible assertion: " + message);
    }
}
