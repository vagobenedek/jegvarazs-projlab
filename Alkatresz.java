import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Alkatresz implements ITargy {

	String nev;

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

		sz.alkatreszFelvetele(this);
	}

	/**
	 * Az alkatreszt a mezohoz ado fuggveny
	 *
	 * @param m mezot adja meg
	 */
	public void addAlkatreszToMezo(Mezo m) throws IOException {
		//0425
		m.setTargy(this);
		FileWriter output = new FileWriter("./kimenet.txt", true);
		output.write("Korabbi alkatresz mezobe kerult vissza.\n");
		output.close();
	}
}
