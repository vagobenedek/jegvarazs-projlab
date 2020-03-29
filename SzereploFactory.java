import java.util.ArrayList;

public class SzereploFactory {
	//Konstruktoraban letrehozzuk a Factoryt
	public SzereploFactory(){
		System.out.println(">SzereploFactory konstruktor");
		System.out.println("<SzereploFactory konstruktor");
	}
	//A factory legyartja a megfelelo szamu egyseget
	public ArrayList<Szereplo> createSzereplo(int n) {
		System.out.println(">SzereploFactory.createSzereplo()");
		Szereplo s = new Eszkimo("init");
		System.out.println("<SzereploFactory.createSzereplo()");
		return new ArrayList<Szereplo>();
	}
	
	public void addSzereploToMezo(Mezo m) {
	}
}
