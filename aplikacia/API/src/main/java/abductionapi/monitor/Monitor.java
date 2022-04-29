package abductionapi.monitor;

import java.util.ArrayList;
import java.util.List;

public class Monitor <T> {

    List<T> explanations;

    public Monitor () {
        explanations = new ArrayList<>();
    }

    public void addNewExplanation(T explanation) {
        if(explanation == null) {
            explanations = null;
        } else {
            explanations.add(explanation);
        }
    }

    public T getNextExplanation() {
        if (explanations == null) {
            return null;
        }
        return explanations.get(explanations.size() - 1);
    }

    public List<T> getExplanations() {
        return (List<T>) explanations;
    }
}