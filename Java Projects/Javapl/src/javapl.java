import java.util.Hashtable;
import java.util.Map;
import org.jpl7.*;

public class javapl {
    
    public static void main(String[] args) {
        /*//Ascendente
        Query ql = new Query("consult('ascendente.pl')");
        System.out.println(ql.toString() + (ql.hasSolution()? "Success!" : "Failed!"));
        
        try {
           Query q2 = new Query(
                "descendente([3,2,1])"
            );
            System.out.println(q2.hasSolution());
        }
        catch(PrologException pl) {
            System.out.println(pl.getMessage());
        }*/
        
        /*Query q = new Query("consult('belongs')");
        System.out.println(q.toString() + " " + (q.hasSolution() ? "Success!" : "Failed!"));
        
        try {
            Query q2 = new Query(
                "belongs([1,2,3], 1)"
            );
            System.out.println(q2.hasSolution());
        }
        catch(PrologException pl) {
            System.out.println(pl.getMessage());
        }
    }*/
        
        /*Query q = new Query("consult('equalList')");
        System.out.println(q.toString() + " " + (q.hasSolution() ? "Success!" : "Failed!"));
        String name = "equalList";
        
        try {
            Query q2 = new Query(
                name + "([1,1,1,1,0])"
            );
            System.out.println(q2.hasSolution());
        }
        catch(PrologException pl) {
            System.out.println(pl.getMessage());
        }*/
        
        Query q = new Query("consult('king')");
        System.out.println(q.toString() + " " + (q.hasSolution() ? "Success!" : "Failed!"));
        String name = "salta";
        int x = 4;
        int y = 1;
        
        try {
            Variable c = new Variable("C");
            Query q2 = new Query(
                name + "([ " + x + ", " + y + "], " + c + ")"
            );
            Map<String, Term> solution;
            q2.open();
            while((solution = q2.getSolution()) != null) {
                //Map<String, Term> solution = q.nextSolution();
                Term t = (Term) solution.get("C");
                System.out.println(t.arg(1).toString() + ' ' + t.arg(2).arg(1).toString());
            }
        }
        catch(PrologException pl) {
            System.out.println(pl.getMessage());
        }
    
    }  
}
