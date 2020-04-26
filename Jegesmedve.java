import java.io.IOException;

public class Jegesmedve implements IKarakter {
	private Mezo mezo;
	private JegvarazsListener jListener;
	@Override
	public void lep(int irany)throws IOException {
		Mezo mezo =this.mezo.getSzomszed(irany);
		this.mezo.lelep(this);
		mezo.ralep(this);
		mezo.szereplokMeetMedve();
		//jListener.SzereplokMeetMedve(this);
		// TODO Auto-generated method stub
		
	}
	public void setjListener(JegvarazsListener jListener){
		this.jListener=jListener;
	}

	@Override
	public Mezo getMezo() throws IOException{
		return mezo;
	}

	@Override
	public void hovihar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elsut() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tesoTeVizbeEstel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void huzdKi(Szereplo sz) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hitByMedve() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Eszkoz getEszkoz() {
		return null;
	}

	@Override
	public Alkatresz getAlkatresz() {
		return null;
	}

	@Override
	public void addKarakterToMezo(Mezo m) {
		this.setM(m);
		m.addKarakter(this);
	}
	public void setM(Mezo m){
		this.mezo = m;
	}

}
