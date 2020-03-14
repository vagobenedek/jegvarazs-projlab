

public class Vezérlõ {
	private Szereplõ aktuálisSzereplõ;
	private ArrayList<Szereplõ> szereplõk;
	public Vezérlõ(){
		System.out.println(">Vezérlõ konstruktor");
		System.out.println("<Vezérlõ konstruktor");
	}
	public void init() {
		System.out.println(">Vezérlõ.init()");
		System.out.println("<Vezérlõ.init()");
	}
	
	public void játékVége() {
		System.out.println(">Vezérlõ.játékVége()");
		System.out.println("<Vezérlõ.játékVége()");
	}
	
	public void következõSzereplõ() {
		System.out.println(">Vezérlõ.következõSzereplõ()");
		System.out.println("<Vezérlõ.következõSzereplõ()");
	}
	
	public void hóviharSzámláló() {û
		System.out.println(">Vezérlõ.hóviharSzámláló()");
		System.out.println("<Vezérlõ.hóviharSzámláló()");
	}
	
	public void hóviharSzámlálóCsökkentés() {
		System.out.println(">Vezérlõ.hóviharSzámlálóCsökkentés()");
		System.out.println("<Vezérlõ.hóviharSzámlálóCsökkentés()");
	}
	
	public void gyõzelem() {
		System.out.println(">Vezérlõ.gyõzelem()");
		System.out.println("<Vezérlõ.gyõzelem()");
	}
	
	public void lépésekFeltöltése() {
		System.out.println(">Vezérlõ.lépésekFeltöltése()");
		System.out.println("<Vezérlõ.lépésekFeltöltése()");
	}
}
