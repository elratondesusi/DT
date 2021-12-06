package abductionapi.exception;

public class AxiomAbducibleSymbolException extends CommonException {

    public AxiomAbducibleSymbolException(Exception ex) {
        super("Solver does not support this type of abducible symbol: ", ex);
    }
}
