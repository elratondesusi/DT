package abductionapi.exception;

public class AxiomAbducibleException extends CommonException {

    public AxiomAbducibleException(String message) {
        super("Solver does not support enabling " + message + ".");
    }
}
