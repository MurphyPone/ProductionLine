/**
 * Class Description: This class represents a stack of Disks
 * @author MurphyP1
 * @date 11/26/17
 */
import java.util.Stack;

public class Tower extends Stack<Disk> {
	
	/**
	 * The default constructor for a Tower which  calls its parent (Stack) default constructor 
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method Tower
	 */
	public Tower() {
		super();
	}
	
	/**
	 * A constructor for a Tower which creates a copy of another Tower
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method Tower
	 */	
	public Tower(Tower old) {	
		this.addAll(old);
	}
	
	/* Tower methods */	
	
	/**
	 * A method flips a Tower (top Disk is now bottom Disk, top-1 is bottom+1 etc. )
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method flip
	 * 
	 * @return a Tower which has been inverted
	 */	
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
