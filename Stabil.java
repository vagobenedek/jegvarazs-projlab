import java.io.FileWriter;
import java.io.IOException;

public class Stabil extends Jegmezo {
	public Stabil() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Stabil letrejott\n");
		f.close();
	}

	/**
	 * a parameterkent kaptt szereplot ralepteti a stabil mezore
	 * @param sz: Szereplo
	 */
	public void ralep(Szereplo sz) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("A Szereplo Stabil mezore lepett\n");
		f.close();
	}
	public int getTeherBiras() throws IOException {
		System.out.println("\t\t>Stabil.getTeherBiras()");
		System.out.println("\t\t<Stabil.getTeherBiras()");
		//random visszateresi ertek
		return 1;
	}
}
