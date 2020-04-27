import java.io.FileWriter;
import java.io.IOException;

public class Eszkimo extends Szereplo {
	/**
	 * Konstuktor
 	 * @throws IOException
	 */
	public Eszkimo() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Eszkimo letrejott.\n");
		f.close();
		setMaxtestho(5);

	}

	/**
	 *Konstruktor
	 * @param s String
	 * @throws IOException
	 */
	public Eszkimo(String s) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Eszkimo letrejott.\n");
		f.close();
	}

	/**
	 * Eszkimo kepesseghasznalata fuggveny, hasznalja a kepesseget es csokken a lepesszama
	 * @param i int
	 * @throws IOException
	 */
	public void kepessegHasznalat(int i) throws IOException {
		getMezo().iglutEpit();
		FileWriter f = new FileWriter("./kimenet.txt", true);
		//f.append("Eszkimo kepesseg hasznalata sikeres.\n");
		f.append("A szereplo hasznalja a kepesseget.\n");
		f.close();
		getjListener().hoviharSzamlaloCsokkentoListener();
		setLepesszam(getLepesszam()-1);
	}
}
