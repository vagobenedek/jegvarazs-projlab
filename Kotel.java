import java.io.IOException;

public class Kotel extends Eszkoz {
	public Kotel(){
		super();
	}

	/**
	 * a metodus a kotel hasznalataert felel
	 * @param sz
	 */
	public void hasznal(Szereplo sz) {
		System.out.println(">Kotel.hasznal()");
		//lekeri a szereplo mezojet
		new Eszkimo().getMezo();
		Mezo mezo = sz.getMezo();
		mezo.lelep(sz);
		new Mezo().lelep(new Eszkimo());
		System.out.println("<Kotel.hasznal()");
	}
}
