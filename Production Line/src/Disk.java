/**
 * Class Description: This class represents a single disk with a field representing its size
 * @author MurphyP1
 * @date 11/26/17
 */
public class Disk implements Comparable<Disk> {
	private int radius;
	
	/**
	 * The default constructor for a Disk which creates a Disk of random size
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method Disk
	 */
	public Disk() {
		radius = (int) (Math.random()*(10-1))+1; 	//Default constructor which picks a random radius 1,10
	}
	
	/**
	 * A constructor for a Disk which creates a Disk with a given size
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method Disk
	 * 
	 * @param r an int which represents the size for the disk
	 */
	public Disk(int r) {
		if(r > 0) //No negative radii, yo
			radius = r;	
		else 
			radius = (int) (Math.random()*(10-1))+1;
	}
	
	/**
	 * A getter method which returns the radius of the Disk
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method getRadius
	 * 
	 * @return the radius of the Disk
	 */
	public int getRadius() {
		return radius;
	}
	
	/**
	 * A method which returns the radius of the Disk in String form 
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method toString
	 * 
	 * @return the radius of the Disk in String form
	 */
	public String toString() {
		return Integer.toString(getRadius());
	}
	
	/**
	 * A comparative method which is used to order Disks according to radii
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method compareToDisk
	 * 
	 * @param arg0 a Disk which is compared to the self Disk
	 * 
	 * @return an integer representing the difference in radii between two disks
	 */
	public int compareTo(Disk arg0) {
		if(radius > arg0.getRadius()) 
			return (radius - arg0.getRadius() );	//1
		else if(radius < arg0.getRadius()) 
			return(arg0.getRadius() - radius );	//-1
		return 0;	//Radii are equal
	}
}
