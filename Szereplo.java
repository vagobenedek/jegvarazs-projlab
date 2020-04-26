import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public abstract class Szereplo implements IKarakter{
	private int testho;
	private Eszkoz e;
	private Alkatresz a;
	private int maxTestho;
	private int lepesszam = 4;
	private Mezo m;
	private JegvarazsListener jListener;
	private boolean epitettSatratElozoKorben;
	public Szereplo() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Jelzofeny letrejott\n");
		f.close();
	}
	public Szereplo(int testho, String s) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Jelzofeny letrejott\n");
		f.close();
		this.testho = testho;
		this.maxTestho = testho;

	}

	public Szereplo(String s) {
	}

	/**
	 * a metodus a Szereplo mezojet adja meg
	 * @return Mezo
	 */
	@Override
	public Mezo getMezo() throws IOException {
		/*
		System.out.println(">Szereplo.getMezo()");
		System.out.println("<Szereplo.getMezo()");
		 */
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Mezo lekerdezese\n");
		f.close();
		return m;
	}
	public void setEpitettSatratElozoKorben(boolean epitettSatratElozoKorben){
		this.epitettSatratElozoKorben=epitettSatratElozoKorben;
	}
	public boolean getEpitettSatratElozoKorben(){
		return epitettSatratElozoKorben;
	}
	public int getMaxTestho(){
		return maxTestho;
	}
	public JegvarazsListener getjListener(){
	    return jListener;
    }
	public void setjListener(JegvarazsListener jListener){
		this.jListener=jListener;
	}
	public void setTestho(int testho) {
		this.testho = testho;
		if(this.testho<=0){
			jListener.jatekVegeListener();
		}
	}

	public void setEszkoz(Eszkoz e) {
		this.e = e;
	}

	public void setAlkatresz(Alkatresz a) {
		this.a = a;
	}

	public void setLepesszam(int lepesszam) {
		this.lepesszam = lepesszam;
		if(this.lepesszam<=0){
			jListener.kovetkezoSzereploListener();
		}
	}

	public void setM(Mezo m) {
		this.m = m;
	}

	public int getTestho() {
		return testho;
	}

	public Eszkoz getEszkoz() {
		return e;
	}

	public Alkatresz getAlkatresz() {
		return a;
	}

	public int getLepesszam() {
		return lepesszam;
	}

	/*Csokkenti a szerplo testhojet
        Csak akkor hivdik meg, ha hoviar aldozata lesz, es nincs igluban*/
	public void hovihar() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Szereplo mezojen hovihar tamadt\n");
		f.close();
		if (0 < getTestho()){
			setTestho(getTestho()-1);
		}
		else {
			getjListener().jatekVegeListener();
		}
	}
	
	public void felvesz() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("A szereplo megprobalja felvenni a targyat\n");
		f.close();
		m.targyFelvetele(this);
	}
	
	// A Szereplo feltori a jegtablat -> meghivodik az adott Mezo feltor() fuggvenye.
	public void feltor() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("A szereplo feltori a jeget.\n");
		f.close();
		if(m.getHoSzint()==0){
			m.feltor();
			getjListener().hoviharSzamlaloCsokkentoListener();
			setLepesszam(getLepesszam()-1);}
		else {
			f.append("A mezo nem tort fel.\n");
		}

	}
	
	public void hasznal() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		if (getEszkoz() != null){
			if(getEszkoz().getNev().equals("Sator")){
				this.setEpitettSatratElozoKorben(true);
			}
			e.hasznal(this);
			if(getEszkoz() == null) {
				f.append("A szereplonel nincs eszkoz.\n");
			}
		}
		else {
			f.append("Nincs eszkoz a szereplonel\n");
		}
		f.close();
        getjListener().hoviharSzamlaloCsokkentoListener();
        setLepesszam(getLepesszam()-1);
		/*
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
		 */
	}

	/**
	 * a vizbeesesert felelos fuggveny
	 * @throws IOException
	 */
	public void tesoTeVizbeEstel() throws IOException {
		System.out.println(">Szereplo.tesoTeVizbeEstel()");
		if (this.getEszkoz()!=null && !this.getEszkoz().getNev().equals("Buvarruha")){
			for (int i = 0; i<4;i++){
				Mezo mezo = this.getMezo().getSzomszed(i);
				mezo.huzzKi(this);
			}
		}
		else
            getjListener().jatekVegeListener();
		/*
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
		}*/

		System.out.println("<Szereplo.tesoTeVizbeEstel()");
	}
	
	// A Szereplo assa a havat -> meghivodik az adott Mezo hoAso() fuggvenye.
	public void hoAsas(int lapat) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Szereplo havat as\n");
		f.close();
		getMezo().hoAso(lapat);
        getjListener().hoviharSzamlaloCsokkentoListener();
        setLepesszam(getLepesszam()-1);
	}
	
	abstract public void kepessegHasznalat(int i) throws IOException ;

	/**
	 * Alkatresz felveteleer felelos fugveny
	 * @param a alkatreszt adja meg
	 * @throws IOException
	 */
	public void alkatreszFelvetele(Alkatresz a) throws IOException {
		//0425
		if(this.a==null)
		{
			this.a = a;
		}
		else
		{
			Alkatresz temp = this.a;
			this.a = a;
			temp.addAlkatreszToMezo(m);
		}

        getjListener().hoviharSzamlaloCsokkentoListener();
        setLepesszam(getLepesszam()-1);
		FileWriter output = new FileWriter("./kimenet.txt", true);
		output.write("Szereplo alkatreszfelvetele sikeres.\n");
		output.write("Felvett targy: " + a.getNev() + ".\n");
		output.close();
	}

	/**
	 * Az eszkoz felveteleert felelo fuggveny
	 * @param e az eszkozt adja meg
	 * @throws IOException
	 */
	public void eszkozFelvetele(Eszkoz e) throws IOException{

		this.e = e;
        getjListener().hoviharSzamlaloCsokkentoListener();
        setLepesszam(getLepesszam()-1);
		FileWriter output = new FileWriter("./kimenet.txt", true);
		output.write("Szereplo targyfelvetele sikeres.\n");
		output.write("Felvett targy: " + e.getNev() + ".\n");
		output.close();
	}

	/**
	 * A szereplo lepesert felelo fuggveny
	 * @param irany az iranyt adja meg
	 * @throws IOException
	 */
	public void lep(int irany) throws IOException {
		FileWriter output = new FileWriter("./kimenet.txt", true);
		output.write("Szereplo lep\n");
		output.close();
		//lekerdezi a mezo szomszedjat a megkapott irany parameternek megfeleloen
		Mezo mezo = getMezo().getSzomszed(irany);
		this.m.lelep(this);
		mezo.ralep(this);
        getjListener().hoviharSzamlaloCsokkentoListener();
        setLepesszam(getLepesszam()-1);
		//new Mezo().getSzomszed(irany);
		/*System.out.println("Milyen mezore lepunk?");
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
		}*/

	}

	/**
	 * Osszerak fuggveny
	 * @throws IOException
	 */
	public void osszerak() throws IOException {
        getMezo().epit(this);
        getjListener().hoviharSzamlaloCsokkentoListener();
        setLepesszam(getLepesszam()-1);
	}
	
	public void etkezes() throws IOException {
		/*
		System.out.println("\t\t>Szereplo.etkezes()");
		System.out.println("\t\t<Szereplo.etkezes()");
		 */
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Etkezes sikeres\n");
		if(getTestho()<getMaxTestho()){
			setTestho(getTestho()+1);
		}
		f.close();
	}

	/**
	 * Mezo epit fuggvenye hivja meg
	 */
	public void elsut() {
		getjListener().gyozelemListener();
	}

	/**
	 * a metodus a parameterkent kapott szereplo kihuzasaert felel
	 * @param sz: Szereplo
	 * @throws IOException
	 */
	public void huzdKi(Szereplo sz) throws IOException {
		System.out.println(">Szereplo.huzdKi()");
		getEszkoz().hasznal(sz);
		this.getMezo().ralep(sz);
		/*//hasznaljuk a kotelet, ami a szereplonek van
		new Kotel().hasznal(new Eszkimo());
		//raleptetjuk arra mezore a parameterkent kapott szereplot, amelyiken ez a Szereplo all
		new Mezo().ralep(new Eszkimo());*/
		System.out.println("<Szereplo.huzdKi()");
	}
	//A parameterkent kapott mezon elhelyezi a szereplot
	public void addSzerploToMezo(Mezo m){
		System.out.println(">Szereplo.addSzereploToMezo()");
		System.out.println("<Szereplo.addSzereploToMezo()");
	}
	public void addKarakterToMezo(Mezo m){
		m.addKarakter(this);
		this.setM(m);
	}
	
	public void hitByMedve() {
        getjListener().jatekVegeListener();
	}
}
