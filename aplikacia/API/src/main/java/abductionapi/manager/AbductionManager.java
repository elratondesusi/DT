package abductionapi.manager;

import abductionapi.Monitor;
import abductionapi.exception.AxiomObservationException;
import abductionapi.exception.MultiObservationException;
import org.semanticweb.owlapi.model.OWLDocumentFormat;
import org.semanticweb.owlapi.model.OWLOntology;

import java.util.Set;

/**
 * DLAbductionManager interface.
 */
public interface AbductionManager extends Runnable {

    public static AbductionManager single_instance = null;

    Monitor monitor = null;
    /**
     * Sets an input for an abduction.
     * @param input input for an abduction.
     * @param <T> can be String, File or OWLOntology.
     */
    public <T> void setInput(T input);

    /**
     * Sets output file name and file path.
     * @param fileName by default (or if null) the output file is called 'explanation.owl'.
     * @param path by default (or if null) file path is the same as plugin path plus suffix '/explanation'.
     */
    public void setOutputFileNameAndPath(String fileName, String path);

    /**
     * Enables/disables a creation of an output file.
     * @param create is a flag which indicates if output file will be created or not.
     */
    public void setOutputFileNameAndPath(Boolean create);

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
     * Returns abduction explanations.
     * @return Set of OWLOntology
     */
    public Set<OWLOntology> getExplanations();

    /**
     * Returns a first computed abduction explanation.
     * @return Set of OWLOntology
     */
    public OWLOntology getExplanation();

    /**
     * Sets single observation for abduction.
     * @param observation single observation for abduction.
     */
    public void setObservation(OWLOntology observation);

    /**
     * Sets multi observation for abduction.
     * @param observation multi observation for abduction.
     * @throws MultiObservationException if solver does not support multi observation.
     * @throws AxiomObservationException if solver does not support this type of observation axiom.
     */
    public void setObservation(Set<OWLOntology> observation);

    /**
     * Sets abducible manager for abduction.
     * @param abducibleManager to be set to abductionManager
     */
    public void setAbducibles(AbducibleManager abducibleManager);

    /**
     * Sets output file format.
     * @param owlDocumentFormat output file format.
     */
    public void setOutputFileFormat(OWLDocumentFormat owlDocumentFormat);

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
     * @param explanation to be set.
     */
    public void show(OWLOntology explanation);
}
