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
		getMezo().iglutEpit();
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Eszkimo kepesseg hasznalata sikeres\n");
		f.close();
	}
	
	@Override
	public void hitByMedve() {
		// TODO Auto-generated method stub
		
	}
}
