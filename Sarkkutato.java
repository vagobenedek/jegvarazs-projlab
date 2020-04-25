import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sarkkutato extends Szereplo {
	public Sarkkutato() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Sarkkutato letrejott\n");
		f.close();
	}
	public Sarkkutato(String s) throws IOException {
		super(s);
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Sarkkutato letrejott\n");
		f.close();
	}
	public void kepessegHasznalat(int i) throws IOException {
		System.out.println(">Sarkkutato.kepessegHasznalat()");
		new Mezo().getSzomszed(i);
		new Mezo().getTeherBiras();
		System.out.println("<Sarkkutato.kepessegHasznalat()");
	}
	
	@Override
	public void hitByMedve() {
		// TODO Auto-generated method stub
		
	}
}
