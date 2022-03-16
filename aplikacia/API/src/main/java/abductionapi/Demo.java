package abductionapi;


import abductionapi.exception.CommonException;
import abductionapi.factory.AbductionManagerAndAbducibleContainerFactory;
import abductionapi.manager.AbducibleContainer;
import abductionapi.manager.AbductionManager;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Demo implements Runnable {

    private static Monitor monitor = new Monitor();

    public static void main(String[] args) throws OWLOntologyCreationException {

        // OWL Api
        IRI IOR = IRI.create("http://my-test-web.test");
        OWLOntologyManager man = OWLManager.createOWLOntologyManager();
        OWLOntology o = man.createOntology(IOR);
        OWLDataFactory df = o.getOWLOntologyManager().getOWLDataFactory();


        AbductionManagerAndAbducibleContainerFactory abductionFactory;//= new AbductionFactory();
        // Abduction API
        AbductionManager abductionManager = abductionFactory.createAbductionManager();

        // input
        // .owl or OWLOntology
        abductionManager.setBackgroundKnowledge(new File("example-input.owl"));
        OWLOntology inputOntology = man.createOntology(IOR);
        abductionManager.setBackgroundKnowledge(inputOntology);

        // observation/s
        OWLOntology observationOntology = man.createOntology(IOR);
        Set<OWLOntology> observationOntologySet = new HashSet<>();
        try {
            abductionManager.setObservation(observationOntologySet);
        } catch (CommonException ex) {
            throw new CommonException("Solver exception: ", ex);
        }

        // ****************************************************************************************************************************
        // ****************************************************************************************************************************
        // *******************************              abducibles                          *******************************************
        // ****************************************************************************************************************************
        // ****************************************************************************************************************************
        // abducibles
        // more options how we will work with them

        // ****************************************************************************************************************************
        // *******************************              1  switches                          *******************************************
        // ****************************************************************************************************************************
        //1.--- switches: loops, role assertions, concept assertions, atomic/complex assertions, negation      -> default: false

        // without manager for abducibles
        // dLAbductionManager.setLoops(True);
        // dLAbductionManager.setRoleAssertion(True);
        // dLAbductionManager.setConceptAssertion(True);
        // dLAbductionManager.setComplex(True); --atomic/complex
        // dLAbductionManager.setNegation(True);
        // dLAbductionManager.allowAbducibles(...);

        // with Abducible container
        AbducibleContainer abducibleContainer = dLAbductionFactory.createAbducibleContainer();;

        abducibleContainer.allowLoops(); //(boolean default=true)
        abducibleContainer.allowLoops(false);
        abducibleContainer.allowRoleAssertions();
        abducibleContainer.allowConceptAssertions();
        abducibleContainer.allowComplexConcepts();
        abducibleContainer.allowConceptComplement();

        // ****************************************************************************************************************************
        // *******************************              2  enumeration abducibles                          ****************************
        // ****************************************************************************************************************************
        //2. --- bud enum abd. cez abducibleContainer alebo cez ontologiu
        //2.1--- enumeration abducibles - enumeration of everything we want to be enabled. e.x.: 4 concepts -> 4 assertions or individuals, concept -> combinations

        //bud prvy sposob
        // create inviduals
        OWLClass jack = df.getOWLClass(IOR+"#Jack");
        OWLIndividual indivJack = df.getOWLNamedIndividual(jack);

        try {
            abducibleContainer.addSymbol(indivJack);
        } catch (CommonException ex) {
            throw new CommonException("Solver exception: ", ex);
        }

        OWLClass jill = df.getOWLClass(IOR+"#jill");
        OWLIndividual indivJill = df.getOWLNamedIndividual(jill);

        try {
            abducibleContainer.addSymbol(indivJill);
        } catch (CommonException ex) {
            throw new CommonException("Solver exception: ", ex);
        }

        OWLClass parent = df.getOWLClass(IOR+"#Parent"); // concept
        try {
            abducibleContainer.addSymbol(parent);
        } catch (CommonException ex) {
            throw new CommonException("Solver exception: ", ex);
        }

        OWLObjectProperty hasChild = df.getOWLObjectProperty(IOR + "hasChild"); // role
        try {
            abducibleContainer.addSymbol(hasChild);
        } catch (CommonException ex) {
            throw new CommonException("Solver exception: ", ex);
        }
        abductionManager.setAbducibles(abducibleContainer);

        // alebo
        //2.2 - cez ontologiu
        // - oca.kava ontologiu = zoznam axiomov, musi mat pripravenu exception ak niektory axiom nie je porporovany ako abducible
        try {
            abducibleContainer.addSymbols(man.createOntology(IOR));
        } catch (CommonException ex) {
            throw new CommonException("Solver exception: ", ex);
        }
        abductionManager.setAbducibles(abducibleContainer);


        // ****************************************************************************************************************************
        // *******************************              3  enumeration assertions                          ****************************
        // ****************************************************************************************************************************
        //3---namiesto indiv, conceptov atd…-> enum. assertions
        AbducibleContainer abdMan;

        OWLClass person = df.getOWLClass(IOR+"#Person");
//        OWLClass parent = df.getOWLClass(IOR+"#Parent");

        OWLObjectComplementOf objectComplementOfParent = df.getOWLObjectComplementOf(parent);
        OWLObjectIntersectionOf objectIntersectionOfOCOParent = df.getOWLObjectIntersectionOf(person, objectComplementOfParent);

        // create assertion
        OWLClassAssertionAxiom classAssertionAxiom = df.getOWLClassAssertionAxiom(objectIntersectionOfOCOParent, indivJack);
        try {
            abducibleContainer.addAssertion(classAssertionAxiom);
        } catch (CommonException ex) {
            throw new CommonException("Solver exception: ", ex);
        }
        abductionManager.setAbducibles(abducibleContainer);

        // setting assertion with ontology, e.j. load from file
        File file = new File ("pathname");
        OWLOntology ontAssertionList = man.loadOntologyFromOntologyDocument(IRI.create(file));
        try {
            abducibleContainer.addAssertions(ontAssertionList);
        } catch (CommonException ex) {
            throw new CommonException("Solver exception: ", ex);
        }
        abductionManager.setAbducibles(abducibleContainer);


        // ****************************************************************************************************************************
        // ****************************************************************************************************************************
        // *******************************              addtional settings                  *******************************************
        // ****************************************************************************************************************************
        // ****************************************************************************************************************************

        // addtional settings for solver (optional)
        abductionManager.setAdditionalSolverSettings("internalSettings");

        // output
        abductionManager.getOutputAdditionalInfo(); //return solver internal info (debug, etc.)
        abductionManager.getExplanations(); // return Set<OWLOntology>

        // output - thread version

        // At first monitor is set to AbductionManager.
        abductionManager.setMonitor(monitor);
        // Then a new thread with target of AbductionManager instance is created at the application.
        new Thread(abductionManager, "abductionManager").start();
        // Then method run in AbductionManager is executed and new explanations are computed.
        // If any new explanation is computed BY a solver (overriding AbductionManager.run), it will send a notification on a monitor.
        // Meanwhile, application monitor is waiting for a new explanation in method Demo.run to be showed.
    }

    @Override
    public void run() {
        while (true) {
            try {
                monitor.wait();
                System.out.println(monitor.getNextExplanation());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
