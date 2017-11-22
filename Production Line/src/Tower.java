/**
 * @author MurphyP1
 *
 */
import java.util.Stack;

public class Tower extends Stack<Disk> {
	
	//Default constructor
	public Tower() {
		super();
	}
	
	//Copy constructor	
	public Tower(Tower old) {	
		this.addAll(old);
	}
	
	/* Tower methods */	
	public Tower flip() {		
		Tower copy = new Tower(this);	//Have to copy otherwise it destroys the tower
		Tower result = new Tower();
		
		while(!(copy.isEmpty()) )
			result.push(copy.pop());
		return result;
	}
	
	/* NON DESTRUCTIVE TOSTRING()
	 
	public String toString() {
		String result = "\n";
		Tower copy = new Tower(this);	//Have to copy tower to print other wise pop will make it empty
		while(!(copy.isEmpty()) )  
				result += copy.pop() + "\n";
		return result;
	} */
}
