import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mezo{
	/*private Szereplo[] szereplok;
	private Targy targy;
	private Epulet epulet;
	private boolean feltort;
	private int hoSzint;
	private boolean vedett;*/
	public Mezo(Targy t, Epulet e, int hoSzint, boolean vedett){}
	public Mezo(){}
	public void hovihar() {
	}
	
	public void ralep(Szereplo sz) throws IOException {
		System.out.println(">Mezo.ralep()");
		System.out.println("<Mezo.ralep()");
	}
	
	public void lelep(Szereplo sz) {
		System.out.println(">Mezo.lelep()");
		System.out.println("<Mezo.lelep()");
	}
	
	public Mezo getSzomszed(int irany) {
		System.out.println(">Mezo.getSzomszed()");
		System.out.println("<Mezo.getSzomszed()");
		return null;
	}
	
	public void hoAso() {
		System.out.println("\t>Mezo.hoAso()");
		this.hoCsokkento();
		System.out.println("\t<Mezo.hoAso()");
	}
	
	public void hoCsokkento() {
		System.out.println("\t\t>Mezo.hoCsokkento()");
		System.out.println("\t\t<Mezo.hoCsokkento()");
	}
	
	public void hoNovelo() {
	}
	
	public void feltor() throws IOException {
		System.out.println("\t>Mezo.feltor()");
		System.out.println("\t\tFel van mar torve a mezo?");
		System.out.println("\t\t1.: Igen\t2.: Nincs");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String str = br.readLine();
    	if(str.equals("2")) {
    		System.out.println("\t\tthis.feltort = true;");
    	}
		System.out.println("\t<Mezo.feltor()");
	}
	
	public void epit(Szereplo sz) {
	}
	
	public void targyFelvetele(Szereplo sz) {
	}
	
	public void iglutEpit() {
	}
	
	public void huzzKi(Szereplo sz) throws IOException {
		System.out.println(">Mezo.huzzki()");
		System.out.println("Van a szereplonel kotel?\n1.: Igen\t2.: Nem");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("1"))
			new Sarkkutato().huzdKi(sz);
		System.out.println("<Mezo.huzzki()");
	}
}
