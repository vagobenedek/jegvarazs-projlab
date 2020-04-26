import java.io.FileWriter;
import java.io.IOException;

public class Tenger extends Mezo {
	public Tenger() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Tenger letrejott\n");
		f.close();
	}

	/**
	 * A Tenger mezore lepteteseert felelos fuggveny
	 * @param sz: Szereplo
	 * @throws IOException
	 */
	public void ralep(Szereplo sz) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("A Szereplo tengerbe esett\n");
		f.close();
		//a Tengeren egybol vizbeesik a szereplo
		sz.tesoTeVizbeEstel();
	}
	public int getTeherBiras() throws IOException {
		System.out.println("\t\t>Tenger.getTeherBiras()");
		System.out.println("\t\t<Tenger.getTeherBiras()");
		//random visszateresi értek
		return 1;
	}
}
