import java.io.IOException;

public class Sator extends Eszkoz implements IEpulet {
	/**
	 * sator mezo attributuma
	 */
	private Mezo mezo;
	public Sator() throws IOException {
		super();
		System.out.println("Sator letrejot");
	}
	/**
	 * sator mezejet allitja be
	 * @param mezo Mezo
	 * @throws IOException
	 */
	public Sator(Mezo mezo) throws IOException {
		super();
		System.out.println("A sator letrejott");
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
	public void SetVedelem() {
		mezo.setMedvetolVedett(false);
		mezo.setHovihartolVedett(true);
	}

}
