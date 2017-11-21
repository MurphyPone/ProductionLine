/**
 * @author MurphyP1
 *
 */
public class ProductionLine {
	public static void main(String[] args) {
		Disk one = new Disk(5);
		Disk two = new Disk(1);
		Disk three = new Disk(-1);
		Disk four = new Disk(999);

		Tower lacroix = new Tower();
		lacroix.push(one);
		lacroix.push(two);
		lacroix.push(three);
		lacroix.push(four);
		
		System.out.print("Top\n" + lacroix);
		System.out.println();
		Tower flipped = lacroix.flip();
		System.out.print("flipped\n" + flipped);
		
	}
}
