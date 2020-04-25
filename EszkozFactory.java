import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EszkozFactory {
	//Konstruktoraban letrehozzuk a Factoryt
	public EszkozFactory() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("EszkozFactory letrejott\n");
		f.close();
	}
	//A factory legyartja a megfelelo szamu egyseget
	public ArrayList<Eszkoz> createEszkoz(int i) throws IOException {
		System.out.println(">EszkozFactory.createEszkoz()");
		//Letrehozza a megfelelo szamu eszkozt, majd visszaadja azokat egy listaban
		Eszkoz e = new Elelem("init");
		System.out.println("<EszkozFactory.createEszkoz()");
		return new ArrayList<Eszkoz>();
	}
	
	public void addEszkozToMezo(Mezo m) {
	}
}
