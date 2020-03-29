

public class Eszkimo extends Szereplo {
	public Eszkimo(){}
	public Eszkimo(String s){
		super(s);
	}
	public void kepessegHasznalat(int i) {
		System.out.println(">Eszkimo.kepessegHasznalat()");
		//Mezo letrehozasa, amire az iglut epitjuk es iglutEpit() fuggveny meghivasa
		new Mezo().iglutEpit();
		System.out.println("<Eszkimo.kepessegHasznalat()");
	}
}
