import java.io.FileWriter;
import java.io.IOException;

/**
 * Sator osztaly
 * Eszkozbol szarmazik le
 */
public class Sator extends Eszkoz implements IEpulet {
	/**
	 * sator mezo attributuma
	 */
	private Mezo mezo;
	public Sator() throws IOException {
		super();
		
	}
	/**
	 * sator mezejet allitja be
	 * @param mezo Mezo
	 * @throws IOException
	 */
	public Sator(Mezo mezo) throws IOException {
		super();
		this.mezo=mezo;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getNev(){
		return "Sator";
	}
	/**
	 * mezo satratepit fuggvenyet meghivja
	 * @param sz Szereplo
	 * @throws IOException
	 */
	@Override
	public void hasznal(Szereplo sz) throws IOException {
		if (mezo.getEpulet()==null)
		{
			mezo.satratEpit(this);
			sz.setEszkoz(null);
		}
	}
	/**
	 * Parameterben kapott mezon elhelyezi a szereplot
	 * @param m Mezo
	 * @throws IOException
	 */
	@Override
	public void addEszkozToMezo(Mezo m) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Eszkoz hozzaadodott a mezohoz.\n");
		f.close();
		m.setTargy(this);
		mezo=m;
	}
	/**
	 * beallitja a mezo vedelmeit
	 * medvetol nem vedett
	 * hovihartol vedett
	 */
	@Override
	public void SetVedelem() throws IOException {
		mezo.setMedvetolVedett(false);
		mezo.setHovihartolVedett(true);
	}

}
