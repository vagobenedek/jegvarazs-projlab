import java.util.ArrayList;

public class Vezerlo {
	/*private Szereplo aktualisSzereplo;
	private ArrayList<Szereplo> szereplok;*/
	public Vezerlo(){
		System.out.println(">Vezerlo konstruktor");
		Palya p = new Palya(1,1);
		System.out.println("<Vezerlo konstruktor");
	}
	public void init() {
		System.out.println(">Vezerlo.init()");
		System.out.println("<Vezerlo.init()");
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
