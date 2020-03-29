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
	public Mezo(String s){
		System.out.println(">Mezo konstruktor");
		System.out.println("<Mezo konstruktor");
	}

	public void hovihar() throws IOException {
		System.out.println(">Mezo.hovihar()");
		//Noveli a mezon levo hoegysegek szamat
		hoNovelo();
		/*Amennyiben van iglu a mezon, nem foglalkoznk azzal, hogy van-e szereplo a mezon
		Amennyiben nincs iglu, megkerdezzuk hogy szereplo van-e
		A kapott valasznak megfeleloen cselekszunk*/
		System.out.println("Van iglu a mezon?");
		System.out.println("1.: Nincs\n2.: Van");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		if(str.equals("1")) {
			System.out.println("Van szereplo a mezon?");
			System.out.println("1.: Nincs\n2.: Van");
			str = br.readLine();
			if (str.equals("2")){
				//Ha vedetlen szereplo talalhato a mezon, lemegy egy testhoje
				new Sarkkutato().hovihar();
			}
		}
		System.out.println("<Mezo.hovihar()");
	}

	/**
	 * ez a fuggveny felel a mezo raleptetesere
	 * a parameterkent kapott szereplot lepteti ra
	 * @param sz: Szereplo
	 * @throws IOException
	 */
	public void ralep(Szereplo sz) throws IOException {
		System.out.println(">Mezo.ralep()");
		System.out.println("<Mezo.ralep()");
	}

	public int getTeherBiras() throws IOException {
		System.out.println("\t>Mezo.getTeherBiras()");
		System.out.println("Milyen típusú mezőn állok?");
		System.out.println("1.: Stabil\n2.: Instabil\n3.: Tenger");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		if(str.equals("1")) {
			new Stabil().getTeherBiras();
		}
		if(str.equals("2")) {
			new Instabil().getTeherBiras();
		}
		if(str.equals("3")) {
			new Tenger().getTeherBiras();
		}
		System.out.println("\t<Mezo.getTeherBiras()");
		//random visszatérési érték
		return 1;
	}

	/**
	 * ez a fuggveny lepteti le a parameterkent kapott szereplot, a mezorol
	 * @param sz : Szereplo
	 */
	public void lelep(Szereplo sz) {
		System.out.println(">Mezo.lelep()");
		System.out.println("<Mezo.lelep()");
	}

	/**
	 * a mezo szomszedjat adja vissza a kapott parameternek megfeleloen
	 * @param irany: int
	 * @return Mezo
	 */
	public Mezo getSzomszed(int irany) {
		System.out.println(">Mezo.getSzomszed()");
		System.out.println("<Mezo.getSzomszed()");
		//ebben az esetben nem kell semmit visszaadni
		return null;
	}
	
	// Ha nincs lapat -> 1  db hoCsokkento() hivodik.
	// Ha van lapat -> 2 db hoCsokkento() hivodik.
	public void hoAso() {
		System.out.println("\t>Mezo.hoAso()");
		this.hoCsokkento();
		System.out.println("\t<Mezo.hoAso()");
	}
	
	// Csokkenti a hoszintet eggyel.
	public void hoCsokkento() {
		System.out.println("\t\t>Mezo.hoCsokkento()");
		System.out.println("\t\t<Mezo.hoCsokkento()");
	}
	
	public void hoNovelo() {
		System.out.println(">Mezo.hoNovelo()");
		System.out.println("<Mezo.hoNovelo()");
	}
	
	// Ha fel van torve a jegtabla -> nem csinal semmit.
	// Ha nincs feltorve -> feltori.
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
		System.out.println("\t>Mezo.iglutEpit()");
		//Mező, amin áll az eszkimó. Erre fog kerülni az iglu.
		Mezo m = new Mezo();
		//Ezt a mezőt most konstruktorban adjuk át
		new Iglu(m);
		System.out.println("\t<Mezo.iglutEpit()");
	}

	/**
	 * a Szereplo kihuzasaert felel, akit parametrben kapunk
	 * @param sz : Szereplo
	 * @throws IOException
	 */
	public void huzzKi(Szereplo sz) throws IOException {
		System.out.println(">Mezo.huzzki()");
		System.out.println("Van a szereplonel kotel?\n1.: Igen\t2.: Nem");
		// a beolvasert felelos objektum
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ha van a szereplon kotel, vagyis egyest irt be
		if (br.readLine().equals("1")) {
			//szolunk a mezon allo szereplonek, hogy huzza ki a parameterkent kapott szereplot
			//majd ezt a parametert adjuk tovabb
			new Sarkkutato().huzdKi(new Eszkimo());
		}
		System.out.println("<Mezo.huzzki()");
	}
}
