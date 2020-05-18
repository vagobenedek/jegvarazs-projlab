import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * Letrehozza a palyat
 */
public class Palya {

	private List<Mezo> mezoelemek;
	private int meret;
	private int lastKarakter = -1;
	private int lastTargy = -1;

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

		meret = szelesseg;
		List<Mezo> mezok =  new MezoFactory().createMezo(szelesseg*magassag, karakterek.size());
		mezoelemek = mezok;

		//A jegmezok elredezese utan, nehany jegtablara egy hovihar segitsegevel haat teszunk
		for (int i = 0; i != 4; i++){
			//hovihar();
		}
		/*Letrehozzuk az egyes szereploket, akatreszeket, eszkozoket a factory-k seitsegevel.
		Majd elhelyezzuk oket a palya megyes mezoin
		 */
		for (int i = 0; i != karakterek.size(); i++){
			int nextKarakter = (new Random().nextInt(meret-2)+1)*meret + new Random().nextInt(meret-2)+1;
			Mezo m = mezoelemek.get(nextKarakter);
			while (m.getNev().equals("Tenger") || m.getNev().equals("Lyuk") || nextKarakter == lastKarakter ) {
				nextKarakter = (new Random().nextInt(meret-2)+1)*meret + new Random().nextInt(meret-2)+1;
				m = mezoelemek.get(nextKarakter);
			}
			System.out.println(lastKarakter +" - "+ nextKarakter);
			karakterek.get(i).addKarakterToMezo(m);
			lastKarakter = nextKarakter;
		}
		List<Alkatresz> alkatreszek =  new AlkatreszFactory().createAlkatresz(3);
		int nextTargy;
		for (int i = 0; i != alkatreszek.size(); i++){
			nextTargy = (new Random().nextInt(meret-2)+1)*meret + new Random().nextInt(meret-2)+1;
			Mezo m = mezoelemek.get(nextTargy);
			while (m.getNev().equals("Tenger") || m.getNev().equals("Lyuk") || nextTargy == lastTargy) {
				nextTargy = (new Random().nextInt(meret-2)+1)*meret + new Random().nextInt(meret-2)+1;
				m = mezoelemek.get(nextTargy);
			}
			alkatreszek.get(i).addAlkatreszToMezo(m);
			lastTargy = nextTargy;
		}
		List<Eszkoz> eszkozok =  new EszkozFactory().createEszkoz(3);
		for (int i = 0; i != eszkozok.size(); i++){
			nextTargy = (new Random().nextInt(meret-2)+1)*meret + new Random().nextInt(meret-2)+1;
			Mezo m = mezoelemek.get(nextTargy);
			while (m.getNev().equals("Tenger") || m.getNev().equals("Lyuk") || nextTargy == lastTargy) {
				nextTargy = (new Random().nextInt(meret-2)+1)*meret + new Random().nextInt(meret-2)+1;
				m = mezoelemek.get(nextTargy);
			}
			eszkozok.get(i).addEszkozToMezo(m);
			lastTargy = nextTargy;
		}
	}

	/**
	 * Hovihar fuggveny
	 * @throws IOException
	 */
	public void hovihar() throws IOException {
		int random = new Random().nextInt(16);
		for(int i = 0; i<random;i++) {
			mezoelemek.get((new Random().nextInt(meret - 2) + 1) * meret + new Random().nextInt(meret - 2) + 1).hovihar();
		}
	}
}
