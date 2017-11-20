import java.util.ArrayList;

/**
 * @author MurphyP1
 *
 */

public class Tower extends ArrayList<Disk> {
	//This = arrayList of Disks
	private boolean isInverted;
	
	//Default constructor
	public Tower() {}
	
	//Copy constructor
	public Tower(ArrayList<Disk> old) {
		for(Disk d : old) 
			this.add(d);
	}
	
	//Tower methods
	public void flip() {		//Reverse is broken
		Tower old = new Tower(this);
		for(int i = 0; i > 0; i--) {
			this.set(i,  old.get(i) );	 
		}
	}
	
	
	
	
	//Stack implementation
	public boolean isEmpty() {
		return this.isEmpty();
	}
	
	public void push(Disk x) {
		this.add(x);
	}
		//TODO IK THAT THE USE OF "this." IS UNNECESSARY, BUT DOES THIS COUNT AS IMPLEMENTING AS A STACK
	public Disk pop() {
		return this.remove(this.size() -1);	//Returns the top object and removes from the stack
	}
	
	public Disk peek() {
		return (this.get(this.size() - 1));
	}
}
