import java.io.FileWriter;
import java.io.IOException;

public class Elelem extends Eszkoz {
	public Elelem() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Elelem letrejott\n");
		f.close();
	}
	public Elelem(String s) throws IOException {
		super(s);
	}
	@Override
	public void hasznal(Szereplo Sz) {
		System.out.println("\t>Elelem.hasznal()");
			Sz.etkezes();
		System.out.println("\t<Elelem.hasznal()");
	}
}
