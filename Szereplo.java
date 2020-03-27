import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Szereplo {
	/*private int testho;
	private Eszkoz e;
	private Alkatresz a;
	private int lepesszam;
	private Mezo m;*/
	public Szereplo(){}
	public Mezo getMezo(){
		System.out.println(">Szereplo.getMezo()");
		System.out.println("<Szereplo.getMezo()");
		return null;
	}
	public void hovihar() {
	}
	
	public void felvesz() {
	}
	
	public void feltor() throws IOException {
		System.out.println(">Szereplo.feltor()");
		new Mezo().feltor();
		System.out.println("<Szereplo.feltor()");
	}
	
	public void hasznal() {
	}
	
	public void tesoTeVizbeEstel() throws IOException {
		System.out.println(">Szereplo.tesoTeVizbeEstel()");
		System.out.println("Van rajtad buvarruha?");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		if(string.equals("2")){
			new Mezo().getSzomszed(0);
			System.out.println("Van a szomszedos mezőn Szereplő?");
			System.out.println("1.: Igen\t 2.: Nem");
			string = br.readLine();
			if (string.equals("1")){
				new Mezo().huzzKi(new Eszkimo());
			}
			System.out.println("<Szereplo.tesoTeVizbeEstel()");
		}

		System.out.println("<Szereplo.tesoTeVizbeEstel()");
	}
	
	public void hoAsas() {
		System.out.println(">Szereplo.hoAsas()");
		new Mezo().hoAso();
		System.out.println("<Szereplo.hoAsas()");
	}
	
	public void kepessegHasznalat(int i) {
	}
	
	public void alkatreszFelvetele(Alkatresz a) {
	}
	
	public void eszkozFelvetele(Eszkoz e) {
	}
	
	public void lep(int irany) throws IOException {
		System.out.println(">Szereplo.lep()");
		new Mezo().getSzomszed(irany);
		System.out.println("Milyen mezőre lépünk?");
		System.out.println("1.: Stabil mező\t2.: Instabil mező\t3.: Tengerre\t4.: Lyuk");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		if(string.equals("1")) {
			new Mezo().lelep(new Eszkimo());
			new Stabil().ralep(new Sarkkutato());
		}
		else if(string.equals("2")) {
			new Mezo().lelep(new Eszkimo());
			new Instabil().ralep(new Sarkkutato());
		}
		else if(string.equals(("3"))) {
			new Mezo().lelep(new Eszkimo());
			new Tenger().ralep(new Sarkkutato());
		}
		else if(string.equals(("4"))) {
			new Mezo().lelep(new Eszkimo());
			new Lyuk().ralep(new Sarkkutato());
		}
		System.out.println("<Szereplo.lep()");

	}
	
	public void osszerak() {
	}
	
	public void etkezes() {
	}
	
	public void elsut() {
	}
	
	public void huzdKi(Szereplo sz) throws IOException {
		System.out.println(">Szereplo.huzdKi()");
		new Kotel().hasznal(new Eszkimo());
		new Mezo().ralep(new Eszkimo());
		System.out.println("<Szereplo.huzdKi()");
	}
}
