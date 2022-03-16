package abductionapi.manager;

import abductionapi.exception.AxiomAbducibleAssertionException;
import abductionapi.exception.AxiomAbducibleSymbolException;
import org.semanticweb.owlapi.model.*;

import java.util.List;
import java.util.Set;

/**
 * AbducibleContainer interface.
 */
public interface AbducibleContainer<T> {

    /**
     * Method that allows loops at abduction.
     */
    public void allowLoops();

    /**
     * Enables/disables loops at abduction.
     * @param allowLoops is a flag which indicates if loops are enabled or not.
     */
    public void allowLoops(Boolean allowLoops);

    /**
     * Method that allows role assertions at abduction.
     */
    public void allowRoleAssertions();

    /**
     * Enables/disables role assertions at abduction.
     * @param allowRoleAssertions is a flag which indicates if role assertions are enabled or not.
     */
    public void allowRoleAssertions(Boolean allowRoleAssertions);

    /**
     * Method that allows concept assertions at abduction.
     */
    public void allowConceptAssertions();

    /**
     * Enables/disables concept assertions at abduction.
     * @param allowConceptAssertions is a flag which indicates if concept assertions are enabled or not.
     */
    public void allowConceptAssertions(Boolean allowConceptAssertions);

    /**
     * Method that allows complex concepts at abduction.
     */
    public void allowComplexConcepts();

    /**
     * Enables/disables complex concepts at abduction.
     * @param allowComplexConcepts is a flag which indicates if complex concepts are enabled or not.
     */
    public void allowComplexConcepts(Boolean allowComplexConcepts);

    /**
     * Method that allows concept complement at abduction.
     */
    public void allowConceptComplement();

    /**
     * Enables/disables concept complement at abduction.
     * @param allowConceptComplement is a flag which indicates if concept complement are enabled or not.
     */
    public void allowConceptComplement(Boolean allowConceptComplement);

    /**
     * Method that adds symbol to an enumeration that is enabled at abduction.
     * @param symbol a symbol 'individual' to be enabled at abduction
     * @throws AxiomAbducibleSymbolException if solver does not support this type of abducible symbol.
     */
    public void addSymbol(T symbol) throws AxiomAbducibleSymbolException;

    /**
     * Method that adds set of symbols to an enumeration that are enabled at abduction.
     * @param symbols to be enabled at abduction. Can be an individuals, a roles or a concepts.
     * @throws AxiomAbducibleSymbolException if solver does not support this type of abducible symbol.
     */
    public void addSymbols(Set<T> symbols) throws AxiomAbducibleSymbolException;

    /**
     * Method that adds list of symbols to an enumeration that are enabled at abduction.
     * @param symbols to be enabled at abduction. Can be an individuals, a roles or a concepts.
     * @throws AxiomAbducibleSymbolException if solver does not support this type of abducible symbol.
     */
    public void addSymbols(List<T> symbols) throws AxiomAbducibleSymbolException;

    /**
     * Method that creates enumeration of symbols that are enabled at abduction from an OWLOntology.
     * @param symbols an OWLOntology which is a list of axioms (symbols) to be enabled at abduction.
     * @throws AxiomAbducibleSymbolException if solver does not support this type of abducible symbol.
     */
    public void addSymbols(OWLOntology symbols) throws AxiomAbducibleSymbolException;

    /**
     * Method that adds owl assertion axiom to an enumeration that is enabled at abduction.
     * @param assertion an owl assertion axiom to be enabled at abduction.
     * @throws AxiomAbducibleAssertionException if solver does not support this type of abducible assertion.
     */
    public void addAssertion(T assertion) throws AxiomAbducibleAssertionException;

    /**
     * Method that adds set of owl assertions to an enumeration that are enabled at abduction.
     * @param assertions an owl assertion axiom to be enabled at abduction.
     * @throws AxiomAbducibleAssertionException if solver does not support this type of abducible assertion.
     */
    public void addAssertions(Set<T> assertions) throws AxiomAbducibleAssertionException;

    /**
     * Method that adds list of owl assertion to an enumeration that are enabled at abduction.
     * @param assertions an owl assertion axiom to be enabled at abduction.
     * @throws AxiomAbducibleAssertionException if solver does not support this type of abducible assertion.
     */
    public void addAssertions(List<T> assertions) throws AxiomAbducibleAssertionException;

    /**
     * Method that creates an enumeration of owl class assertion axiom that are enabled at abduction from an OWLOntology.
     * @param assertionAxioms an OWLOntology which is a list of assertion axioms to be enabled at abduction.
     * @throws AxiomAbducibleAssertionException if solver does not support this type of abducible assertion.
     */
    public void addAssertions(OWLOntology assertionAxioms) throws AxiomAbducibleAssertionException;
}