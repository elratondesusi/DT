package abductionapi.manager;

import abductionapi.monitor.Monitor;
import abductionapi.exception.AxiomObservationException;
import abductionapi.exception.MultiObservationException;
import abductionapi.exception.ThreadVersionException;

import java.util.Set;

/**
 * DLAbductionManager interface.
 */
public interface AbductionManager extends Runnable {

    /**
     * Sets a background knowledge for an abduction.
     * @param input input for an abduction.
     * @param <T> generic input.
     */
    public <T> void setBackgroundKnowledge(T input);

    /**
     * Sets a solver internal info (debug, etc.).
     * @param internalSettings solver internal info (debug, etc.).
     */
    public void setAdditionalSolverSettings(String internalSettings);

    /**
     * Returns solver internal info (debug, etc.).
     * @return a string with solver internal info.
     */
    public String getOutputAdditionalInfo();

//    /**
//     * Returns a first computed abduction explanation.
//     * @return explanation.
//     */
//    public <T> T getExplanation();

    /**
     * Returns abduction explanations.
     * @return Set of explanations.
     */
    public <T> Set<T> getExplanations();

    /**
     * Thread version method to get explanations.
     */
    default public void getExplanationsIncrementally() {
        throw new ThreadVersionException();
    }

    /**
     * Sets multi observation for abduction.
     * @param observation multi observation for abduction.
     * @throws MultiObservationException if solver does not support multi observation.
     * @throws AxiomObservationException if solver does not support this type of observation axiom.
     */
    default <T> void setObservation(Set<T> observation) throws MultiObservationException, AxiomObservationException {
        throw new MultiObservationException();
    }

    /**
     * Sets observation for abduction.
     * @param observation observation for abduction.
     * @throws MultiObservationException if solver does not support multi observation.
     * @throws AxiomObservationException if solver does not support this type of observation axiom.
     */
    public <T> void setObservation(T observation) throws MultiObservationException, AxiomObservationException;

    /**
     * Returns observation.
     * @param <T> observation.
     */
    public <T> T getObservation();

    /**
     * Returns background knowledge.
     * @param <T> background knowledge.
     */
    public <T> T getBackgroundKnowledge();

    /**
     * Sets abducibles for abduction
     * @param abducibleContainer to be set to abductionManager.
     * @param <T> - AbducibleContainer implementation.
     */
    public <T> void setAbducibles(T abducibleContainer);

    /**
     * Returns abducible manager.
     * @param <T> - AbducibleContainer implementation.
     * @return abducibleContainer with abducibles for the abduction.
     */
    public <T> T getAbducibles();

    /**
     * Method computes new explanations.
     * Any new explanation is computed then method show is called.
     */
    @Override
    default void run() {
        throw new ThreadVersionException();
    }

    /**
     * Sets monitor.
     * @param monitor to be set.
     */
    default void setMonitor(Monitor monitor) {
        throw new ThreadVersionException();
    }

    /**
     * Method adds explanation to Monitor.explanations and a notification to monitor is sent.
     * @param explanation a new computed explanation.
     */
    default <T> void sendExplanation(T explanation) {}
}
