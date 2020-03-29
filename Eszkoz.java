import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Eszkoz extends Targy {
	public Eszkoz(){
		System.out.println(">Eszkoz konstruktor");
		System.out.println("<Eszkoz konstruktor");
	}
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
