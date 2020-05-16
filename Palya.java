import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Letrehozza a palyat
 */
public class Palya {

	private List<Mezo> mezoelemek;

	public List<Mezo> getMezoelemek() {
		return mezoelemek;
	}
	/**
	 * Palya letrehozasa
	 * @param szelesseg int
	 * @param magassag int
	 * @param karakterek List
	 * @throws IOException
	 */
	public Palya(int szelesseg, int magassag, List<IKarakter> karakterek) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Palya letrejott\n");
		f.close();
		//A JegmezoFactory legyartja, es visszaadja a szamukra szukseges jegmezoket
		List<Mezo> mezok =  new JegmezoFactory().createJegmezo(szelesseg*magassag);
		mezoelemek = mezok;

		//A jegmezok elredezese utan, nehany jegtablara egy hovihar segitsegevel haat teszunk
		for (int i = 0; i != 4; i++){
			hovihar();
		}
		/*Letrehozzuk az egyes szereploket, akatreszeket, eszkozoket a factory-k seitsegevel.
		Majd elhelyezzuk oket a palya megyes mezoin
		 */
		for (int i = 0; i != karakterek.size(); i++){
			karakterek.get(i).addKarakterToMezo(mezok.get(i));
		}
		List<Alkatresz> alkatreszek =  new AlkatreszFactory().createAlkatresz(3);
		for (int i = 0; i != alkatreszek.size(); i++){
			alkatreszek.get(i).addAlkatreszToMezo(mezok.get(i));
		}
		List<Eszkoz> eszkozok =  new EszkozFactory().createEszkoz(3);
		for (int i = 0; i != eszkozok.size(); i++){
			eszkozok.get(i).addEszkozToMezo(mezok.get(i));
		}


	}

	/**
	 * Hovihar fuggveny
	 * @throws IOException
	 */
	public void hovihar() throws IOException {
		
	}
}
