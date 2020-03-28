import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sarkkutato extends Szereplo {
	public Sarkkutato(){}
	public void kepessegHasznalat(int i) throws IOException {
		System.out.println(">Sarkkutato.kepessegHasznalat()");
		new Mezo().getSzomszed(i);
		new Mezo().getTeherBiras();
		System.out.println("<Sarkkutato.kepessegHasznalat()");
	}
}
