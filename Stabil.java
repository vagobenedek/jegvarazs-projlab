import java.io.FileWriter;
import java.io.IOException;

public class Stabil extends Jegmezo {
	/**
	 * Konstukrot
	 * @throws IOException
	 */
	public Stabil() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Stabil letrejott\n");
		f.close();
		setTeherbiras(-1);
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
