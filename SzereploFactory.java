import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	public List<IKarakter>  createSzereplo(int n) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("SzereploFactory letrehozta a karaktereket\n");
		f.close();
		List<IKarakter> karakterek = new ArrayList<>();
		for (int i = 0; i != n; i++){
			karakterek.add(new Eszkimo());
		}
		return karakterek;
	}
}
