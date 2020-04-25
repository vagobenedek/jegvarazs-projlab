import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class KarakterFactory {
	//Konstruktoraban letrehozzuk a Factoryt
	public KarakterFactory() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("KarakterFactory letrejott\n");
		f.close();
	}
	//A factory legyartja a megfelelo szamu egyseget
	public ArrayList<Szereplo> createKarakter(int n) throws IOException {
		System.out.println(">KarakterFactory.createKarakter()");
		Szereplo s = new Eszkimo("init");
		System.out.println("<KarakterFactory.createKarakter()");
		return new ArrayList<Szereplo>();
	}
	
	public void addKarakterToMezo(Mezo m) {
	}
}
