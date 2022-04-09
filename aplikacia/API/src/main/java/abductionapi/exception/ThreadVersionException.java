package abductionapi.exception;

public class ThreadVersionException extends CommonException {

    public ThreadVersionException() {
        super("Solver does not support thread computing explanations version.");
    }
}
