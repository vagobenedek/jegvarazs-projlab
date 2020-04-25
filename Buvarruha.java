import java.io.FileWriter;
import java.io.IOException;

public class Buvarruha extends Eszkoz {
	public Buvarruha() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Buvarruha letrejott\n");
		f.close();
	}
	@Override
	public void hasznal(Szereplo sz) {
	}
}
