import java.io.IOException;

public class Sator extends Eszkoz implements IEpulet {
	private Mezo mezo;
	public Sator(Mezo mezo) throws IOException {
		this.mezo=mezo;
		//super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void hasznal(Szereplo sz) throws IOException {
		// TODO Auto-generated method stub
		mezo.satratEpit(this);
		
	}

	@Override
	public void SetVedelem() {
		mezo.setMedvetolVedett(false);
		mezo.setHovihartolVedett(true);
	}

}
