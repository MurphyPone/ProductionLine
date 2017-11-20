import java.util.ArrayList;

/**
 * @author MurphyP1
 *
 */

public class Tower extends ArrayList<Disk> {
	//This = arrayList of Disks
	private boolean isInverted;
	public Tower() {}
	
	
	
	
	
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
