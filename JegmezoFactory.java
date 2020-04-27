import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JegmezoFactory {
	/**
	 * Konstruktoraban letrehozzuk a Factoryt
	 * @throws IOException
	 */
	public JegmezoFactory() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("JegmezoFactory letrejott.\n");
		f.close();
	}

	/**
	 * A factory legyartja a megfelelo szamu egyseget
	 * @param i int
	 * @return mezok List
	 * @throws IOException
	 */
	public List<Mezo> createJegmezo(int i) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("JegmezoFactory letrehozta a mezoket.\n");
		f.close();
		List<Mezo> mezok = new ArrayList<>();
		for (int j = 0; j != i;j++){
			mezok.add(new Stabil());
		}
		return mezok;
	}
}
