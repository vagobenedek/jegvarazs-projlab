import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JegmezoFactory {
	//Konstruktoraban letrehozzuk a Factoryt
	public JegmezoFactory() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("JegmezoFactory letrejott\n");
		f.close();
	}
	//A factory legyartja a megfelelo szamu egyseget
	public ArrayList<Jegmezo> createJegmezo(int i) {
		System.out.println(">JegmezoFectory.createJegmezo()");
		System.out.println("<JegmezoFactory.createJegmezo()");
		return new ArrayList<Jegmezo>();
	}
}
