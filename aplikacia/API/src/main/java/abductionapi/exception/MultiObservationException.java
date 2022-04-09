package abductionapi.exception;

public class MultiObservationException extends CommonException {

    public MultiObservationException() {
        super("Solver does not support multi observation.", null);
    }
}
