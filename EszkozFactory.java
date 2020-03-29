import java.util.ArrayList;

public class EszkozFactory {
	public EszkozFactory(){
		System.out.println(">EszkozFactory konstruktor");
		System.out.println("<EszkozFactory konstruktor");
	}
	public ArrayList<Eszkoz> createEszkoz(int i) {
		System.out.println(">EszkozFactory.createEszkoz()");
		Eszkoz e = new Elelem();
		System.out.println("<EszkozFactory.createEszkoz()");
		return new ArrayList<Eszkoz>();
	}
	
	public void addEszkozToMezo(Mezo m) {
	}
}
