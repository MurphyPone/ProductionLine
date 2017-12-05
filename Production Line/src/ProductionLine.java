/**
 * Class Description: This class represents a conveyer belt which picks up Disks and builds builds an inverted Tower out of them 
 * 						until the next incoming Disk is smaller than the top Disk on the robot arm's Tower.  Once the Tower has 
 * 						been filled to capacity (the incoming Disk is smaller than top Disk on the robot arm's Tower), the Tower
 * 						is dumped onto the output conveyer belt.
 * 
 * 						Also displays the Towers in a somewhat appealing manner (probably would look cooler in JavaScript :p)
 * @author MurphyP1
 * @date 11/26/17
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ProductionLine {
	private Queue<Disk> input;	//Incoming line of Disks
	private Queue<Tower> output;	//Outgoing, non-inverted Towers
	private Stack<Disk> robot;	//The logic between which builds Towers and flips them over onto the output
	
	/**
	 * The default constructor for a ProductionLine which instantiates the input, output, and robot
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method ProductionLine
	 */
	public ProductionLine() {
		input = new LinkedList<Disk>();
		output = new LinkedList<Tower>();
		robot = new Stack<Disk>(); 
	}
	/**
	 * A method which adds a Disk to the input queue
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method addDisk
	 * 
	 * @param in a Disk to be added to the input Queue
	 */
	public void addDisk(Disk in) {
		input.add(in);
	}
	
	/**
	 * A method which flips the Tower in the Robot arm onto the output queue 
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method unloadRobot
	 * 
	 * @return a Tower which is right-side up (pyramid shaped)
	 */
	public Tower unloadRobot() {
		Tower dump = new Tower();	//Create a new temp Tower 
		while(!(robot.isEmpty()) )	//Add all the disks on the robot arm to the new Tower
			dump.push(robot.pop());
		return dump;
	}
	
	/**
	 * The loop of the ProductionLine which empties the input queue, builds Towers, and unloads the arm into the output 
	 * 		queue using the previously declared methods.
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method process
	 */
	public void process() {
		Tower dump;	//declares dump to be re-used throughout the process 
		
		while(!(input.peek() == null) )	{//While the input has disks
			if( !(robot.isEmpty()) && input.peek().getRadius() < robot.peek().getRadius() ) {	//if the next disk is smaller than the robot arm
				dump = unloadRobot();
				output.add(dump);	//Add the new tower to the output queue
			} else //The disk is bigger than the top, or a top disk DNE
				robot.push(input.remove());
		}	//Once input.isEmpty(), unload 
		output.add(unloadRobot());
	}
	
	/**
	 * A method which removes the next Tower from the output and returns it
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method removeTower
	 * 
	 * @return the first Tower in the Queue 
	 */
	public Tower removeTower() {	//Removes and returns a tower from the output Queue
		return output.remove();	
	}
	
	/* Tower helper Methods */
	
	/**
	 * A method prints the contents of the output as individual Towers, representing the size of its Disks as *s
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method log
	 */
	public void log() {
		while(!(output.isEmpty()) ) {	//While there are Towers in the output queue
			String result = "\n";	
			Tower current = output.remove();	
			while(!(current.isEmpty()) )	//While current has Disks inside of it 
				result += vis(current);	//adds the visualization of a Tower to the output String
			
			System.out.print(result);
		}
	}
	
	/**
	 * A fun challenge which prints the size of the Disks in a Tower in a neat way
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method vis
	 * 
	 * @param t a Tower to be printed
	 * 
	 * @return a String of *s which represent the Disks making up Tower t
	 */
	private String vis(Tower t) {
		String result = "";	
		Tower up = t;	//Flips it upside down to determine the base length
		Tower down = t.flip();
		int base = down.peek().getRadius();
		
		while(!(up.isEmpty()) ) {
			result += up.peek() + " ";	//adds the numerical size of the Disk to the representation for speedy viewing 
			for(int i = 0; i < up.peek().getRadius(); i++)
				//for(int k = 0; k < base/2 - up.peek().getRadius()/2; k++)	//centering gone wrong
					//result += " "; 
				result += "* ";
				
			result += "\n";
			up.pop();//Move to next disk
		}
		return result;
	}
	
	/**
	 * The tester method for ProducitonLine
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method main
	 * 
	 * @param args and array of Strings which can be read in the command line on execution 
	 */
	public static void main(String[] args) {
	/*First Test*/ 
		System.out.print("KRISPY KREME DONUT ASSEMBLER");
		ProductionLine KrispyKreme = new ProductionLine();	//Creates a new production line of donut pyramids 
		
		for(int i = 0; i < 100; i ++)	//Fills the ProductionLine with yummy disks
			KrispyKreme.input.add(new Disk());
		
		KrispyKreme.input.add(new Disk(-4));	//tries to add a negative disk to goof around
		
		KrispyKreme.process();
		KrispyKreme.log();
		
	/*Second Test, with intent to break*/
		System.out.print("GYZA'S FINEST SAND STACKS");
		ProductionLine pyramids = new ProductionLine();
		
		pyramids.addDisk(null);
		pyramids.process();
		pyramids.log();
		
		for(int i = 0; i < 100; i ++)
			pyramids.addDisk(new Disk() );
		
		pyramids.process();	//TODO fix why can't this process twice??
		pyramids.log();
		
	/*Third Test, with intent to break*/
		System.out.print("TONY'S TOPPLY TUNES");
		ProductionLine vinyls = new ProductionLine();
		
		vinyls.addDisk(new Disk(-5));
		vinyls.addDisk(new Disk(9) );
		vinyls.process();
		vinyls.log();
	}
}
