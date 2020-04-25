import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Vezerlo {
	private Szereplo aktualisSzereplo;
	private ArrayList<Szereplo> szereplok;
	public Vezerlo() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Vezerlo letrejott\n");
		f.close();
		//Letrehozzuk a palyat, ami konstruktoraban gondoskodik az egyeb elemek letrehozasarol
		new Palya(10,10);
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
	public void gyozelem() throws IOException {
		FileWriter output = new FileWriter("./kimenet.txt", true);
		output.write(".A szereplonek sikerult osszeszerelni az alkatreszeket.\n");
		output.close();
	}
	
	public void lepesekFeltoltese() {
		System.out.println(">Vezerlo.lepesekFeltoltese()");
		System.out.println("<Vezerlo.lepesekFeltoltese()");
	}
}
