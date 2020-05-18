import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * EszkozFactory
 * Ez hozza letre az eszkozoket
 */
public class EszkozFactory {
	/**
	 * Konstruktoraban letrehozzuk a Factoryt
	 * @throws IOException
	 */
	public EszkozFactory() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("EszkozFactory letrejott.\n");
		f.close();
	}

	/**
	 * A factory legyartja a megfelelo szamu egyseget
	 * @param i int
	 * @return eszkozok
	 * @throws IOException
	 */
	public List<Eszkoz> createEszkoz(int i) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("EszkozFactory letrehozta az eszkozoket.\n");
		f.close();
		//Letrehozza a megfelelo szamu eszkozt, majd visszaadja azokat egy listaban
		List<Eszkoz> eszkozok = new ArrayList<>();
		for (int j = 0; j!=i; j++){
			eszkozok.add(new Elelem("init"));
			eszkozok.add(new Lapat());
			eszkozok.add(new TorekenyLapat());
			eszkozok.add(new Sator());
			eszkozok.add(new Buvarruha());
		}
		return eszkozok;
	}

	/**
	 * addEszkozToMezo fuggveny
	 * @param m
	 */
	public void addEszkozToMezo(Mezo m) {
	}
}
