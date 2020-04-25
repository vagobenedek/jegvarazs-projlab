import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Vezerlo {
	private Szereplo aktualisSzereplo;
	private ArrayList<Szereplo> szereplok;
	public Vezerlo(){
	}
	public Vezerlo(String s) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Vezerlo letrejott\n");
		f.close();
		//Letrehozzuk a palyat, ami konstruktoraban gondoskodik az egyeb elemek letrehozasarol
		new Palya(1,1);
	}

	/**
	 * A Vezerlo alabb lathato fuggvenyei mind listenereken keresztul hivodnak majd meg
	 * bizonyos esemenyke bekovetkeztekor
	 */
	public void jatekVege() {
		System.out.println(">Vezerlo.jatekVege()");
		System.out.println("<Vezerlo.jatekVege()");
	}
	
	public void kovetkezoSzereplo() {
		System.out.println(">Vezerlo.kovetkezoSzereplo()");
		System.out.println("<Vezerlo.kovetkezoSzereplo()");
	}
	
	public void hoviharSzamlala() {
		System.out.println(">Vezerlo.hoviharSzamlalo()");
		System.out.println("<Vezerlo.hoviharSzamlalo()");
	}
	
	public void hoviharSzamlaloCsokkentes() {
		System.out.println(">Vezerlo.hoviharSzamlaloCsokkentes()");
		System.out.println("<Vezerlo.hoviharSzamlaloCsokkentes()");
	}

	/**
	 *Az Vezerlo gyozelem fuggvenye
	 */
	public void gyozelem() {
		System.out.println(">Vezerlo.gyzelem()");
		System.out.println("Gratulalok! Gyoztel!");
		System.out.println("<Vezerlo.gyozelem()");
	}
	
	public void lepesekFeltoltese() {
		System.out.println(">Vezerlo.lepesekFeltoltese()");
		System.out.println("<Vezerlo.lepesekFeltoltese()");
	}
}
