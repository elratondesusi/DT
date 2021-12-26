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
        explanations.add(explanation);
    }

    public OWLOntology getLastExplanation() {
        return explanations.get(explanations.size() - 1);
    }
}