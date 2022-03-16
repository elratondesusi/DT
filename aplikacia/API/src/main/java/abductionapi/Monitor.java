package abductionapi;

import org.semanticweb.owlapi.model.OWLOntology;

import java.util.ArrayList;
import java.util.List;

public class Monitor {

    List<OWLOntology> explanations;

    public Monitor () {
        explanations = new ArrayList<>();
    }

    public void addNewExplanation(OWLOntology explanation) {
        if(explanation == null) {
            explanations = null;
        } else {
            explanations.add(explanation);
        }
    }

    public OWLOntology getNextExplanation() {
        if (explanations == null) {
            return null;
        }
        return explanations.get(explanations.size() - 1);
    }

    public List<OWLOntology> getExplanations() {
        return explanations;
    }
}