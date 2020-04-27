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
		// TODO Auto-generated method stub
		mezo.satratEpit(this);
		sz.setEszkoz(null);
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
