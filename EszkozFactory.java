import java.util.ArrayList;

public class EszkozFactory {
	//Konstruktoraban letrehozzuk a Factoryt
	public EszkozFactory(){
		System.out.println(">EszkozFactory konstruktor");
		System.out.println("<EszkozFactory konstruktor");
	}
	//A factory legyartja a megfelelo szamu egyseget
	public ArrayList<Eszkoz> createEszkoz(int i) {
		System.out.println(">EszkozFactory.createEszkoz()");
		//Letrehozza a megfelelo szamu eszkozt, majd visszaadja azokat egy listaban
		Eszkoz e = new Elelem("init");
		System.out.println("<EszkozFactory.createEszkoz()");
		return new ArrayList<Eszkoz>();
	}
	
	public void addEszkozToMezo(Mezo m) {
	}
}
