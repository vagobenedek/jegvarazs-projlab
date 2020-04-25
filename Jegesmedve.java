
public class Jegesmedve implements IKarakter {
	private Mezo mezo;

	@Override
	public void lep(int irany) {
		// TODO Auto-generated method stub
		
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
