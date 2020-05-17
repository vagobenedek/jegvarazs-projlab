import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * SzereploFactory osztaly
 * Szereploket hoz letre
 */
public class SzereploFactory {
	/**
	 * Konstruktoraban letrehozzuk a Factoryt
	 * @throws IOException
	 */
	public SzereploFactory() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("SzereploFactory letrejott\n");
		f.close();
	}

	/**
	 * A factory legyartja a megfelelo szamu egyseget
	 * @param n int
	 * @return
	 * @throws IOException
	 */
	public List<IKarakter>  createSzereplo(int eszkimo, int sarkkutato) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("SzereploFactory letrehozta a karaktereket\n");
		f.close();
		List<IKarakter> karakterek = new ArrayList<>();
		for (int i = 0; i != eszkimo; i++){
			karakterek.add(new Eszkimo());
		}
		for (int i = 0; i!= sarkkutato;i++){
			karakterek.add(new Sarkkutato());
		}
		return karakterek;
	}
}
