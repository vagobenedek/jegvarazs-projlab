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
			if (getjListener() != null) {
				jListener.jatekVegeListener();
			}
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
			if (getjListener() != null) {
				jListener.kovetkezoSzereploListener();
			}
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
			f.append("A jateknak vege: vesztettel");
			if (getjListener() != null) {
				getjListener().jatekVegeListener();
			}
		}
	}
	
	public void felvesz() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("A szereplo megprobalja felvenni a targyat\n");
		f.close();
		m.targyFelvetele(this);
	}
	
	/**
	 * Amennyiben a mezon ahol a szereplo tartozkodik a hoszint 0, meghivja a mezo feltor fuggvenyet.
	 * Ezutan csokkenti a hoviharszamlalot, majd a lepesszamot is eggyel.
	 * Ha a hoszint nem egyenlo 0-val, kiirodik, hogy a mezo nem tort fel.
	 */
	public void feltor() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("A szereplo feltori a jeget.\n");
		f.close();
		if(getMezo().getHoSzint()==0) {
			getMezo().feltor();
			if (getjListener() != null) {
				getjListener().hoviharSzamlaloCsokkentoListener();
				setLepesszam(getLepesszam() - 1);
			}
		}
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
		if (getjListener() != null) {
			getjListener().hoviharSzamlaloCsokkentoListener();
			setLepesszam(getLepesszam() - 1);
		}
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
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Szereplo havat as\n");
		if (this.getEszkoz()!=null && !this.getEszkoz().getNev().equals("Buvarruha")){
			for (int i = 0; i<4;i++){
				Mezo mezo = this.getMezo().getSzomszed(i);
				mezo.huzzKi(this);
			}
		}
		else{
			f.append("A jateknak vege: vesztettel.");
			if (getjListener() != null){
				getjListener().jatekVegeListener();
			}
		}
		f.close();
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
	
	/**
	 * A lapat parameter megadja, hogy rendelkezik-e a szereplo lapattal. Ennek megfelelo mennyisegu hoszint fog eltunni.
	 * Ezutan a hovihar szamlalo erteke csokken, majd a szereplo lepesszama is eggyel kevesebb lesz.
	 * @param lapat 0 eseten a szereplo nem rendelkezik lapattal. 1 eseten a szereplo rendelkezik lapattal.
	 * @throws IOException
	 */
	public void hoAsas(int lapat) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Szereplo havat as\n");
		f.close();
		getMezo().hoAso(lapat);
		if (getjListener() != null) {
			getjListener().hoviharSzamlaloCsokkentoListener();
			setLepesszam(getLepesszam() - 1);
		}
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
		if (getjListener() != null) {
			getjListener().hoviharSzamlaloCsokkentoListener();
			setLepesszam(getLepesszam() - 1);
		}
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
		if (getjListener() != null) {
			getjListener().hoviharSzamlaloCsokkentoListener();
			setLepesszam(getLepesszam() - 1);
		}
	}

	/**
	 * Osszerak fuggveny
	 * @throws IOException
	 */
	public void osszerak() throws IOException {
        getMezo().epit(this);
		if (getjListener() != null) {
			getjListener().hoviharSzamlaloCsokkentoListener();
			setLepesszam(getLepesszam() - 1);
		}
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
		if (getjListener() != null) {
			getjListener().gyozelemListener();
		}
	}

	/**
	 * a metodus a parameterkent kapott szereplo kihuzasaert felel
	 * @param sz: Szereplo
	 * @throws IOException
	 */
	public void huzdKi(Szereplo sz) throws IOException {
		getEszkoz().hasznal(sz);
		this.getMezo().ralep(sz);
	}
	public void addKarakterToMezo(Mezo m){
		m.addKarakter(this);
		this.setM(m);
	}
	
	public void hitByMedve() {
		if (getjListener() != null) {
			getjListener().jatekVegeListener();
		}
	}
}
