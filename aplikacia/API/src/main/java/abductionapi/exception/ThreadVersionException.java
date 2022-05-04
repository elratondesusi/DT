package abductionapi.exception;

/**
 * @author Zuzana Hlávková, hlavkovazuz@gmail.com
 */
public class ThreadVersionException extends CommonException {

    public ThreadVersionException() {
        super("Solver does not support thread computing explanations version.");
    }
}
