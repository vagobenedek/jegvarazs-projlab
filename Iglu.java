import java.io.FileWriter;
import java.io.IOException;

public class Iglu implements IEpulet {
	private Mezo m;
	public Iglu(Mezo m) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Iglu letrejott\n");
		f.close();
		//Az iglu amint letrejon, vedelmet allit be a mezonek
		this.m = m;
		setVedelem();
	}
	public void hovihar() {
	}
	
	public void setVedelem() {
		System.out.println("\t\t\t>Iglu.setVedelem()");
		System.out.println("\t\t\t<Iglu.setVedelem()");
	}
	
	@Override
	public void felvesz(Szereplo sz) throws IOException {
		// TODO Auto-generated method stub
		
	}
}
