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
	@Override
	public void felvesz(Szereplo Sz) {
		System.out.println("<Eszkoz.felvesz(Szereplo sz)");
		System.out.println(">Eszkoz.felvesz(Szereplo sz)");
	}
	
	abstract public void hasznal(Szereplo sz) throws IOException;
}
