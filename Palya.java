import java.io.IOException;

public class Palya {
	/*private Mezo mezok;*/
	public Palya(int szelesseg, int magassag) throws IOException {
		System.out.println(">Palya konstruktor");
		JegmezoFactory jf = new JegmezoFactory();
		jf.createJegmezo(1);
		hovihar();
		SzereploFactory sf = new SzereploFactory();
		sf.createSzereplo(1);
		Szereplo s = new Eszkimo();
		s.addSzerploToMezo(new Mezo());
		AlkatreszFactory af = new AlkatreszFactory();
		af.createAlkatresz(3);
		new Pisztoly().addAlkatreszToMezo(new Mezo());
		new Patron().addAlkatreszToMezo(new Mezo());
		new Jelzofeny().addAlkatreszToMezo(new Mezo());
		EszkozFactory ef = new EszkozFactory();
		ef.createEszkoz(1);
		new Elelem().addEszkozToMezo(new Mezo());
		System.out.println("<Palya konstruktor");
	}
	public void hovihar() throws IOException {
		System.out.println(">Palya.hovihar()");
		Mezo m = new Mezo();
		m.hovihar();
		System.out.println("<Palya.hovihar()");
	}
}
