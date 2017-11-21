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
		Tower dump = new Tower();	//Create a new temp tower 
		while(!(robot.isEmpty()) )	//Add all the disks on the robot arm to the new Tower
			dump.push(robot.pop());
		return dump;
	}
	
	public void process() {
		Tower dump;
		
		while(!(input.peek() == null) )	{//While the input has disks
			if(!(robot.isEmpty()) && input.peek().getRadius() < robot.peek().getRadius()) {	//if the next disk is smaller than the robot arm
				dump = unloadRobot();
				output.add(dump);	//Add the new tower to the output queue
			} else //The disk is bigger than the top, or a top disk DNE
				robot.push(input.remove());
		}	
		//Once input.peek() == null, unload 
		dump = unloadRobot();
		output.add(dump);
	}
	
	public Tower removeTower() {	//Removes and returns a tower from the output Queue
		return output.remove();
	}
	
	public void log() {
		while(!(output.peek() == null))
			System.out.print(removeTower());
	}
	
	public static void main(String[] args) {
		ProductionLine KrispyKreme = new ProductionLine();
		
		for(int i = 0; i < 100; i ++)
			KrispyKreme.input.add(new Disk());
		
		KrispyKreme.input.add(new Disk(-4));	//Adds a negative disk to goof around
		
		KrispyKreme.process();
		KrispyKreme.log();
		
		
		/*
		Tower lacroix = new Tower();
		lacroix.push(one);
		lacroix.push(two);
		lacroix.push(three);
		lacroix.push(four);
		
		System.out.print("Top\n" + lacroix);
		System.out.println();
		Tower flipped = lacroix.flip();
		System.out.print("flipped\n" + flipped);
		*/
		
	}
}
