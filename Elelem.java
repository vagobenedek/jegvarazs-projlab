import java.io.FileWriter;
import java.io.IOException;

public class Elelem extends Eszkoz {
	/**
	 * Konstruktor
	 * @throws IOException
	 */
	public Elelem() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Elelem letrejott\n");
		f.close();
	}

	/**
	 * Konstruktor
	 * @param s String
	 * @throws IOException
	 */
	public Elelem(String s) throws IOException {
		super(s);
	}

	/**
	 * Ezzel lehet hasznaélni az elelmet
	 * Szereplo elfogyasztja
	 * @param Sz Szereplo
	 * @throws IOException
	 */
	@Override
	public void hasznal(Szereplo Sz) throws IOException {
		Sz.etkezes();
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Elelem hasznalata\n");
		f.close();
		/*
		System.out.println("\t>Elelem.hasznal()");
			Sz.etkezes();
		System.out.println("\t<Elelem.hasznal()");
		 */
	}
}
