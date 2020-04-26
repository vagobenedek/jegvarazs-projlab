import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Alkatresz implements ITargy {
	private Mezo m;

	/**
	 * nev parameter, alkatresz nevet adja meg
	 */
	String nev;

	public Mezo getM() {
		return m;
	}

	public void setM(Mezo m) {
		this.m = m;
	}

	public Alkatresz() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Alkatresz letrejott\n");
		f.close();
	}

	public Alkatresz(String s) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Alkatresz letrejott\n");
		f.close();
		nev = s;
	}

	/**
	 * Lekerdezi az alkatresz nevet
	 * @return nev
	 */
	public String getNev() {
		return nev;
	}

	/**
	 * Az alkatresz felvesz fuggvenye
	 *
	 * @param sz szereplot adja meg
	 * @throws IOException
	 */
	@Override
	public void felvesz(Szereplo sz) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Szereplo felveszi az alkatreszt\n");
		f.close();
		sz.alkatreszFelvetele(this);
	}

	/**
	 * Az alkatreszt a mezohoz ado fuggveny
	 * @param m mezot adja meg
	 * @throws IOException
	 */
	public void addAlkatreszToMezo(Mezo m) throws IOException {
		//0425
		m.setTargy(this);
		FileWriter output = new FileWriter("./kimenet.txt", true);
		output.write("Alkatresz hozaadodott a mezohoz.\n");
		output.close();
	}
}
