import java.io.FileWriter;
import java.io.IOException;

public class Kotel extends Eszkoz {
	public Kotel() throws IOException {
		super();
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Kotel letrejott\n");
		f.close();
	}

	/**
	 * a metodus a kotel hasznalataert felel
	 * @param sz
	 */
	public void hasznal(Szereplo sz) throws IOException {
		System.out.println(">Kotel.hasznal()");
		//lekeri a szereplo mezojet
		new Eszkimo().getMezo();
		Mezo mezo = sz.getMezo();
		mezo.lelep(sz);
		new Mezo().lelep(new Eszkimo());
		System.out.println("<Kotel.hasznal()");
	}
}
