import java.util.ArrayList;

public class AlkatreszFactory {
	//Konstruktoraban letrehozzuk a Factoryt
	public AlkatreszFactory(){
		System.out.println(">AlkatreszFactory konstruktor");
		System.out.println("<AlkatreszFactory konstruktor");
	}
	//A factory legyartja a megfelelo szamu egyseget
	public ArrayList<Alkatresz> createAlkatresz(int i) {
		System.out.println(">AlkatreszFactory.createAlkatresz()");
		/*Legeneraljuk az osszes jatekhoz szukseges alkatreszt
		Ez egyelore a lent lathato 3 db alkatreszt jelenti*/
		Alkatresz pi = new Pisztoly("init");
		Alkatresz pa = new Patron("init");
		Alkatresz j = new Jelzofeny("init");
		System.out.println("<AlkatreszFactory.createAlkatresz()");
		return new ArrayList<Alkatresz>();
	}
	
	public void addAlkatreszToMezo(Mezo m) {
	}
}
