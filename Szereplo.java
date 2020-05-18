import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Szereplo osztaly
 * IKarakter intefeszbol szarmazik le
 */
public abstract class Szereplo implements IKarakter{
	/**
	 * szereplo testhoje
	 */
	private int testho;
	/**
	 * szereplonel levo eszkoz
	 */
	private Eszkoz e;
	/**
	 * szereplonel levo alkatresz
	 */
	private Alkatresz a;
	/**
	 * testho attributum
	 */
	private int maxTestho;
	/**
	 * lepesszam attributum
	 */
	private int lepesszam = 4;
	/**
	 * Mezo attributum
	 */
	private Mezo m;
	/**
	 *listener attributum
	 */
	private JegvarazsListener jListener;
	private boolean kihuzott = false;

	/**
	 * epitett satrat az elozo korben bool tipusu parameter
	 */
	private boolean epitettSatratElozoKorben;

	/**
	 * Szereplo konstruktor
	 * @throws IOException
	 */
	public Szereplo(int testho) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Jelzofeny letrejott\n");
		f.close();
		this.lepesszam=4;
		this.testho = testho;
		this.maxTestho = testho;
	}

	/**
	 * Szereplo konstruktor
	 * beallitja a testhot
	 * @param testho int
	 * @param s String
	 * @throws IOException
	 */
	public Szereplo(int testho, String s) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Jelzofeny letrejott\n");
		f.close();
		this.testho = testho;
		this.maxTestho = testho;
	}

	/**
	 * szereplo konstruktor
	 * @param s String
	 */
	public Szereplo(String s) {
	}

	/**
	 * a metodus a Szereplo mezojet adja meg
	 * @return Mezo
	 */
	@Override
	public Mezo getMezo() throws IOException {
		
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Mezo lekerdezese\n");
		f.close();
		return m;
	}

	/**
	 * beallitja az epitettsatratElozoKorben parametert
	 * @param epitettSatratElozoKorben boolean
	 */
	public void setEpitettSatratElozoKorben(boolean epitettSatratElozoKorben){
		this.epitettSatratElozoKorben=epitettSatratElozoKorben;
	}

	/**
	 * visszaadja hogy epitett e elozo korben satrat
	 * @return epitettsatratElozoKorben
	 */
	public boolean getEpitettSatratElozoKorben(){
		return epitettSatratElozoKorben;
	}

	/**
	 * visszaadja a testhot
	 * @return maxTestho
	 */
	public int getMaxTestho(){
		return maxTestho;
	}

	/**
	 * visszaadja a listenert
	 * @return jListener
	 */
	public JegvarazsListener getjListener(){
	    return jListener;
    }
	public boolean IsKihuzott(){
		return kihuzott;
	}
	public void setKihuzott(boolean kihuzott){
		this.kihuzott=kihuzott;
	}
	/**
	 * beallitja a listenert
	 * @param jListener Listener
	 */
	public void setjListener(JegvarazsListener jListener){
		this.jListener=jListener;
	}

	/**
	 * beallitja a tetshot
	 * @param testho int
	 */
	public void setTestho(int testho) throws IOException{
		this.testho = testho;
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("A szereplo testhoje "+this.testho+".\n");
		if(this.testho<=0){
			f.append("A jateknak vege: vesztettel.\n");
			f.close();
			if (getjListener() != null) {
				jListener.jatekVegeListener();
			}
		}
		f.close();
	}

	/**
	 * beallitja az eszkozt
	 * @param e Eszkoz
	 */
	public void setEszkoz(Eszkoz e) {
		this.e = e;
	}

	/**
	 * beallitja az alkatreszt
	 * @param a Alkatresz
	 */
	public void setAlkatresz(Alkatresz a) {
		this.a = a;
	}

	/**
	 * beallitja a szereplo lepesszamat
	 * @param lepesszam int
	 */
	public void setLepesszam(int lepesszam) {
		this.lepesszam = lepesszam;
		System.out.println(lepesszam);
		if(this.lepesszam<=0){
			System.out.println("Valtas");
			if (getjListener() != null) {
				jListener.kovetkezoSzereploListener();
			}
		}
	}

	/**
	 * beallitja a mezot
	 * @param m Mezo
	 */
	public void setM(Mezo m) {
		this.m = m;
	}

	/**
	 * visszaadja a szereplo testhojet
	 * @return testho
	 */
	public int getTestho() {
		return testho;
	}

	/**
	 * visszaadja az eszkozt
	 * @return eszkoz
	 */
	public Eszkoz getEszkoz() {
		return e;
	}

	/**
	 * visszaadja az alkatreszt
	 * @return alkatresz
	 */
	public Alkatresz getAlkatresz() {
		return a;
	}
		public void setMaxTestho(int maxTestho){
		this.maxTestho=maxTestho;
		}
	/**
	 * visszaadja a lepesszamot
	 * @return lepesszam
	 */
	public int getLepesszam() {
		return lepesszam;
	}

	/**
	 * Csokkenti a szerplo testhojet
	 * Csak akkor hivdik meg, ha hoviar aldozata lesz, es nincs igluban
	 * @throws IOException
	 */
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

	/**
	 *mezo targyfelvetele fuggvenyet hivja meg
	 * @throws IOException
	 */
	public void felvesz() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("A szereplo megprobalja felvenni a targyat\n");
		f.close();
		getMezo().targyFelvetele(this);
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
			if (this.getjListener() != null) {
				getjListener().hoviharSzamlaloCsokkentoListener();
				setLepesszam(getLepesszam() - 1);
			}
		}
		else {
			f = new FileWriter("./kimenet.txt", true);
			f.append("A mezo nem tort fel.\n");
			f.close();
		}

	}

	/**
	 * hasznal fuggveny
	 * @throws IOException
	 */
	public void hasznal() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		if (getEszkoz() != null){
			f.append("A szereplonel van eszkoz.\n");
			if(getEszkoz().getNev().equals("Sator")){
				this.setEpitettSatratElozoKorben(true);
			}
			e.hasznal(this);
			if(getEszkoz() == null) {
				f.append("A szereplonel nincs eszkoz.\n");
			}
		}
		else {
			f.append("A szereplonel nincs eszkoz.\n");
		}
		f.close();
		if (getjListener() != null) {
			getjListener().hoviharSzamlaloCsokkentoListener();
			setLepesszam(getLepesszam() - 1);
		}
		getMezo().getTargy();
	}

	/**
	 * a vizbeesesert felelos fuggveny
	 * @throws IOException
	 */
	public void tesoTeVizbeEstel() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("A szereplo vizbe esett.\n");
		f.close();

		if (this.getEszkoz() == null || (this.getEszkoz()!=null && !this.getEszkoz().getNev().equals("Buvarruha"))){
			for (int i = 0; i<4;i++){
				
				if (this.getMezo().getSzomszed(i)!=null) {
					Mezo mezo = this.getMezo().getSzomszed(i);
					mezo.huzzKi(this);
					if(IsKihuzott()){
						setKihuzott(false);
						
						break;
					}
				}
			}
		}
		else if (this.getEszkoz()!=null && this.getEszkoz().getNev().equals("Buvarruha")){
			f = new FileWriter("./kimenet.txt", true);
			f.append("A szereplon van buvarruha.");
			f.close();
		}


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

	/**
	 * abstract kepesseghasznalat fuggveny
	 * eszkimo es sarkkutato valositja meg
	 * @param i int
	 * @throws IOException
	 */
	abstract public void kepessegHasznalat(int i) throws IOException ;

	/**
	 * Alkatresz felveteleer felelos fugveny
	 * @param a alkatreszt adja meg
	 * @throws IOException
	 */
	public void alkatreszFelvetele(Alkatresz a) throws IOException {
		if(this.a==null)
		{
			this.setAlkatresz(a);
			this.getMezo().setTargy(null);
		}
		else
		{
			Alkatresz temp = this.a;
			this.setAlkatresz(a);
			temp.addAlkatreszToMezo(m);
		}
		if (getjListener() != null) {
			getjListener().hoviharSzamlaloCsokkentoListener();
			setLepesszam(getLepesszam() - 1);
		}
		FileWriter output = new FileWriter("./kimenet.txt", true);
		output.write("Szereplo targyfelvetele sikeres.\n");
		output.write("Felvett alkatresz: " + a.getNev() + ".\n");
		output.close();
	}

	/**
	 * Az eszkoz felveteleert felelo fuggveny
	 * @param e az eszkozt adja meg
	 * @throws IOException
	 */
	public void eszkozFelvetele(Eszkoz e) throws IOException{
		this.setEszkoz(e);
		this.getMezo().setTargy(null);
		if (getjListener() != null) {
			getjListener().hoviharSzamlaloCsokkentoListener();
			setLepesszam(getLepesszam() - 1);
		}
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
		System.out.println(mezo.getNev());
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

	/**
	 * elfogyasztott elelemmel a szereplo testhoje no
	 * @throws IOException
	 */
	public void etkezes() throws IOException {
		/*
		System.out.println("\t\t>Szereplo.etkezes()");
		System.out.println("\t\t<Szereplo.etkezes()");
		 */
		FileWriter f = new FileWriter("./kimenet.txt", true);
		if (getTestho()==getMaxTestho()){
			f.append("A szereplo testhoje maximalis.\n");
		}
		if(getTestho()<getMaxTestho()){
			setTestho(getTestho()+1);
			f.append("Etkezes sikeres\n");
		}
		f.close();
	}

	/**
	 * Mezo epit fuggvenye hivja meg
	 */
	public void elsut() throws IOException{
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("A szereplonek sikerult osszeszerelni az alkatreszeket.\n");
		f.close();
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
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("A szereplot epp huzzak ki.\n");
		f.close();
		getEszkoz().hasznal(sz);
		this.getMezo().ralep(sz);

	}

	/**
	 *karaktert a mezohoz adja
	 * @param m Mezo
	 */
	public void addKarakterToMezo(Mezo m){
		m.addKarakter(this);
		this.setM(m);
	}

	/**
	 * medvevel talolkozasert felelos fuggveny
	 */
	public void hitByMedve() throws IOException {
		FileWriter output = new FileWriter("./kimenet.txt", true);
		output.write("A jateknak vege: vesztettel.\n");
		output.close();
		if (getjListener() != null) {
			getjListener().jatekVegeListener();
		}
	}
}
