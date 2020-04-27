import java.io.FileWriter;
import java.io.IOException;

/**
 * Buvarruha osztaly
 * Eszkozbol szarmozik le
 */
public class Buvarruha extends Eszkoz {
	/**
	 * Konstuktor
	 * @throws IOException
	 */
	public Buvarruha() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Buvarruha letrejott.\n");
		f.close();
	}

	/**
	 * Nev lekerdezo fuggveny
	 * @return String
	 */
	public String getNev(){
		return "Buvarruha";
	}
	/**
	 * hasznal fuggveny
	 * @param sz Szereplo
	 */
	@Override
	public void hasznal(Szereplo sz) {
	}
}
