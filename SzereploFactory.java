import java.util.ArrayList;

public class SzereploFactory {
	public SzereploFactory(){}
	public ArrayList<Szereplo> createSzereplo(int n) {
		System.out.println(">SzereploFactory.createSzereplo()");
		Szereplo s = new Eszkimo();
		System.out.println("<SzereploFactory.createSzereplo()");
		return new ArrayList<Szereplo>();
	}
	
	public void addSzereploToMezo(Mezo m) {
	}
}
