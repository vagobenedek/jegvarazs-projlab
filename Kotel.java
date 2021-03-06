import java.io.FileWriter;
import java.io.IOException;

/**
 * Kotel osztaly
 * Eszkozbol szamrazik le
 */
public class Kotel extends Eszkoz {
	/**
	 * Konstruktor
	 * @throws IOException
	 */
	public Kotel() throws IOException {
		super();
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Kotel letrejott\n");
		f.close();
	}
	@Override
	public String getNev(){
		return "Kotel";
	}

	/**
	 * a metodus a kotel hasznalataert felel
	 * @param sz Szereplo
	 */
	public void hasznal(Szereplo sz) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Kotel hasznalata\n");
		System.out.println("Kotelet hasznaltam a "+sz.getClass()+"-on");
		sz.getMezo().lelep(sz);
		sz.setKihuzott(true);
		f.append("A szereplot kihuztak.\n");
		f.close();
		/*
		System.out.println(">Kotel.hasznal()");
		//lekeri a szereplo mezojet
		new Eszkimo().getMezo();
		Mezo mezo = sz.getMezo();
		mezo.lelep(sz);
		new Mezo().lelep(new Eszkimo());
		System.out.println("<Kotel.hasznal()");
		 */
	}
}
