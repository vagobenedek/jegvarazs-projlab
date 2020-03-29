import java.util.ArrayList;

public class AlkatreszFactory {
	public AlkatreszFactory(){
		System.out.println(">AlkatreszFactory konstruktor");
		System.out.println("<AlkatreszFactory konstruktor");
	}
	public ArrayList<Alkatresz> createAlkatresz(int i) {
		System.out.println(">AlkatreszFactory.createAlkatresz()");
		Alkatresz pi = new Pisztoly();
		Alkatresz pa = new Patron();
		Alkatresz j = new Jelzofeny();
		System.out.println("<AlkatreszFactory.createAlkatresz()");
		return new ArrayList<Alkatresz>();
	}
	
	public void addAlkatreszToMezo(Mezo m) {
	}
}
