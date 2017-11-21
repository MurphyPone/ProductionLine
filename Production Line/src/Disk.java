/**
 * 
 */

/**
 * @author MurphyP1
 *
 */
public class Disk implements Comparable<Disk> {
	private int radius;
	
	//Default constructor which picks a random radius 1,10
	public Disk() {
		radius = (int) (Math.random()*(10-1))+1;
	}
	
	//Constructor with Arguments
	public Disk(int r) {
		radius = r;
	}
	
	//Getter
	public int getRadius() {
		return radius;
	}
	
	public String toString() {
		return Integer.toString(getRadius());
	}
	
	@Override
	public int compareTo(Disk arg0) {	//TODO need to use object and instanceof ? or only in Comparators?
		if(radius > arg0.getRadius()) 
			return (radius - arg0.getRadius() );	//1
		else if(radius < arg0.getRadius()) 
			return(arg0.getRadius() - radius );	//-1
		return 0;
	}
}
