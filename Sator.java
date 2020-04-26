import java.io.IOException;

public class Sator extends Eszkoz implements IEpulet {
	/**
	 * sator mezo attributuma
	 */
	private Mezo mezo;

	/**
	 * sator mezejet allitja be
	 * @param mezo Mezo
	 * @throws IOException
	 */
	public Sator(Mezo mezo) throws IOException {
		this.mezo=mezo;
		//super();
		// TODO Auto-generated constructor stub
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
		
	}

	/**
	 * beallitja a mezo vedelmeit
	 * medvetol nem vedett
	 * hovihartol vedett
	 */
	@Override
	public void SetVedelem() {
		mezo.setMedvetolVedett(false);
		mezo.setHovihartolVedett(true);
	}

}
