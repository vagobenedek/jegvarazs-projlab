import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sarkkutato extends Szereplo {
	/**
	 * Konstuktor
	 * @throws IOException
	 */
	public Sarkkutato() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Sarkkutato letrejott\n");
		f.close();
	}

	/**
	 * Konstuktor
	 * @param s
	 * @throws IOException
	 */
	public Sarkkutato(String s) throws IOException {
		super(s);
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Sarkkutato letrejott\n");
		f.close();
	}

	/**
	 * kepesseg hasznalata fuggveny: csokken a lepesszama
	 * es hasznalja a kepesseget a szereplo
	 * @param i int
	 * @throws IOException
	 */
	@Override
	public void kepessegHasznalat(int i) throws IOException {
		getMezo().getSzomszed(i).getTeherBiras();
		FileWriter f = new FileWriter("./kimenet.txt", true);
		//f.append("Sarkkutato kepesseg hasznalata sikeres\n");
		f.append("A szereplo hasznalja a kepesseget.\n");
		f.close();
		getjListener().hoviharSzamlaloCsokkentoListener();
		setLepesszam(getLepesszam()-1);
	}
}
