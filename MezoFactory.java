import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MezoFactory {
	public MezoFactory() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("MezoFactory letrejott\n");
		f.close();
	}
	public ArrayList<Mezo> createMezo(int i) {
		return new ArrayList<Mezo>();
	}
}
