import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Szereplo {
	/*private int testho;
	private Eszkoz e;
	private Alkatresz a;
	private int lepesszam;
	private Mezo m;*/
	
	public Szereplo(){
		System.out.println(">Szereplo konstruktor");
		System.out.println("<Szereplo konstruktor");
	}

	/**
	 * a metodus a Szereplo mezojet adja meg
	 * @return Mezo
	 */
	public Mezo getMezo(){
		System.out.println(">Szereplo.getMezo()");
		System.out.println("<Szereplo.getMezo()");
		return null;
	}
	public void hovihar() {
		System.out.println(">Szereplo.hovihar()");
		System.out.println("Szereplo testhoje csokken");
		System.out.println("<Szereplo.hovihar()");
	}
	
	public void felvesz(){
	}
	
	// A Szereplo feltori a jegtablat -> meghivodik az adott Mezo feltor() fuggvenye.
	public void feltor() throws IOException {
		System.out.println(">Szereplo.feltor()");
		new Mezo().feltor();
		System.out.println("<Szereplo.feltor()");
	}
	
	public void hasznal() throws IOException {
		System.out.println("Van nálam eszkoz? Ha igen, milyen?");
		System.out.println("1.: Nincs nálam eszkoz.\n2.: Van, kotel.\n3.: Van, lapat.\n4.: Van, elelem.");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		if(str.equals("1")){
			System.out.println(">Szereplo.hasznal()");
			System.out.println("Nincs nálam eszköz, ezért az eszközhasználat nem lehetséges.");
			System.out.println("<Szereplo.hasznal()");
		}
		if(str.equals("2")){
			System.out.println(">Szereplo.hasznal()");
			//Mivel a kötelet önmagában nem tudja használni, nem történik semmi.
			//Kötelet akkor lehet használni, ha egy mezőtől huzdKi() kérés érkezik.
			System.out.println("Kotel használata nem lehetséges.");
			System.out.println("<Szereplo.hasznal()");
		}
		if(str.equals("3")){
			System.out.println(">Szereplo.hasznal()");
			//Egy szereplő létrehozása, aki használni fogja a kötelet
			Szereplo sz = new Eszkimo();
			//Meghívjuk a Lapát használ() függvényét.
			new Lapat().hasznal(sz);
			System.out.println("<Szereplo.hasznal()");
		}
		if(str.equals("4")){
			System.out.println(">Szereplo.hasznal()");
			//Egy szereplő létrehozása, aki használni fogja az élelmet
			Szereplo sz = new Eszkimo();
			//Meghívjuk az Élelem használ() függvényét.
			new Elelem().hasznal(sz);
			System.out.println("<Szereplo.hasznal()");
		}
	}

	/**
	 * a vizbeesesert felelos fuggveny
	 * @throws IOException
	 */
	public void tesoTeVizbeEstel() throws IOException {
		System.out.println(">Szereplo.tesoTeVizbeEstel()");
		System.out.println("Van rajtad buvarruha?");
		System.out.println("1.: Van\n2.: Nincs");
		// a beolvasasert felelos objektum
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//ha a felhasznalo kettest irt be
		if(br.readLine().equals("2")){
			//lekerdezi annak a mezonek szomszedjat, amelyiken a szereplo van
			//parameterkent az iranyt adja meg (ebben az esetben most egy tetszoleges szam:0)
			new Mezo().getSzomszed(0);
			System.out.println("Van a szomszedos mezőn Szereplő?");
			System.out.println("1.: Igen\t 2.: Nem");
			//ha a felhasznalo egyest irt be
			if (br.readLine().equals("1")){
				//szolunk a mezonek h huzza ki a parameterkent adott szereplot
				new Mezo().huzzKi(new Eszkimo());
			}
			System.out.println("<Szereplo.tesoTeVizbeEstel()");
		}

		System.out.println("<Szereplo.tesoTeVizbeEstel()");
	}
	
	// A Szereplo assa a havat -> meghivodik az adott Mezo hoAso() fuggvenye.
	public void hoAsas() {
		System.out.println(">Szereplo.hoAsas()");
		new Mezo().hoAso();
		System.out.println("<Szereplo.hoAsas()");
	}
	
	public void kepessegHasznalat(int i) throws IOException {
	}
	
	public void alkatreszFelvetele(Alkatresz a) {
		//a függvény meghívásával a paraméterbe kapott alkatrészt átállítja saját magának
		System.out.println(">Szereplo.alkatreszFelvetele(Alkatresz a)");
		System.out.println("<Szereplo.alkatreszFelvetele(Alkatresz a)");
	}
	
	public void eszkozFelvetele(Eszkoz e) {
		//a függvény meghívásával a paraméterbe kapott eszközt átállítja saját magának
		System.out.println(">Szereplo.eszkozFelvetele(Eszkoz e)");
		System.out.println("<Szereplo.eszkozFelvetele(Eszkoz e)");
	}

	/**
	 * A szereplo lepesert felelo fuggveny
	 * @param irany az iranyt adja meg
	 * @throws IOException
	 */
	public void lep(int irany) throws IOException {
		System.out.println(">Szereplo.lep()");
		//lekerdezi a mezo szomszedjat a megkapott irany parameternek megfeleloen
		new Mezo().getSzomszed(irany);
		System.out.println("Milyen mezőre lépünk?");
		//kiirja a lehetosegeket, hogy milyen mezokre lephetunk
		System.out.println("1.: Stabil mező\t2.: Instabil mező\t3.: Tengerre\t4.: Lyuk");
		// a beolvasasert felelos objektum
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		//ha egyest irt be akkor leleptetjuk a mezorol es raleptetjuk egy stabil mezore
		if(string.equals("1")) {
			new Mezo().lelep(new Eszkimo());
			new Stabil().ralep(new Sarkkutato());
		}
		//ha ketest irt be akkor leleptetjuk a mezorol es raleptetjuk egy instabil mezore
		else if(string.equals("2")) {
			new Mezo().lelep(new Eszkimo());
			new Instabil().ralep(new Sarkkutato());
		}
		//ha harmast irt be akkor leleptetjuk a mezorol es raleptetjuk egy tenger mezore
		else if(string.equals(("3"))) {
			new Mezo().lelep(new Eszkimo());
			new Tenger().ralep(new Sarkkutato());
		}
		//ha negyest irt be akkor leleptetjuk a mezorol es raleptetjuk egy lyuk mezore
		else if(string.equals(("4"))) {
			new Mezo().lelep(new Eszkimo());
			//ez az Instabil osztaly ralep fuggvenyet hivja meg
			new Lyuk().ralep(new Sarkkutato());
		}
		System.out.println("<Szereplo.lep()");

	}
	
	public void osszerak() {
	}
	
	public void etkezes() {
		System.out.println("\t\t>Szereplo.etkezes()");
		System.out.println("\t\t<Szereplo.etkezes()");
	}
	
	public void elsut() {
	}

	/**
	 * a metodus a parameterkent kapott szereplo kihuzasaert felel
	 * @param sz: Szereplo
	 * @throws IOException
	 */
	public void huzdKi(Szereplo sz) throws IOException {
		System.out.println(">Szereplo.huzdKi()");
		//hasznaljuk a kotelet, ami a szereplonek van
		new Kotel().hasznal(new Eszkimo());
		//raleptetjuk arra mezore a parameterkent kapott szereplot, amelyiken ez a Szereplo all
		new Mezo().ralep(new Eszkimo());
		System.out.println("<Szereplo.huzdKi()");
	}
	public void addSzerploToMezo(Mezo m){
		System.out.println(">Szereplo.addSzereploToMezo()");
		System.out.println("<Szereplo.addSzereploToMezo()");
	}
}
