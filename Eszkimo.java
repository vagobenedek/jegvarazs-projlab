

public class Eszkimo extends Szereplo {
	public Eszkimo(){}
	public Eszkimo(String s){
		super(s);
	}
	public void kepessegHasznalat(int i) {
		System.out.println(">Eszkimo.kepessegHasznalat()");
		//Mező létrehozása, amire az iglut építjük és iglutÉpít() függvénym eghívása
		new Mezo().iglutEpit();
		System.out.println("<Eszkimo.kepessegHasznalat()");
	}
}
