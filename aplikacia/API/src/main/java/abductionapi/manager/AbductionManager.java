package abductionapi.manager;

import abductionapi.container.AbducibleContainer;
import abductionapi.monitor.Monitor;
import abductionapi.exception.AxiomObservationException;
import abductionapi.exception.MultiObservationException;
import abductionapi.exception.ThreadVersionException;
import org.semanticweb.owlapi.model.OWLOntology;

import java.io.File;
import java.util.Set;


/**
 * AbductionManager generic interface.
 * @author Zuzana Hlávková, hlavkovazuz@gmail.com
 *
 * @param <BCKGRNDKNW_TYPE> background knowledge type parameter
 * @param <EXPLANATION_TYPE> explanation type parameter
 * @param <OBSERVATION_TYPE> observation type parameter
 * @param <SYMBOL_ABDUCIBLE> abducible symbol type parameter
 * @param <ASSERTION_ABDUCIBLE> abducible assertion type parameter
 * @param <ABDUCIBLES> abduction container type parameter
 */
public interface AbductionManager<BCKGRNDKNW_TYPE, EXPLANATION_TYPE, OBSERVATION_TYPE, SYMBOL_ABDUCIBLE, ASSERTION_ABDUCIBLE, ABDUCIBLES extends AbducibleContainer<SYMBOL_ABDUCIBLE, ASSERTION_ABDUCIBLE>> extends Runnable {

    Monitor monitor = new Monitor();

    /**
     * Sets the background knowledge for an abduction.
     * @param owlOntology ontology.
     */
    public void setBackgroundKnowledge(BCKGRNDKNW_TYPE owlOntology);

    /**
     * Sets a solver internal info (debug, timeout, depth, etc.).
     * @param internalSettings solver internal info (debug, timeout, depth, etc.).
     */
    public void setAdditionalSolverSettings(String internalSettings);

    /**
     * Returns solver internal info (debug, timeout, depth, etc.).
     * @return a string with solver internal info.
     */
    public String getOutputAdditionalInfo();

    /**
     * Returns abduction explanations.
     * @return Set of explanations.
     */
    public Set<EXPLANATION_TYPE> getExplanations();

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
    default void setObservation(Set<OBSERVATION_TYPE> observation) throws MultiObservationException, AxiomObservationException {
        throw new MultiObservationException();
    }

    /**
     * Sets observation for abduction.
     * @param observation observation for abduction.
     * @throws MultiObservationException if solver does not support multi observation.
     * @throws AxiomObservationException if solver does not support this type of observation axiom.
     */
    public void setObservation(OBSERVATION_TYPE observation) throws MultiObservationException, AxiomObservationException;

    /**
     * Returns observation.
//     * @param <OBSERVATION_TYPE> observation.
     */
    public OBSERVATION_TYPE getObservation();

    /**
     * Returns background knowledge.
     * @return OWLOntology
     */
    public BCKGRNDKNW_TYPE getBackgroundKnowledge();

    /**
     * Sets abducibles for abduction
     * @param abducibleContainer to be set to abductionManager.
     * @param <T> - AbducibleContainer implementation.
     */
    public void setAbducibles(ABDUCIBLES abducibleContainer);

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

//    /**
//     * Sets monitor.
//     * @param monitor to be set.
//     */
//    default void setMonitor(Monitor monitor) {
//        throw new ThreadVersionException();
//    }

    /**
     * Returns monitor.
     * @return a instance of Monitor.
     */
    default Monitor getMonitor() {
        return monitor;
    }

    /**
     * Method adds explanation to Monitor.explanations and a notification to monitor is sent.
     * @param explanation a new computed explanation.
     */
    default void sendExplanation(EXPLANATION_TYPE explanation) {
        monitor.addNewExplanation(explanation);
        monitor.notifyAll();
        try {
            monitor.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
