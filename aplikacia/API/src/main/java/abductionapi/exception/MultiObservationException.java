package abductionapi.exception;

public class MultiObservationException extends CommonException {

    public MultiObservationException(Exception ex) {
        super("Solver does not support multi observation: ", ex);
    }
}
