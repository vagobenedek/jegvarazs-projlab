import java.io.FileWriter;
import java.io.IOException;

public class Jegesmedve implements IKarakter {
	/**
	 * Mezo attributum
	 */
	private Mezo mezo;
	/**
	 * Listener attributum
	 */
	private JegvarazsListener jListener;

	/**
	 * Jegesmedve lep fuggvenye
	 * @param irany int
	 * @throws IOException
	 */
	@Override
	public void lep(int irany)throws IOException {
		Mezo mezo =this.mezo.getSzomszed(irany);
		this.mezo.lelep(this);
		mezo.ralep(this);
		mezo.szereplokMeetMedve();

		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("A jegesmedve lepett.\n");
		f.close();
		//jListener.SzereplokMeetMedve(this);
		// TODO Auto-generated method stub
		
	}

	/**
	 * Listener fuggveny
	 * @param jListener
	 */
	public void setjListener(JegvarazsListener jListener){
		this.jListener=jListener;
	}

	/**
	 * Lekerdezi a mezot
	 * @return mezo
	 * @throws IOException
	 */
	@Override
	public Mezo getMezo() throws IOException{
		return mezo;
	}

	/**
	 * Hovihar fuggveny (ha lecsap ra nem tortenik semmi)
	 */
	@Override
	public void hovihar() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Elsut fuggveny
	 */
	@Override
	public void elsut() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Vizbeeses fuggvenye
	 */
	@Override
	public void tesoTeVizbeEstel() throws IOException{
		// TODO Auto-generated method stub
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("A jegesmedve beleesett a vizbe.\n");
		f.close();
	}

	/**
	 * Huzdki fuggveny
	 * @param sz Szereplo
	 */
	@Override
	public void huzdKi(Szereplo sz) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Medvevel valo talalkozas fuggvenye (sajat magaval nem talalkozhat)
	 */
	@Override
	public void hitByMedve() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Lekerdezi az eszkozt
	 * @return null
	 */
	@Override
	public Eszkoz getEszkoz() {
		return null;
	}

	/**
	 * Lekerdezi az alkatreszt
	 * @return null
	 */
	@Override
	public Alkatresz getAlkatresz() {
		return null;
	}

	/**
	 * Karaktert ad a mezohoz
	 * @param m Mezo
	 */
	@Override
	public void addKarakterToMezo(Mezo m) {
		this.setM(m);
		m.addKarakter(this);
	}

	/**
	 * beallitja a mezot
	 * @param m Mezo
	 */
	public void setM(Mezo m){
		this.mezo = m;
	}

}
