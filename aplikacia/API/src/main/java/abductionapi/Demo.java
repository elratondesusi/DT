package abductionapi;


import abductionapi.exception.CommonException;
import abductionapi.factory.AbductionFactory;
import abductionapi.manager.AbducibleManager;
import abductionapi.manager.AbductionManager;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Demo {


    public static void main(String[] args) throws OWLOntologyCreationException {

        // OWL Api
        IRI IOR = IRI.create("http://my-test-web.test");
        OWLOntologyManager man = OWLManager.createOWLOntologyManager();
        OWLOntology o = man.createOntology(IOR);
        OWLDataFactory df = o.getOWLOntologyManager().getOWLDataFactory();


       AbductionFactory dLAbductionFactory ;//= new AbductionFactory();
        // Abduction API
       AbductionManager dLAbductionManager = dLAbductionFactory.createDLAbductionManager();

        // input
        // .owl or OWLOntology
        dLAbductionManager.setInput(new File("example-input.owl"));
        OWLOntology inputOntology = man.createOntology(IOR);
        dLAbductionManager.setInput(inputOntology);

        // output - optional
        // default - a file called "explanation.owl" and path is the same as plugin`s path plus /explanation
        //         - returning type of executing abduction is org.semanticweb.owlapi.model.OWLOntology
        // - output file format can be set using OWLDocumentFormat
        dLAbductionManager.setOutputFileNameAndPath("myFirstExplanation", "/firstTry");
        dLAbductionManager.setOutputFileNameAndPath("myFirstExplanation", null);
        dLAbductionManager.setOutputFileNameAndPath(null, "/firstTry");
        dLAbductionManager.setOutputFileNameAndPath(false); // no .owl file will be created
//        dLAbductionManager.setOutputFileFormat(someOWLDocumentFormat);

        // observation/s
        OWLOntology observationOntology = man.createOntology(IOR);
        Set<OWLOntology> observationOntologySet = new HashSet<>();
        try {
            dLAbductionManager.setObservation(observationOntologySet);
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

        // with Abducible manager
        AbducibleManager abducibleManager = dLAbductionFactory.createAbducibleManager();;

        abducibleManager.allowLoops(); //(boolean default=true)
        abducibleManager.allowLoops(false);
        abducibleManager.allowRoleAssertions();
        abducibleManager.allowConceptAssertions();
        abducibleManager.allowComplexConcepts();
        abducibleManager.allowConceptComplement();

        // ****************************************************************************************************************************
        // *******************************              2  enumeration abducibles                          ****************************
        // ****************************************************************************************************************************
        //2. --- bud enum abd. cez abducibleManager alebo cez ontologiu
        //2.1--- enumeration abducibles - enumeration of everything we want to be enabled. e.x.: 4 concepts -> 4 assertions or individuals, concept -> combinations

        //bud prvy sposob
        // create inviduals
        OWLClass jack = df.getOWLClass(IOR+"#Jack");
        OWLIndividual indivJack = df.getOWLNamedIndividual(jack);

        try {
            abducibleManager.addSymbol(indivJack); // expects NamedInd, Role, alebo Concept
        } catch (CommonException ex) {
            throw new CommonException("Solver exception: ", ex);
        }

        OWLClass jill = df.getOWLClass(IOR+"#jill");
        OWLIndividual indivJIll = df.getOWLNamedIndividual(jill);

        try {
            abducibleManager.addSymbol(indivJIll); // expects NamedInd, Role, alebo Concept
        } catch (CommonException ex) {
            throw new CommonException("Solver exception: ", ex);
        }
        dLAbductionManager.setAbducibles(abducibleManager);


        // aleb0
        //2.2 - cez ontologiu
        // - oca.kava ontologiu = zoznam axiomov, musi mat pripravenu exception ak niektory axiom nie je porporovany ako abducible
        try {
            abducibleManager.addSymbols(man.createOntology(IOR)); // expects NamedInd, Role, alebo Concept
        } catch (CommonException ex) {
            throw new CommonException("Solver exception: ", ex);
        }
        dLAbductionManager.setAbducibles(abducibleManager);


        // ****************************************************************************************************************************
        // *******************************              3  enumeration assertions                          ****************************
        // ****************************************************************************************************************************
        //3---namiesto indiv, conceptov atd…-> enum. assertions
        AbducibleManager abdMan;

        OWLClass person = df.getOWLClass(IOR+"#Person");
        OWLClass parent = df.getOWLClass(IOR+"#Parent");

        OWLObjectComplementOf objectComplementOfParent = df.getOWLObjectComplementOf(parent);
        OWLObjectIntersectionOf objectIntersectionOfOCOParent = df.getOWLObjectIntersectionOf(person, objectComplementOfParent);

        // create assertion
        OWLClassAssertionAxiom classAssertionAxiom = df.getOWLClassAssertionAxiom(objectIntersectionOfOCOParent, indivJack);
        try {
            abducibleManager.addAssertion(classAssertionAxiom);
        } catch (CommonException ex) {
            throw new CommonException("Solver exception: ", ex);
        }
        dLAbductionManager.setAbducibles(abducibleManager);

        // setting assertion with ontology, e.j. load from file
        File file = new File ("pathname");
        OWLOntology ontAssertionList = man.loadOntologyFromOntologyDocument(IRI.create(file));
        try {
            abducibleManager.addAssertions(ontAssertionList);
        } catch (CommonException ex) {
            throw new CommonException("Solver exception: ", ex);
        }
        dLAbductionManager.setAbducibles(abducibleManager);


        // ****************************************************************************************************************************
        // ****************************************************************************************************************************
        // *******************************              addtional settings                  *******************************************
        // ****************************************************************************************************************************
        // ****************************************************************************************************************************

        // addtional settings for solver (optional)
        dLAbductionManager.setAdditionalSolverSettings("internalSettings");

        // output
        dLAbductionManager.getOutputAdditionalInfo(); //return solver internal info (debug, etc.)
        dLAbductionManager.getExplanations(); // return Set<OWLOntology>

    }

}
