

public class Iglu extends Epulet {
	public Iglu(Mezo m){
		System.out.println("\t\t>Iglu konstruktor");
		//A mezo amint letrejon, vedelmet allit be a mezonek
		setVedelem(m);
		System.out.println("\t\t<Iglu konstruktor");
	}
	public void hovihar() {
	}
	
	public void setVedelem(Mezo m) {
		System.out.println("\t\t\t>Iglu.setVedelem()");
		System.out.println("\t\t\t<Iglu.setVedelem()");
	}
}
