package abductionapi.exception;

/**
 * @author Zuzana Hlávková, hlavkovazuz@gmail.com
 */
public class MultiObservationException extends CommonException {

    public MultiObservationException() {
        super("Solver does not support multi observation.");
    }
}
