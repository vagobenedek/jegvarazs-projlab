import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlkatreszFactory {
	/**
	 * Konstruktoraban letrehozzuk a Factoryt
	 * @throws IOException
	 */
	public AlkatreszFactory() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("AlkatreszFactory letrejott\n");
		f.close();
	}

	/**
	 * A factory legyartja a megfelelo szamu egyseget
	 * @param i int
	 * @return alkatreszek
	 * @throws IOException
	 */
	public List<Alkatresz> createAlkatresz(int i) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("AlkatreszFactory letrehozta az alkatreszeket\n");
		f.close();
		/*Legeneraljuk az osszes jatekhoz szukseges alkatreszt
		Ez egyelore a lent lathato 3 db alkatreszt jelenti*/
		List<Alkatresz> alkatreszek = new ArrayList<>();

		alkatreszek.add(new Pisztoly("init"));
		alkatreszek.add(new Patron("init"));
		alkatreszek.add(new Jelzofeny("init"));
		return alkatreszek;
	}

	/**
	 * Alkatreszt Mezohoz ad
	 * @param m Mezo
	 */
	public void addAlkatreszToMezo(Mezo m) {
	}
}
