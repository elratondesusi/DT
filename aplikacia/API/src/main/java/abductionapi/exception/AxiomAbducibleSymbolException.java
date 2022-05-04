package abductionapi.exception;

/**
 * @author Zuzana Hlávková, hlavkovazuz@gmail.com
 */
public class AxiomAbducibleSymbolException extends CommonException {

    public AxiomAbducibleSymbolException(Exception ex) {
        super("Solver does not support this type of abducible symbol: ", ex);
    }

    public AxiomAbducibleSymbolException(String message) {
        super("Solver does not support this type of abducible symbol: " + message);
    }
}
