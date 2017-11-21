/**
 * @author MurphyP1
 *
 */
import java.util.Stack;

public class Tower extends Stack<Disk>{
	//Default constructor
	public Tower() {
		super();
	}
	
	//Copy constructor	
	public Tower(Tower old) {	
		this.addAll(old);
	}
	
	//Tower methods	//BOT NECESSARY?
	public Tower flip() {		//Reverse is broken
		Tower result = new Tower();
		while(!(peek() == null) )
			result.push(pop());
		return result;
		//inverted = true
	}
	
	//TODO TODO TODO REMOVE THIS BEFORE TURNING IN 
	public String toString() {
		String result = "\n";
		Tower copy = new Tower(this);	//Have to copy tower to print other wise pop will make it empty
		while(!(copy.isEmpty()) )  
				result += copy.pop() + "\n";
		return result;
	}
	
	/*Stack implementations*/ //TODO are these even necessary?
	public Disk pop() {
		return this.remove(this.size() -1);	//Returns the top object and removes from the stack
	}
	
	public Disk peek() {	//.get(last)
		if(size() > 0)
			return (this.get(this.size() - 1));
		else return null;
	}
}
