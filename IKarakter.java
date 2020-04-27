import java.io.IOException;

public interface IKarakter {
	/**
	 * Lep fuggveny
	 * @param irany int
	 * @throws IOException
	 */
	public void lep(int irany) throws IOException;

	/**
	 * Hovihar fuggveny
	 * @throws IOException
	 */
	public void hovihar() throws IOException;

	/**
	 * Elsut fuggveny
	 */
	public void elsut();

	/**
	 * tesoTeVizbeEstel fuggevny
	 * Szereplo vizbe esik
	 * @throws IOException
	 */
	public void tesoTeVizbeEstel() throws IOException;

	/**
	 * huzdki fuggveny
	 * kihuzza a vizbeesett szereplot
	 * @param sz Szereplo
	 * @throws IOException
	 */
	public void huzdKi(Szereplo sz) throws IOException;

	/**
	 * Medve megtamadja a szereplot
	 */
	public void hitByMedve();

	/**
	 * Eszkoz lekerdezo fuggveny
	 * @return eszkoz
	 */
	public Eszkoz getEszkoz();

	/**
	 * Alkatresz lekerdezo fuggveny
	 * @return alkatresz
	 */
	public Alkatresz getAlkatresz();

	/**
	 * Mezo beallito fuggveny
	 * @param m Mezo
	 */
	void setM(Mezo m);

	/**
	 * Mezo lekerdezo fuggveny
	 * @return
	 * @throws IOException
	 */
	Mezo getMezo() throws IOException;

	/**
	 * Karaktert ad a mezohoz
	 * @param m Mezo
	 */
	public void addKarakterToMezo(Mezo m);
}
