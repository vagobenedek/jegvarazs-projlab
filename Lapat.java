import java.io.FileWriter;
import java.io.IOException;

/**
 * Lapat osztaly
 * Eszkozbol szarmazik le
 */
public class Lapat extends Eszkoz {
	/**
	 * Konstruktor
	 * @throws IOException
	 */
	public Lapat() throws IOException {
		super();
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Lapat letrejott\n");
		f.close();
	}

	/**
	 * Ezzel lehet a targyat hasznalni
	 * @param Sz Szereplo
	 * @throws IOException
	 */
	@Override
	public void hasznal(Szereplo Sz) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Lapat hasznalata\n");
		f.close();
		Sz.hoAsas(1);
	}
	public String getNev(){
		return "Lapat";
	}
}
