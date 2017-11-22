/**
 * @author MurphyP1
 *
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ProductionLine {
	private Queue<Disk> input;	
	private Queue<Tower> output;
	private Stack<Disk> robot;
	
	//Default constructor
	public ProductionLine() {
		input = new LinkedList<Disk>();
		output = new LinkedList<Tower>();
		robot = new Stack<Disk>(); 
	}
	
	public void addDisk(Disk in) {
		input.add(in);
	}
	
	public Tower unloadRobot() {
		Tower dump = new Tower();	//Create a new temp Tower 
		while(!(robot.isEmpty()) )	//Add all the disks on the robot arm to the new Tower
			dump.push(robot.pop());
		return dump;
	}
	
	public void process() {
		Tower dump;
		
		while(!(input.peek() == null) )	{//While the input has disks
			if( !(robot.isEmpty()) && input.peek().getRadius() < robot.peek().getRadius() ) {	//if the next disk is smaller than the robot arm
				dump = unloadRobot();
				output.add(dump);	//Add the new tower to the output queue
			} else //The disk is bigger than the top, or a top disk DNE
				robot.push(input.remove());
		}	//Once input.isEmpty(), unload 
		output.add(unloadRobot());
	}
	
	public Tower removeTower() {	//Removes and returns a tower from the output Queue
		return output.remove();	//TODO ADD A TOSTRING HERE?
	}
	
	//Tower helper Methods
	public void log() {
		while(!(output.isEmpty()) ) {	//output is a bunch of towers
			String result = "\n";
			Tower current = output.remove();	
			while(!(current.isEmpty()) )	//While current has Disks inside of it 
				result += vis(current);
			
			System.out.print(result);
		}
	}
	
	//Fun challenge 
	private String vis(Tower t) {
		String result = "";	
		Tower up = t;	//TODO ??? Flips it upside down to determine the base length
		Tower down = t.flip();
		int base = down.peek().getRadius();
		//System.out.print(base);
		
		while(!(up.isEmpty()) ) {
			for(int i = 0; i < up.peek().getRadius(); i++)
				//for(int k = 0; k < base/2 - up.peek().getRadius()/2; k++)	//Spaces
				//	result += " "; 
				result += "*";
				
			result += "\n";
			up.pop();//Move to next disk
		}
		return result;
	}
	
	//Tester method
	public static void main(String[] args) {
		ProductionLine KrispyKreme = new ProductionLine();	//Creates a new production line of donut pyramids 
		
		for(int i = 0; i < 100; i ++)	//Fills the ProductionLine with yummy disks
			KrispyKreme.input.add(new Disk());
		
		KrispyKreme.input.add(new Disk(-4));	//tries to add a negative disk to goof around
		
		KrispyKreme.process();
		KrispyKreme.log();
	}
}
