import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Targy {
	public Targy() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Targy letrejott\n");
		f.close();
	}

	/**
	 * Targy fekvesz fuggvenye
	 * @param sz
	 * @throws IOException
	 */
	public void felvesz(Szereplo sz) throws IOException {

	}

}
