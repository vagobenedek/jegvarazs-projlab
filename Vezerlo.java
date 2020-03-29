import java.util.ArrayList;

public class Vezerlo {
	private Szereplo aktualisSzereplo;
	private ArrayList<Szereplo> szereplok;
	public Vezerlo(){
		System.out.println(">Vezerlo konstruktor");
                new Palya(1,1);
		System.out.println("<Vezerlo konstruktor");
	}
	public void init() {
		System.out.println(">Vezérlő.init()");
		System.out.println("<Vezérlő.init()");
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
		System.out.println(">Vezerlo.gyzelem()");
		System.out.println("<Vezerlo.gyozelem()");
	}
	
	public void lepesekFeltoltese() {
		System.out.println(">Vez�rl�.l�p�sekFelt�lt�se()");
		System.out.println("<Vez�rl�.l�p�sekFelt�lt�se()");
	}
}
