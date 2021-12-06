package abductionapi.exception;

public class AxiomAbducibleAssertionException extends CommonException {

    public AxiomAbducibleAssertionException(Exception ex) {
        super("Solver does not support this type of abducible assertion: ", ex);
    }
}
