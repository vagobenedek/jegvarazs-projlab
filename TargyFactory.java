import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TargyFactory {
	public TargyFactory() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("TargyFactory letrejott\n");
		f.close();
	}
	public ArrayList<Targy> createTargy(int i) {

		System.out.println(">TargyFactory.createTargy(int i)");
		System.out.println("<TargyFactory.createTargy(int i)");
		return new ArrayList<Targy>();
	}
}
