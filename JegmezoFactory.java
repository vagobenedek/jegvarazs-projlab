import java.util.ArrayList;

public class JegmezoFactory {
	public JegmezoFactory(){
		System.out.println(">JegmezoFactory konstruktor");
		System.out.println("<JegmezoFactory konstruktor");
	}
	public ArrayList<Jegmezo> createJegmezo(int i) {
		System.out.println(">JegmezoFectory.createJegmezo()");
		System.out.println("<JegmezoFactory.createJegmezo()");
		return new ArrayList<Jegmezo>();
	}
}
