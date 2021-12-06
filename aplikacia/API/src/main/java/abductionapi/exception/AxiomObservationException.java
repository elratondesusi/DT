package abductionapi.exception;

public class AxiomObservationException extends CommonException {

    public AxiomObservationException(Exception ex) {
        super("Solver does not support this type of observation axiom: ", ex);
    }
}
