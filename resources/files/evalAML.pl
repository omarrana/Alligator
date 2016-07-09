:- multifile(clause1/2).
 eval:- 
 assert(amlPredicates(
 [
 'sameCAEXFile','sameRoleClassLib','sameRoleClass',
 'sameEClassSpec','eClassClassificationAtt','eClassVersionAtt','eClassIRDIAtt',
 'sameAttribute'
 ] 
 )), 
 consult('d:/Deutch/development/Rules4AMLIntegration/resources/files/semi1.pl'),
 consult('d:/Deutch/development/Rules4AMLIntegration/resources/files/AML_rules.pl'),
 consult('d:/Deutch/development/Rules4AMLIntegration/resources/files/edb.pl'),
 tdb.  
           
 writePredicates:-
 open('d:/Deutch/development/Rules4AMLIntegration/resources/files/output.txt',write,FileName),
 consult("d:/Deutch/development/Rules4AMLIntegration/resources/files/writeRules.pl"),
 myWrite(FileName),close(FileName).      
                                 