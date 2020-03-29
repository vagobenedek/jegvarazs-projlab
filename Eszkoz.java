import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Eszkoz extends Targy {
	public Eszkoz(){
	}

	@Override
	public void felvesz(Szereplo Sz) {
		System.out.println("<Eszkoz.felvesz(Szereplo sz)");
		System.out.println(">Eszkoz.felvesz(Szereplo sz)");
	}
	
	abstract public void hasznal(Szereplo sz) throws IOException;
}
