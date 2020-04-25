import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Eszkoz implements ITargy {

	String nev;

	public Eszkoz() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Eszkoz letrejott\n");
		f.close();
	}
	public Eszkoz(String s) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Eszkoz letrejott\n");
		f.close();

		nev = s;
	}

	public String getNev() {
		return nev;
	}

	//A parameterkent kapott mezon elhelyezi a szereplot
	public void addEszkozToMezo(Mezo m){
		System.out.println(">Eszkoz.addEszkozToMezo()");
		System.out.println("<Eszkoz.addEszkozToMezo()");
	}

	/**
	 * Eszkoz felvesz fuggvenye
	 * @param Sz szereplot adja meg
	 */
	@Override
	public void felvesz(Szereplo Sz) throws IOException {
		//0425
		Sz.eszkozFelvetele(this);
	}
	
	abstract public void hasznal(Szereplo sz) throws IOException;

}
