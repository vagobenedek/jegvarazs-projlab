import java.io.FileWriter;
import java.io.IOException;

/**
 * Iglu osztaly
 * IEpuletbol szarmazik le
 */
public class Iglu implements IEpulet {
	/**
	 * Mezo parameter
	 */
	private Mezo m;

	/**
	 * Konstruktor
	 * @param m Mezo
	 * @throws IOException
	 */
	public Iglu(Mezo m) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Iglu letrejott.\n");
		f.close();
		//Az iglu amint letrejon, vedelmet allit be a mezonek
		this.m = m;
		m.setEpulet(this);
		SetVedelem();
	}
	/**
	 * Beallitja a mezo vedelmet ugy, hogy
	 * hovihartol és medvetol is vedett legyen
	 */
	@Override
	public void SetVedelem()throws IOException {
		m.setHovihartolVedett(true);
		m.setMedvetolVedett(true);
	}

}
