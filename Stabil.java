import java.io.FileWriter;
import java.io.IOException;

/**
 * Stabil mezo osztaly
 * Jegmezobol szarmazik le
 */
public class Stabil extends Jegmezo {
	@Override
	public String getNev() {
		return "Stabil";
	}

	/**
	 * Konstukrot
	 * @throws IOException
	 */
	public Stabil() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Stabil letrejott\n");
		f.close();
		setTeherbiras((int)Double.POSITIVE_INFINITY);
	}

	/**
	 * a parameterkent kaptt szereplot ralepteti a stabil mezore
	 * @param sz: Szereplo
	 */
	public void ralep(IKarakter sz)throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		sz.setM(this);
		addKarakter(sz);
		f.append("A Szereplo stabil mezon all.\n");
		f.close();
	}
	/*public int getTeherBiras() throws IOException {
		
		//random visszateresi ertek
		return teherbiras;
	}*/
}
