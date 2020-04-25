import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SzereploFactory {
	//Konstruktoraban letrehozzuk a Factoryt
	public SzereploFactory() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Szereploactory letrejott\n");
		f.close();
	}
	//A factory legyartja a megfelelo szamu egyseget
	public ArrayList<Szereplo> createSzereplo(int n) throws IOException {
		System.out.println(">SzereploFactory.createSzereplo()");
		Szereplo s = new Eszkimo("init");
		System.out.println("<SzereploFactory.createSzereplo()");
		return new ArrayList<Szereplo>();
	}
	
	public void addSzereploToMezo(Mezo m) {
	}
}
