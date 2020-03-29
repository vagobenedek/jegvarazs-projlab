import java.io.IOException;

public class Palya {
	/*private Mezo mezok;*/
	public Palya(int szelesseg, int magassag) throws IOException {
		System.out.println(">Palya konstruktor");
		//A JegmezoFactory legyartja, es visszaadja a szamukra szukseges jegmezoket
		new JegmezoFactory().createJegmezo(1);
		//A jegmezok elredezese utan, nehany jegtablara egy hovihar segitsegevel haat teszunk
		hovihar();
		/*Letrehozzuk az egyes szereploket, akatreszeket, eszkozoket a factory-k seitsegevel.
		Majd elhelyezzuk oket a palya megyes mezoin
		 */
		new SzereploFactory().createSzereplo(1);
		new Eszkimo().addSzerploToMezo(new Mezo());
		new AlkatreszFactory().createAlkatresz(3);
		new Pisztoly().addAlkatreszToMezo(new Mezo());
		new Patron().addAlkatreszToMezo(new Mezo());
		new Jelzofeny().addAlkatreszToMezo(new Mezo());
		new EszkozFactory().createEszkoz(1);
		new Elelem().addEszkozToMezo(new Mezo());
		System.out.println("<Palya konstruktor");
	}
	public void hovihar() throws IOException {
		System.out.println(">Palya.hovihar()");
		//Egyes kivalaszott mezokre a hovihar fuggveny segitsegevel havat teszunk
		new Mezo().hovihar();
		System.out.println("<Palya.hovihar()");
	}
}
