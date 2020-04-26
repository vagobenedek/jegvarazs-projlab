import java.io.FileWriter;
import java.io.IOException;

public class TorekenyLapat extends Lapat {
	/**
	 * TorekenyLapat elettartama
	 */
	private int elettartam;
	
	/**
	 * A torekeny lapat konstruktora.
	 * Beallitja az elettartam attributum erteket 3-ra.
	 * @throws IOException
	 */
	public TorekenyLapat() throws IOException {
		super();
		this.elettartam = 3;
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Torekeny lapat letrejott.\n");
		f.close();
	}
	
	/**
	 * Ha az elettartama nagyobb mint 0, meghivja a parameterben levo szereplo hoAsas() fuggvenyet,
	 * majd csokkenti az elettartamat 1-gyel.
	 * A hoAsas() 1-es parametert kap, ezert 2 egyseg ho lesz ellapatolva.
	 * Amennyiben az elettartam kisebb vagy egyenlo 0, a szereplotol eltunik a torekeny lapat.
	 * @param sz A torekeny lapatot hasznalo szereplo.
	 */
	@Override
	public void hasznal(Szereplo sz) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Torekeny lapat hasznalata.\n");
		f.close();
		
		if (elettartam <= 0) {
			sz.setEszkoz(null);
		} 
		else {
			sz.hoAsas(1);
			elettartam--;
		}
	}
}
