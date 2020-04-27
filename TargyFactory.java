import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * TargyFactory osztaly
 * Targyakat hoz letre
 */
public class TargyFactory {
	/**
	 * Konstuktor
	 * @throws IOException
	 */
	public TargyFactory() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("TargyFactory letrejott\n");
		f.close();
	}

	/**
	 * Letrehozza a targyakat
	 * @param i int
	 * @return
	 */
	public ArrayList<ITargy> createTargy(int i) {
		return new ArrayList<ITargy>();
	}
}
