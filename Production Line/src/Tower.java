/**
 * @author MurphyP1
 *
 */
import java.util.ArrayList;
//import java.util.Stack;

public class Tower extends ArrayList<Disk> {
	//This = arrayList of Disks
	private boolean isInverted;
	
	//Default constructor
	public Tower() {
		super();
	}
	
	//Copy constructor
	public Tower(ArrayList<Disk> old) {	//Is this allowed?
		for(Disk d : old) 
			this.add(d);
	}
	
	//Tower methods
	public Tower flip() {		//Reverse is broken
		Tower result = new Tower();
		while(!(peek() == null) )
			result.push(pop());
		return result;
		//inverted = true
	}
	
	public String toString() {
		String result = "";
		Tower copy = new Tower(this);	//Have to copy tower to print other wise pop will make it empty
		while(!(copy.peek() == null) )  
				result += copy.pop() + "\n";
		return result;
	}
	
	/*Stack implementations*/
	public boolean isEmpty() {	//Unnecessary 
		return this.isEmpty();
	}
	
	public void push(Disk x) {	//Alias for add
		this.add(x);
	}

	public Disk pop() {
		return this.remove(this.size() -1);	//Returns the top object and removes from the stack
	}
	
	public Disk peek() {	//.get(last)
		if(size() > 0)
			return (this.get(this.size() - 1));
		else return null;
	}
}
