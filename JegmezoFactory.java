import java.util.ArrayList;

public class JegmezoFactory {
	//Konstruktoraban letrehozzuk a Factoryt
	public JegmezoFactory(){
		System.out.println(">JegmezoFactory konstruktor");
		System.out.println("<JegmezoFactory konstruktor");
	}
	//A factory legyartja a megfelelo szamu egyseget
	public ArrayList<Jegmezo> createJegmezo(int i) {
		System.out.println(">JegmezoFectory.createJegmezo()");
		System.out.println("<JegmezoFactory.createJegmezo()");
		return new ArrayList<Jegmezo>();
	}
}
