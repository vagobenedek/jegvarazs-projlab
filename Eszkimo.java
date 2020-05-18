import java.io.FileWriter;
import java.io.IOException;

/**
 * Eszkimo szereplo
 * Szereplobol szarmazik le
 */
public class Eszkimo extends Szereplo {
	/**
	 * Konstuktor
 	 * @throws IOException
	 */
	public Eszkimo() throws IOException {
		super(5);
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Eszkimo letrejott.\n");
		f.close();
	}

	/**
	 *Konstruktor
	 * @param s String
	 * @throws IOException
	 */
	public Eszkimo(String s) throws IOException {
		super(5);
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Eszkimo letrejott.\n");
		f.close();
	}

	@Override
	public String getNev() {
		return "Eszkimo";
	}

	/**
	 * Eszkimo kepesseghasznalata fuggveny, hasznalja a kepesseget es csokken a lepesszama
	 * @param i int
	 * @throws IOException
	 */
	public void kepessegHasznalat(int i) throws IOException {
		if (getMezo().getEpulet() == null&& i == -1) {
			getMezo().iglutEpit();
			FileWriter f = new FileWriter("./kimenet.txt", true);
			//f.append("Eszkimo kepesseg hasznalata sikeres.\n");
			f.append("A szereplo hasznalja a kepesseget.\n");
			f.close();
			if (getjListener() != null) {
				getjListener().hoviharSzamlaloCsokkentoListener();
				setLepesszam(getLepesszam() - 1);
			}
		}
	}
}
