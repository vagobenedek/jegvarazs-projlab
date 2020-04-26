import java.io.IOException;

public interface IKarakter {
	public void lep(int irany) throws IOException;
	public void hovihar() throws IOException;
	public void elsut();
	public void tesoTeVizbeEstel() throws IOException;
	public void huzdKi(Szereplo sz) throws IOException;
	public void hitByMedve();
	public Eszkoz getEszkoz();
	public Alkatresz getAlkatresz();
	void setM(Mezo m);
	Mezo getMezo() throws IOException;
	public void addKarakterToMezo(Mezo m);
}
