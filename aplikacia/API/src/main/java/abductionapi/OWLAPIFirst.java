package abductionapi;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

public class OWLAPIFirst {

    public static OWLClassAssertionAxiom classAssertionAxiom() throws OWLOntologyCreationException {
        IRI IOR = IRI.create("http://DLapi.test");
        OWLOntologyManager man = OWLManager.createOWLOntologyManager();
        OWLOntology o = man.createOntology(IOR);
        OWLDataFactory df = o.getOWLOntologyManager().getOWLDataFactory();

        OWLClass person = df.getOWLClass(IOR+"#Person");
        OWLClass parent = df.getOWLClass(IOR+"#Parent");
        OWLClass jack = df.getOWLClass(IOR+"#Jack");

        OWLObjectComplementOf objectComplementOfParent = df.getOWLObjectComplementOf(parent);
        OWLObjectIntersectionOf objectIntersectionOfOCOParent = df.getOWLObjectIntersectionOf(person, objectComplementOfParent);
        OWLIndividual indivJack = df.getOWLNamedIndividual(jack);
        OWLClassAssertionAxiom classAssertionAxiom = df.getOWLClassAssertionAxiom(objectIntersectionOfOCOParent, indivJack);
        o.add(classAssertionAxiom);
        System.out.println(o);
        return classAssertionAxiom;
    }

    public static void parseOwlAssertionAxiom(OWLClassAssertionAxiom classAssertionAxiom){
        System.out.println(classAssertionAxiom.getSignature());
        System.out.println(classAssertionAxiom.getAxiomType());
        System.out.println(classAssertionAxiom.getClassExpression().getClassExpressionType());
        System.out.println(classAssertionAxiom.getClassExpression());
        System.out.println(classAssertionAxiom.getClassExpression().getSignature());
    }

    public static void printAxiomsFromPizzaOntology() throws OWLOntologyCreationException {
        OWLOntologyManager man = OWLManager.createOWLOntologyManager();
        IRI pizzaontology = IRI.create("http://protege.stanford.edu/ontologies/pizza/pizza.owl");
        OWLOntology o = man.loadOntology(pizzaontology);
        for (OWLAxiom oa:
                o.getAxioms()) {
            System.out.println(oa);
            System.out.println(oa.getAxiomType());
            System.out.println(oa.getNNF());
            System.out.println(oa.toString());
            System.out.println();
            break;
        }
        System.out.println(o.getAxioms());
        System.out.println(o);
    }

    public static void declarationAxiom() throws OWLOntologyCreationException {
        IRI IOR = IRI.create("http://DLapi.test");
        OWLOntologyManager man = OWLManager.createOWLOntologyManager();
        OWLOntology o = man.createOntology(IOR);
        OWLDataFactory df = o.getOWLOntologyManager().getOWLDataFactory();
        OWLClass person = df.getOWLClass(IOR+"#Person");
        OWLDeclarationAxiom da = df.getOWLDeclarationAxiom(person);
        o.add(da);
        System.out.println(o);
    }

    public static void subClassAxiom() throws OWLOntologyCreationException {
        IRI IOR = IRI.create("http://DLapi.test");
        OWLOntologyManager man = OWLManager.createOWLOntologyManager();
        OWLOntology o = man.createOntology(IOR);
        OWLDataFactory df = o.getOWLOntologyManager().getOWLDataFactory();
        OWLClass person = df.getOWLClass(IOR+"#Person");
        OWLClass woman = df.getOWLClass(IOR+"#Woman");
        OWLSubClassOfAxiom w_sub_p = df.getOWLSubClassOfAxiom(woman, person);
        o.add(w_sub_p);
        System.out.println(o);
    }

    public static void subClassAxiom2() throws OWLOntologyCreationException {
        IRI IOR = IRI.create("http://DLapi.test");
        OWLOntologyManager man = OWLManager.createOWLOntologyManager();
        OWLOntology o = man.createOntology(IOR);
        OWLDataFactory df = o.getOWLOntologyManager().getOWLDataFactory();
        OWLClass person = df.getOWLClass(IOR+"#Person");
        OWLClass woman = df.getOWLClass(IOR+"#Woman");
        OWLSubClassOfAxiom w_sub_p = df.getOWLSubClassOfAxiom(woman, person);
        OWLClass c = df.getOWLClass(IOR + "#c");
        OWLIndividual oia = df.getOWLAnonymousIndividual();
        OWLClassAssertionAxiom caa = df.getOWLClassAssertionAxiom(c, oia);
        o.add(caa);
        o.add(w_sub_p);
        System.out.println(o);
    }

    public static void otherExample() throws OWLOntologyCreationException {
        IRI IOR = IRI.create("http://DLapi.test");
        OWLOntologyManager man = OWLManager.createOWLOntologyManager();
        OWLOntology o = man.createOntology(IOR);
        OWLDataFactory df = o.getOWLOntologyManager().getOWLDataFactory();

        OWLClass person = df.getOWLClass(IOR+"#Person");
        OWLClass parent = df.getOWLClass(IOR+"#Parent");
        OWLClass jack = df.getOWLClass(IOR+"#Jack");
        OWLIndividual indivJack = df.getOWLNamedIndividual(jack);
        OWLIndividual indivJohn = df.getOWLNamedIndividual(person);
        OWLProperty hasChild = df.getOWLObjectProperty(IOR+"#hasChild");
        OWLAxiom ax = df.getOWLObjectPropertyAssertionAxiom((OWLObjectPropertyExpression) hasChild, indivJohn, indivJack);
        o.add(ax);
        System.out.println(o);
    }

    public static void priklad() throws OWLOntologyCreationException {
        IRI IOR = IRI.create("http://DLapi.test");
        OWLOntologyManager man = OWLManager.createOWLOntologyManager();
        OWLOntology o = man.createOntology(IOR);
        OWLDataFactory df = o.getOWLOntologyManager().getOWLDataFactory();

        OWLClass person = df.getOWLClass(IOR+"#Person");
        OWLClass parent = df.getOWLClass(IOR+"#Parent");
        OWLClass jack = df.getOWLClass(IOR+"#Jack");

        OWLObjectIntersectionOf objectIntersectionOfParent = df.getOWLObjectIntersectionOf(person, parent);
        OWLIndividual indivJack = df.getOWLNamedIndividual(jack);
        OWLClassAssertionAxiom classAssertionAxiom = df.getOWLClassAssertionAxiom(objectIntersectionOfParent, indivJack);
        System.out.println(classAssertionAxiom);
        System.out.println("               " + classAssertionAxiom.getClassExpression());
        System.out.println(df.getOWLObjectComplementOf(classAssertionAxiom.getClassExpression()));
    }

    public static void main(String[] args) throws OWLOntologyCreationException {
//        printAxiomsFromPizzaOntology();
//        declarationAxiom();
//        subClassAxiom();
//        subClassAxiom2();
//        parseOwlAssertionAxiom(classAssertionAxiom());
//        otherExample();
        priklad();
    }

}
