import java.util.ArrayList;

public class Vezerlo {
	private Szereplo aktualisSzereplo;
	private ArrayList<Szereplo> szereplok;
	public Vezerlo(){
		System.out.println(">Vez�rl� konstruktor");
		System.out.println("<Vez�rl� konstruktor");
	}
	public void init() {
		System.out.println(">Vez�rl�.init()");
		System.out.println("<Vez�rl�.init()");
	}
	
	public void jatekVege() {
		System.out.println(">Vez�rl�.j�t�kV�ge()");
		System.out.println("<Vez�rl�.j�t�kV�ge()");
	}
	
	public void kovetkezoSzereplo() {
		System.out.println(">Vez�rl�.k�vetkez�Szerepl�()");
		System.out.println("<Vez�rl�.k�vetkez�Szerepl�()");
	}
	
	public void hoviharSzamlala() {
		System.out.println(">Vez�rl�.h�viharSz�ml�l�()");
		System.out.println("<Vez�rl�.h�viharSz�ml�l�()");
	}
	
	public void hoviharSzamlaloCsokkentes() {
		System.out.println(">Vez�rl�.h�viharSz�ml�l�Cs�kkent�s()");
		System.out.println("<Vez�rl�.h�viharSz�ml�l�Cs�kkent�s()");
	}
	
	public void gyozelem() {
		System.out.println(">Vez�rl�.gy�zelem()");
		System.out.println("<Vez�rl�.gy�zelem()");
	}
	
	public void lepesekFeltoltese() {
		System.out.println(">Vez�rl�.l�p�sekFelt�lt�se()");
		System.out.println("<Vez�rl�.l�p�sekFelt�lt�se()");
	}
}
