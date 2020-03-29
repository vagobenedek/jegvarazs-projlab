import java.io.IOException;
import java.util.ArrayList;

public class Vezerlo {
	private Szereplo aktualisSzereplo;
	private ArrayList<Szereplo> szereplok;
	public Vezerlo() throws IOException {
		System.out.println(">Vezerlo konstruktor");
                new Palya(1,1);
		System.out.println("<Vezerlo konstruktor");
	}
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
	
	public void gyozelem() {
		System.out.println(">Vezerlo.gyzelem()");
		System.out.println("<Vezerlo.gyozelem()");
	}
	
	public void lepesekFeltoltese() {
		System.out.println(">Vezerlo.lepesekFeltoltese()");
		System.out.println("<Vezerlo.lepesekFeltoltese()");
	}
}
