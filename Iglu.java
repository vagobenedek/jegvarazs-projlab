import java.io.FileWriter;
import java.io.IOException;

public class Iglu implements IEpulet {
	private Mezo m;
	public Iglu(Mezo m) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Iglu letrejott.\n");
		f.close();
		//Az iglu amint letrejon, vedelmet allit be a mezonek
		this.m = m;
		SetVedelem();
	}
	/*public void hovihar() {
	}*/

	@Override
	public void SetVedelem() {
		System.out.println("\t\t\t>Iglu.setVedelem()");
		m.setHovihartolVedett(true);
		m.setMedvetolVedett(true);
		System.out.println("\t\t\t<Iglu.setVedelem()");
	}

}
