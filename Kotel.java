import java.io.IOException;

public class Kotel extends Eszkoz {
	public Kotel(){}
	public void hasznal(Szereplo sz) {
		System.out.println(">Kotel.hasznal()");
		new Eszkimo().getMezo();
		new Mezo().lelep(new Eszkimo());
		System.out.println("<Kotel.hasznal()");
	}
}
