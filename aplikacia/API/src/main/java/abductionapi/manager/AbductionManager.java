package abductionapi.manager;

import abductionapi.Monitor;
import abductionapi.container.AbducibleContainer;
import abductionapi.exception.AxiomObservationException;
import abductionapi.exception.MultiObservationException;

import java.util.Set;

/**
 * DLAbductionManager interface.
 */
public interface AbductionManager extends Runnable {

    public static AbductionManager single_instance = null;

    AbducibleContainer abducibleContainer = null;

    Monitor monitor = null;
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

    /**
     * Returns a first computed abduction explanation.
     * @return explanation.
     */
    public <T> T getExplanation();

    /**
     * Returns abduction explanations.
     * @return Set of explanations.
     */
    public <T> Set<T> getExplanations();

    /**
     * Sets multi observation for abduction.
     * @param observation multi observation for abduction.
     * @throws MultiObservationException if solver does not support multi observation.
     * @throws AxiomObservationException if solver does not support this type of observation axiom.
     */
    public <T> void setObservation(Set<T> observation) throws MultiObservationException, AxiomObservationException;

    /**
     * Sets observation for abduction.
     * @param observation observation for abduction.
     * @throws MultiObservationException if solver does not support multi observation.
     * @throws AxiomObservationException if solver does not support this type of observation axiom.
     */
    public <T> void setObservation(T observation) throws MultiObservationException, AxiomObservationException;

    /**
     * Sets abducible manager for abduction.
     * @param abducibleContainer to be set to abductionManager.
     */
    public <T> void setAbducibles(T abducibleContainer);

    /**
     * Method computes new explanations.
     * Any new explanation is computed then method show is called.
     */
    @Override
    public void run();

    /**
     * Sets monitor.
     * @param monitor to be set.
     */
    public void setMonitor(Monitor monitor);

    /**
     * Method adds explanation to Monitor.explanations and a notification to monitor is sent.
     * @param explanation a new computed explanation.
     */
    default <T> void sendExplanation(T explanation) {
        if (monitor != null){
            monitor.addNewExplanation(explanation);
            monitor.notifyAll();
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
