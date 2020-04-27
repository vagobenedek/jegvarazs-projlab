import java.io.FileWriter;
import java.io.IOException;

/**
 * Tenger osztaly
 * Mezobol szarmazik le
 */
public class Tenger extends Mezo {
	/**
	 * Konstruktor
	 * @throws IOException
	 */
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
	public void ralep(IKarakter sz) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("A Szereplo tengerbe esett.\n");
		f.close();
		sz.setM(this);
		this.addKarakter(sz);
		//a Tengeren egybol vizbeesik a szereplo
		sz.tesoTeVizbeEstel();
	}

	/**
	 * Teherbirasat kerdezi le
	 * @return
	 * @throws IOException
	 */
	public int getTeherBiras() throws IOException {
		//random visszateresi értek
		return 1;
	}
}
