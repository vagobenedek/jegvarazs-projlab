import java.io.FileWriter;
import java.io.IOException;

public class Iglu extends Epulet {
	public Iglu(Mezo m) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Iglu letrejott\n");
		f.close();
		//Az iglu amint letrejon, vedelmet allit be a mezonek
		setVedelem();
	}
	public void hovihar() {
	}
	
	public void setVedelem() {
		System.out.println("\t\t\t>Iglu.setVedelem()");
		System.out.println("\t\t\t<Iglu.setVedelem()");
	}
}
