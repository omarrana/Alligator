package main;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.jpl7.Query;
import org.jpl7.Term;

/**
 * 
 * @author Irlan
 *
 */
public class DeductiveDB {
	
	/**
	 * Querying the knowledge base. 
	 */
	public void consultKB() {
		String t7 = "consult('resources/semi1.pl')";
		System.out.println(t7 + " " + (Query.hasSolution(t7) ? "succeeded" : "failed"));
		
		String t8 = "consult('resources/exampleAML.pl')";
		System.out.println(t8 + " " + (Query.hasSolution(t8) ? "succeeded" : "failed"));
		
		String t9 = "tdb.";
		System.out.println(t9 + " " + (Query.hasSolution(t9) ? "succeeded" : "failed"));
		
		String stringFileQuery = "sameCAEXFile(X,Y)";
		System.out.println(stringFileQuery + " " + (Query.hasSolution(stringFileQuery) ? "succeeded" : "failed"));
		Query fileQuery = new Query(stringFileQuery);
		Map<String, Term> s10;
		System.out.println("all solutions of " + stringFileQuery);
		
		Map<Term,Term> sol = new Hashtable<Term, Term>();
		
		boolean toAdd = true;
		while (fileQuery.hasMoreSolutions()) {
			s10 = fileQuery.nextSolution();
			if(s10.get("X").equals(s10.get("Y"))){
			}else{
			    Term t1 = (Term) s10.get("X");
			    Term t2 = (Term) s10.get("Y");
			    if(sol.containsKey(t1)){
			    	//System.out.println("T1 Key");
			    	toAdd = false;
			    }
			    if(sol.containsValue(t1)){
			    	//System.out.println("T1 VALUE");
			    	toAdd = false;
			    }
			    if(sol.containsKey(t2)){
			    	//System.out.println("T2 Key");
			    	toAdd = false;
			    }
			    if(sol.containsValue(t2)){
			    	//System.out.println("T2 VALUE");
			    	toAdd = false;
			    }
			    
			    if(toAdd)
			    sol.put(t1, t2);
			}
		}
		
		Set<Term> keys = sol.keySet();
        for(Term key: keys){
            System.out.println("Value of "+key+" is: "+sol.get(key));
        }
        
        String evalAML = "consult('resources/evalAML.pl')";
        System.out.println(evalAML + " " + (Query.hasSolution(evalAML) ? "succeeded" : "failed"));
        
        String t1 = "consult('resources/writeRules.pl')";
        System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
        
       
        String aa = "writePredicates.";
		System.out.println(aa + " " + (Query.hasSolution(aa) ? "succeeded" : "failed"));
        
	}
	


}
