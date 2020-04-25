import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Eszkoz extends Targy {
	public Eszkoz() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Eszkoz letrejott\n");
		f.close();
	}
	public Eszkoz(String s) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Eszkoz letrejott\n");
		f.close();
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
	public void felvesz(Szereplo Sz) {
		System.out.println("<Eszkoz.felvesz(Szereplo sz)");

		// ha van nala eszkoz a regi eldobasra kerul es az uj kerul a helyere
		//ezert itt nincsen kerdes
		//ha van nala ha nincsen, akkor is fel tudja venni

		System.out.println(">Eszkoz.felvesz(Szereplo sz)");
	}
	
	abstract public void hasznal(Szereplo sz) throws IOException;
}
