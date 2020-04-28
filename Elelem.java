import java.io.FileWriter;
import java.io.IOException;

/**
 * Elelem osztaly
 * Eszkozbol -> Itargybol szarmazik le
 */
public class Elelem extends Eszkoz implements ITargy {
	/**
	 * Konstruktor
	 * @throws IOException
	 */
	public Elelem() throws IOException {
		super();
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Elelem letrejott.\n");
		f.close();

	}

	public String getNev(){
		return "Elelem";
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
		Sz.setEszkoz(null);
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Elelem hasznalata.\n");
		f.close();
		/*
		System.out.println("\t>Elelem.hasznal()");
			Sz.etkezes();
		System.out.println("\t<Elelem.hasznal()");
		 */
	}
}
