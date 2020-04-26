import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class EszkozFactory {
	//Konstruktoraban letrehozzuk a Factoryt
	public EszkozFactory() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("EszkozFactory letrejott.\n");
		f.close();
	}
	//A factory legyartja a megfelelo szamu egyseget
	public List<Eszkoz> createEszkoz(int i) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("EszkozFactory letrehozta az eszkozoket.\n");
		f.close();
		//Letrehozza a megfelelo szamu eszkozt, majd visszaadja azokat egy listaban
		List<Eszkoz> eszkozok = new ArrayList<>();
		for (int j = 0; j!=i; j++){
			eszkozok.add(new Elelem("init"));
		}
		return eszkozok;
	}
	
	public void addEszkozToMezo(Mezo m) {
	}
}
