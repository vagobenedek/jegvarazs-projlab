import java.io.IOException;

public interface IKarakter {
	public void lep(int irany) throws IOException;
	public void hovihar();
	public void elsut();
	public void tesoTeVizbeEstel() throws IOException;
	public void huzdKi(Szereplo sz) throws IOException;
	public void hitByMedve();
	public Eszkoz getEszkoz();
	public Alkatresz getAlkatresz();
	public void addKarakterToMezo(Mezo m);
}
