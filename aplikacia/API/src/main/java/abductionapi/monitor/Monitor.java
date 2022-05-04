package abductionapi.monitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Monitor.
 * @author Zuzana Hlávková, hlavkovazuz@gmail.com
 *
 * @param <EXPLANATION_TYPE> explanation type parameter
 */
public class Monitor <EXPLANATION_TYPE> {

    List<EXPLANATION_TYPE> explanations;

    public Monitor () {
        explanations = new ArrayList<>();
    }

    /**
     * Add new explanation to the list explanations.
     * @param explanation a new computed explanation to be added to the list
     */
    public void addNewExplanation(EXPLANATION_TYPE explanation) {
        if(explanation == null) {
            explanations = null;
        } else {
            explanations.add(explanation);
        }
    }

    /**
     * Returns the last computed explanation.
     * @return the last computed explanation
     */
    public EXPLANATION_TYPE getNextExplanation() {
        if (explanations == null) {
            return null;
        }
        return explanations.get(explanations.size() - 1);
    }

    /**
     * Returns list of explanations.
     * @return list explanations
     */
    public List<EXPLANATION_TYPE> getExplanations() {
        return explanations;
    }
}