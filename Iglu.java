

public class Iglu extends Epulet {
	public Iglu(Mezo m){
		System.out.println("\t\t>Iglu konstruktor");
		//A mező amint létrejön, védelmet állít be a mezőnek
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
