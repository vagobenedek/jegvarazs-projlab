

public class Iglu extends Epulet {
	public Iglu(Mezo m){
		System.out.println("\t\t>Iglu konstruktor");
		//Az iglu amint letrejon, vedelmet allit be a mezonek
		setVedelem();
		System.out.println("\t\t<Iglu konstruktor");
	}
	public void hovihar() {
	}
	
	public void setVedelem() {
		System.out.println("\t\t\t>Iglu.setVedelem()");
		System.out.println("\t\t\t<Iglu.setVedelem()");
	}
}
