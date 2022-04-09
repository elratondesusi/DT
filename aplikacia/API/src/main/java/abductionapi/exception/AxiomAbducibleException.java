package abductionapi.exception;

public class AxiomAbducibleException extends CommonException {

    public AxiomAbducibleException(Exception ex) {
        super("Solver does not support this type of abducible assertion: ", ex);
    }
    public AxiomAbducibleException(String message) {
        super("Solver does not support enabling " + message + ".");
    }
}
