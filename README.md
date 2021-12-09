# DL Abduction API
- diplom thesis: description logic abduction API implemented in JAVA

## Annotation
While multiple DL abduction solvers have been developed (e.g. AAA, MXPMHS, MergeXplain, QuickXplain) their integration into various practical tools
so far has been ad hoc. There is yet no DL abduction API that would enable
such integration to be modular, similar to the well known OWL API that is now
the golden standard for integration of deductive DL reasoners.

## Goals
1. Synthesize functionalities and capabilities of different DL abduction solvers.
2. Develop an API interface library for integrating abduction slovers into other
software.
3. Implement the API in one solver and one other tool using the solver

## Literature
1. Júlia Pukancová, Martin Homola: Abductive Reasoning with Description Logics: Use Case in Medical Diagnosis. Description Logics 2015
2. Elsenbroich, C., Kutz, O. and Sattler, U., 2006. A case for abductive reasoning over ontologies. In: OWLED*06
3. Rudolph, S., 2011. Foundations of description logics. In Reasoning Web International Summer School (pp. 76-136). Springer, Berlin, Heidelberg.
4. Júlia Pukancová, Martin Homola. Tableau-Based ABox Abduction for the ALCHO Description Logic. In: Description Logics 2017. 
5. Schekotihin, K., Rodler, P. and Schmid, W., 2018. Ontodebug: Interactive ontology debugging plug-in for protégé. In International Symposium on Foundations of Information and Knowledge Systems (pp. 340-359). Springer, Cham.
6. Martin Homola, Júlia Pukancová, Júlia Gablíková, Katarína Fabianová. Merge, Explain, Iterate. In: Description Logics, 2020.
7. Pukancová, J. and Homola, M., 2020. The AAA ABox Abduction Solver. KI-Künstliche Intelligenz, pp.1-6.
8. Horridge, M., Bechhofer, S., 2011. The OWL API: A Java API for OWL ontologies. Semantic Web 2(1):11-21
9. Del-Pinto, W. and Schmidt, R.A., 2019. ABox abduction via forgetting in ALC. In Proceedings of the AAAI Conference on Artificial Intelligence (Vol. 33, No. 01, pp. 2768-2775).
10. Koopmann, P., Del-Pinto, W., Tourret, S. and Schmidt, R.A., 2020. Signature-Based Abduction for Expressive Description Logics. In Proceedings of the International Conference on Principles of Knowledge Representation and Reasoning (Vol. 17, No. 1, pp. 592-602).


10. Koopmann, P., Del-Pinto, W., Tourret, S. and Schmidt, R.A., 2020. Signature-Based Abduction for Expressive Description Logics. In Proceedings of the International Conference on Principles of Knowledge Representation and Reasoning (Vol. 17, No. 1, pp. 592-602).


## What is done?
Before week 15.2.2021 - reading: [1], [3], [2], [5], [4], [6], [7].

#### 15.2.2021
- Get acquainted with the ida of OWL API [8]  
- Finding code of Ontology Debugger, MergeXplain, QuickXplain, see how the solvers are integrated into Ontology Debugger  
#### 15.2.2021
- Continue: Get acquainted with the ida of OWL API [8]  
- Continue: Try to find code of Ontology Debugger, MergeXplain, QuickXplain, see how the solvers are integrated into Ontology Debugger  
- Started studying capabilities of all abduction solvers (MergeXplain, QuickXplain, AAA, MHS-MXP)  
#### 1.3.2021 
- Creating a basic version of the API (on paper) and describe how it will work  
#### 8.3.2021 
- Try to understand how axioms constructed via OWLDataFactory can be processed and reinterperted  
- Finalizing basic version of the API (on paper) and describing how it will work  
#### 15.3.2021 -
Holiday.
#### 22.3.2021
- Creating an example of OWLApi usage
#### 29.3.2021
 - Holiday.
#### 5.4.2021
 - Learnign more about parameters from AAA Solver
#### 12.4.2021 -  
- Creating an example of Our api + OWLApi
#### 19.4.2021 -  
- Figuring out how will solver communicate explanations incementally to our api. Considerating threads in java (calling notify() from solver).
#### 26.4.2021 -  
Creating demo. Thinking about exceptions from solvers.
#### 3.5.2021 -  
- Summarizing what is done and what is needed to be done.
- Considering 2 classes (api manager and abducible manager) 
#### 10.5.2021 -
Preparating presentation for Project semminar 1.
