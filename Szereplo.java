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
	public Szereplo(String s){
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
	/*Csokkenti a szerplo testhojet
	Csak akkor hivdik meg, ha hoviar aldozata lesz, es nincs igluban*/
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
		System.out.println("Van nalam eszkoz? Ha igen, milyen?");
		System.out.println("1.: Nincs nalam eszkoz.\n2.: Van, kotel.\n3.: Van, lapat.\n4.: Van, elelem.");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		if(str.equals("1")){
			System.out.println(">Szereplo.hasznal()");
			System.out.println("Nincs nalam eszkoz, ezert az eszkozhasznalat nem lehetseges.");
			System.out.println("<Szereplo.hasznal()");
		}
		if(str.equals("2")){
			System.out.println(">Szereplo.hasznal()");
			//Mivel a kotelet onmagaban nem tudja hasznalni, nem tortenik semmi.
			//Kotelet akkor lehet hasznalni, ha egy mezotol huzdKi() keres erkezik.
			System.out.println("Kotel hasznalata nem lehetseges.");
			System.out.println("<Szereplo.hasznal()");
		}
		if(str.equals("3")){
			System.out.println(">Szereplo.hasznal()");
			//Meghivjuk a Lapat hasznal() fuggvenyet.
			new Lapat().hasznal(new Eszkimo());
			System.out.println("<Szereplo.hasznal()");
		}
		if(str.equals("4")){
			System.out.println(">Szereplo.hasznal()");
			//Meghivjuk az Elelem hasznal() fuggvenyet.
			new Elelem().hasznal(new Eszkimo());
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
			System.out.println("Van a szomszedos mezon Szereplo?");
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

	/**
	 * Alkatresz felveteleer felelos fugveny
	 * @param a alkatreszt adja meg
	 * @throws IOException
	 */
	public void alkatreszFelvetele(Alkatresz a) throws IOException {
		//a fuggveny meghivasaval a parameterbe kapott alkatreszt atallitja sajat maganak
		System.out.println(">Szereplo.alkatreszFelvetele(Alkatresz a)");

		//menu
		System.out.println("Van mar nala alkatresz?");
		System.out.println("1.: Van");
		System.out.println("2.: Nincs");

		//a felhasznalo altal beolvasott szam megjelenitese
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		String read = buff.readLine();
		if(read.equals("1")){
			//ha van nala alkatresz akkor a kicserelodik a ketto
			//a szereplonel levo bekerul a mezobe
			//a mezoben levot pedig felveszi a szereplo
			new Pisztoly().addAlkatreszToMezo(new Mezo());
		}

		//ha nincsen nala meg alkatresz akkor csak siman felveszi az uj alkatreszt
		if(read.equals("2")){ }

		System.out.println("<Szereplo.alkatreszFelvetele(Alkatresz a)");
	}

	/**
	 * Az eszkoz felveteleert felelo fuggveny
	 * @param e az eszkozt adja meg
	 * @throws IOException
	 */
	public void eszkozFelvetele(Eszkoz e) throws IOException{
		//a fuggveny meghivasaval a parameterbe kapott eszkozt atallatja sajat maganak
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
		System.out.println("Milyen mezore lepunk?");
		//kiirja a lehetosegeket, hogy milyen mezokre lephetunk
		System.out.println("1.: Stabil mezo\t2.: Instabil mezo\t3.: Tengerre\t4.: Lyuk");
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
	//A parameterkent kapott mezon elhelyezi a szereplot
	public void addSzerploToMezo(Mezo m){
		System.out.println(">Szereplo.addSzereploToMezo()");
		System.out.println("<Szereplo.addSzereploToMezo()");
	}
}
