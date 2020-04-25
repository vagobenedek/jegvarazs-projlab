import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AlkatreszFactory {
	//Konstruktoraban letrehozzuk a Factoryt
	public AlkatreszFactory() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("AlkatreszFactory letrejott\n");
		f.close();
	}
	//A factory legyartja a megfelelo szamu egyseget
	public ArrayList<Alkatresz> createAlkatresz(int i) throws IOException {
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
