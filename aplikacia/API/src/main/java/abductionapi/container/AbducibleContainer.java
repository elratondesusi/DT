package abductionapi.container;

import abductionapi.exception.AxiomAbducibleAssertionException;
import abductionapi.exception.AxiomAbducibleException;
import abductionapi.exception.AxiomAbducibleSymbolException;
import java.util.List;
import java.util.Set;

/**
 * AbducibleContainer interface.
 */
public interface AbducibleContainer<T> {

    /**
     * Method that allows loops at abduction.
     * @throws AxiomAbducibleException if solver does not support loops enabling.
     */
    public void allowLoops();

    /**
     * Enables/disables loops at abduction.
     * @param allowLoops is a flag which indicates if loops are enabled or not.
     * @throws AxiomAbducibleException if solver does not support loops enabling.
     */
    default void allowLoops(Boolean allowLoops) throws AxiomAbducibleException {
        throw new AxiomAbducibleException("loops");
    }

    /**
     * Method that allows role assertions at abduction.
     * @throws AxiomAbducibleException if solver does not support role assertions enabling.
     */
    default void allowRoleAssertions() throws AxiomAbducibleException {
        throw new AxiomAbducibleException("role assertions");
    }

    /**
     * Enables/disables role assertions at abduction.
     * @param allowRoleAssertions is a flag which indicates if role assertions are enabled or not.
     * @throws AxiomAbducibleException if solver does not support role assertions enabling.
     */
    default void allowRoleAssertions(Boolean allowRoleAssertions) throws AxiomAbducibleException {
        throw new AxiomAbducibleException("role assertions");
    }

    /**
     * Method that allows concept assertions at abduction.
     * @throws AxiomAbducibleException if solver does not support concept assertions enabling.
     */
    default void allowConceptAssertions() throws AxiomAbducibleException {
        throw new AxiomAbducibleException("concept assertions");
    }

    /**
     * Enables/disables concept assertions at abduction.
     * @param allowConceptAssertions is a flag which indicates if concept assertions are enabled or not.
     * @throws AxiomAbducibleException if solver does not support concept assertions enabling.
     */
    default void allowConceptAssertions(Boolean allowConceptAssertions) throws AxiomAbducibleException {
        throw new AxiomAbducibleException("concept assertions");
    }

    /**
     * Method that allows complex concepts at abduction
     * @throws AxiomAbducibleException if solver does not support complex concept enabling.
     */
    default void allowComplexConcepts() throws AxiomAbducibleException {
        throw new AxiomAbducibleException("complex concept");
    }

    /**
     * Enables/disables complex concepts at abduction.
     * @param allowComplexConcepts is a flag which indicates if complex concepts are enabled or not.
     * @throws AxiomAbducibleException if solver does not support complex concept enabling.
     */
    default void allowComplexConcepts(Boolean allowComplexConcepts) throws AxiomAbducibleException {
        throw new AxiomAbducibleException("complex concept");
    }

    /**
     * Method that allows concept complement at abduction.
     * @throws AxiomAbducibleException if solver does not support concept complement enabling.
     */
    default void allowConceptComplements() throws AxiomAbducibleException {
        throw new AxiomAbducibleException("concept complement");
    }


    /**
     * Enables/disables concept complement at abduction.
     * @param allowConceptComplements is a flag which indicates if concept complement are enabled or not.
     * @throws AxiomAbducibleException if solver does not support concept complement enabling.
     */
    default void allowConceptComplements(Boolean allowConceptComplements) throws AxiomAbducibleException {
        throw new AxiomAbducibleException("concept complement");
    }

    /**
     * Method that adds symbol to an enumeration that is enabled at abduction.
     * @param symbol a symbol to be enabled at abduction
     * @throws AxiomAbducibleSymbolException if solver does not support this type of abducible symbol.
     */
    public void addSymbol(T symbol) throws AxiomAbducibleSymbolException;

    /**
     * Method that adds set of symbols to an enumeration that are enabled at abduction.
     * @param symbols to be enabled at abduction. Can be individuals, roles or concepts.
     * @throws AxiomAbducibleSymbolException if solver does not support this type of abducible symbol.
     */
    public void addSymbols(Set<T> symbols) throws AxiomAbducibleSymbolException;

    /**
     * Method that adds list of symbols to an enumeration that are enabled at abduction.
     * @param symbols to be enabled at abduction. Can be individuals, roles or concepts.
     * @throws AxiomAbducibleSymbolException if solver does not support this type of abducible symbol.
     */
    public void addSymbols(List<T> symbols) throws AxiomAbducibleSymbolException;

    /**
     * Method that creates enumeration of symbols that are enabled at abduction from an input.
     * @param symbols to be enabled at abduction. Can be an object containing individuals, roles or concepts.
     * @throws AxiomAbducibleSymbolException if solver does not support this type of abducible symbol.
     */
    public void addSymbols(T symbols) throws AxiomAbducibleSymbolException;

    /**
     * Method that adds assertion axiom to an enumeration that is enabled at abduction.
     * @param assertion an assertion axiom to be enabled at abduction.
     * @throws AxiomAbducibleAssertionException if solver does not support this type of abducible assertion.
     */
    public void addAssertion(T assertion) throws AxiomAbducibleAssertionException;

    /**
     * Method that adds set of assertions to an enumeration that are enabled at abduction.
     * @param assertions an assertion axiom to be enabled at abduction.
     * @throws AxiomAbducibleAssertionException if solver does not support this type of abducible assertion.
     */
    public void addAssertions(Set<T> assertions) throws AxiomAbducibleAssertionException;

    /**
     * Method that adds list of assertion to an enumeration that are enabled at abduction.
     * @param assertions an assertion axiom to be enabled at abduction.
     * @throws AxiomAbducibleAssertionException if solver does not support this type of abducible assertion.
     */
    public void addAssertions(List<T> assertions) throws AxiomAbducibleAssertionException;

    /**
     * Method that creates an enumeration of assertion axioms that are enabled at abduction from an OWLOntology.
     * @param assertionAxioms assertions to be enabled at abduction. Can be an object containing assertion axioms.
     * @throws AxiomAbducibleAssertionException if solver does not support this type of abducible assertion.
     */
    public void addAssertions(T assertionAxioms) throws AxiomAbducibleAssertionException;
}
