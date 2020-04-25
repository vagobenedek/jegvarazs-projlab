import java.io.FileWriter;
import java.io.IOException;

public class Eszkimo extends Szereplo {
	public Eszkimo() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Eszkimo letrejott\n");
		f.close();
	}
	public Eszkimo(String s) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Eszkimo letrejott\n");
		f.close();
	}
	public void kepessegHasznalat(int i) throws IOException {
		System.out.println(">Eszkimo.kepessegHasznalat()");
		//Mezo letrehozasa, amire az iglut epitjuk es iglutEpit() fuggveny meghivasa
		new Mezo().iglutEpit();
		System.out.println("<Eszkimo.kepessegHasznalat()");
	}
}
