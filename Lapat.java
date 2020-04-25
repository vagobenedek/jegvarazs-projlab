import java.io.FileWriter;
import java.io.IOException;

public class Lapat extends Eszkoz {
	public Lapat() throws IOException {
		super();
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Lapat letrejott\n");
		f.close();
	}
	
	@Override
	public void hasznal(Szereplo Sz) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Lapat hasznalata\n");
		f.close();
		
		Sz.hoAsas(1);
	}
}
