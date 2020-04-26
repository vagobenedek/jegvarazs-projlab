import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Mezo {
	/**
	 * Mezon allo szereploket tarolja
	 */
	private ArrayList<IKarakter> szereplok;
	/**
	 * Mezon levo targy
	 */
	private ITargy targy;
	/**
	 * Mezon levo epulet
	 */
	private IEpulet epulet;
	/**
	 * fel van e torve a mezo
	 */
	private boolean feltort;
	/**
	 * mezo hoszintje
	 */
	private int hoSzint;
	/**
	 * mezo teherbirasa
	 */
	private int teherbiras;
	/**
	 * hovihartol vedett e a mezo
	 */
	private boolean hovihartolVedett;
	/**
	 * medvetol vedett e a mezo
	 */
	private boolean medvetolVedett;
	/**
	 * Mezo szomszedai
	 */
	private Mezo[] szomszedMezok = new Mezo[4];


	/**
	 * beallitja a mezo szomszedjat: a parameterben megadott mezot a parameterben megadott iranyba
	 * @param szomszedMezo Mezo
	 * @param irany int
	 */
	public void setSzomszedMezo(Mezo szomszedMezo, int irany) {
		szomszedMezok[irany] = szomszedMezo;
	}

	/**
	 * Mezo konstruktor ami beallitja a Mezo parametereit
	 * @param t ITargy
	 * @param e IEpulet
	 * @param hoSzint int
	 * @param teherbiras int
	 * @param hovihartolVedett boolean
	 * @param medvetolVedett boolean
	 * @throws IOException
	 */
	public Mezo(ITargy t, IEpulet e, int hoSzint,int teherbiras, boolean hovihartolVedett, boolean medvetolVedett) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Mezo letrejott\n");
		f.close();
		targy = t;
		epulet = e;
		feltort = false;
		this.hoSzint = hoSzint;
		this.teherbiras=teherbiras;
		this.hovihartolVedett = hovihartolVedett;
		this.medvetolVedett = medvetolVedett;
	}

	/**
	 * Mezo konstuktor
	 * @throws IOException
	 */
	public Mezo() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Mezo letrejott\n");
		f.close();
	}

	/**
	 * Mezo konstruktor
	 * @param s String
	 * @throws IOException
	 */
	public Mezo(String s) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Mezo letrejott\n");
		f.close();
	}

	/**
	 * visszaadja a szereploket
	 * @return szereplok
	 */
	public ArrayList<IKarakter> getSzereplok() {
		return szereplok;
	}

	/**
	 * lekerdezi a targyat
	 * @return targy
	 */
	public ITargy getTargy() {
		return targy;
	}

	/**
	 * lekerdezi az epuletet
	 * @return epulet
	 */
	public IEpulet getEpulet() {
		return epulet;
	}

	/**
	 * visszaadja hogy a mezo fel van e torve
	 * @return feltort
	 */
	public boolean isFeltort() {
		return feltort;
	}

	/**
	 * visszaadja a mezo hoszintjet
	 * @return hoszint
	 */
	public int getHoSzint() {
		return hoSzint;
	}

	/**
	 * visszaadja hogy a mezo hovihartol vedett e
	 * @return hovihartolVedett boolean
	 */
	public boolean isHovihartolVedett() {
		return hovihartolVedett;
	}

	/**
	 * visszaadja hogy a mezo medvetol vedett e
	 * @return medvetolVedett boolean
	 */
	public boolean isMedvetolVedett() {
		return medvetolVedett;
	}

	/**
	 * karaktert ad a mezohoz
	 * @param szereplo IKarakter
	 */
	public void addKarakter(IKarakter szereplo) {
		this.szereplok.add(szereplo);
	}

	/**
	 * kivesz egy szereplot a listabol (a mezonrol eltavolit egy szereplot)
	 * @param szereplo IKarakter
	 */
	public void removeSzereplo(IKarakter szereplo){
		this.szereplok.remove(szereplo);
	}

	/**
	 * beallitja a targyat
	 * @param targy ITargy
	 */
	public void setTargy(ITargy targy) {
		this.targy = targy;
	}

	/**
	 * beallitja az epuletet
	 * @param epulet Iepulet
	 */
	public void setEpulet(IEpulet epulet) {
		this.epulet = epulet;
	}

	/**
	 * beallitja a hoszintet
	 * @param hoSzint int
	 */
	public void setHoSzint(int hoSzint) {
		this.hoSzint = hoSzint;
	}

	/**
	 * hovihartol vedettre allitja a mezot
	 */
	public void setHovihartolVedett(boolean hovihartolVedett) {
		this.hovihartolVedett = hovihartolVedett;
	}

	/**
	 * medvetol vedettre allitja a mezot
	 * @param medvetolVedett boolean
	 */
	public void setMedvetolVedett(boolean medvetolVedett) {
		this.medvetolVedett = medvetolVedett;
	}

	/**
	 * hovihat fuggveny
	 * @throws IOException
	 */
	public void hovihar() throws IOException {
		//Noveli a mezon levo hoegysegek szamat
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Mezon hovihar tamadt\n");
		f.close();
		hoNovelo();
		if (!this.isHovihartolVedett()){
			for (int i = 0; i != szereplok.size(); i++){
				szereplok.get(i).hovihar();
			}
		}
	}

	/**
	 * ez a fuggveny felel a mezo raleptetesere
	 * a parameterkent kapott szereplot lepteti ra
	 * @param sz: Szereplo
	 * @throws IOException
	 */
	public void ralep(IKarakter sz) throws IOException {
		System.out.println(">Mezo.ralep()");
		sz.setM(this);
		addKarakter(sz);
		System.out.println("<Mezo.ralep()");
	}

	/**
	 * sator epitesenel beallitja a mezo vedelmet
	 * @param sator Sator
	 */
	public void satratEpit(Sator sator){
		sator.SetVedelem();
	}

	/**
	 * sator szetszedesert felelos fuggveny
	 */
	public void Satorszetszed(){
		this.setHovihartolVedett(false);
		this.setMedvetolVedett(false);
	}

	/**
	 * teherbiras lekerdezes
	 * @return teherbiras int
	 * @throws IOException
	 */
	public int getTeherBiras() throws IOException {

		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Teherbiras lekerdezese\n");
		f.close();

		return teherbiras;
	}

	/**
	 * ez a fuggveny lepteti le a parameterkent kapott szereplot, a mezorol
	 * @param sz : Szereplo
	 */
	public void lelep(IKarakter sz) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Szereplo lelep a mezorol\n");
		f.close();
		sz.setM(null);
		this.removeSzereplo(sz);

	}

	/**
	 * a mezo szomszedjat adja vissza a kapott parameternek megfeleloen
	 * @param irany: int
	 * @return Mezo
	 */
	public Mezo getSzomszed(int irany) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Szomszéd lekérdezése\n");
		f.close();
		//ebben az esetben nem kell semmit visszaadni
		return szomszedMezok[irany];
	}

	/**
	 * A parameternek megfelelo alkalommal hivja meg a hoCsokkento() metodust. 
	 * Ezutan fajlba irja a hoSzint attributum erteket.
	 * @param lapat Megmondja, hogy lapattal (1) vagy lapat nelkul (0) tortenik az asas.
	 * @throws IOException
	 */
	public void hoAso(int lapat) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Mezo hoasas\n");

		for (int i=0; i<=lapat; i++){
			this.hoCsokkento();
		}

		f.append("A hoszint a mezon: " + this.hoSzint + ".\n");
		f.close();
	}

	/**
	 * Ha a hoszint nagyobb 0-nal, csokkenti a hoszintet 1-gyel �s ezt fajlba irva jelzi.
	 * @throws IOException
	 */
	public void hoCsokkento() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		if(hoSzint > 0) {
			hoSzint -= 1;
			f.append("Hoszint eggyel csokkent\n");
		}
		f.close();
	}

	/**
	 * Noveli a hoszintet 1-gyel, majd ezt fajlba irva jelzi.
	 * @throws IOException
	 */
	public void hoNovelo() throws IOException {
		setHoSzint(getHoSzint()+1);
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Hoszint megnott\n");
		f.close();
	}

	/**
	 * A boolean feltort attributum erteket igazba allitja, majd fajlba irva jelzi a mezo feltoreset.
	 * @throws IOException
	 */
	public void feltor() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		this.feltort=true;
		f.append("A mezo feltort.\n");
		f.close();
	}

	/**
	 * Szereplo osszeszerel fuggvenye hivja meg, megvizsgalja, hogy minden alkatresz egy mezon van e
	 * @param sz Szereplo
	 * @throws IOException
	 */
	public void epit(Szereplo sz) throws IOException {
		int count = 0;
		if(szereplok.size()  >= 3) {
			for (IKarakter szereplo : szereplok) {
				if (szereplo.getAlkatresz() != null) {
					count++;
				}
			}
		}
		if (count == 3)
		{
			//dosomething
			sz.elsut();
		} else {
			FileWriter output = new FileWriter("./kimenet.txt", true);
			output.write("A szereplonek nem sikerult osszeszerelni az alkatreszeket.\n");
			output.close();
		}
	}

	/**
	 * Tárgy felvétele
	 * @param sz Szereplo
	 * @throws IOException
	 */
	public void targyFelvetele(Szereplo sz) throws IOException {
		//0425
		if(isFeltort() && targy != null) {
			targy.felvesz(sz);
		}
		else {
			FileWriter output = new FileWriter("./kimenet.txt", true);
			output.write("Szereplo targyfelvetele meghiusult.\n");
			output.close();
		}
	}

	/**
	 * iglut epit a mezore
	 * @throws IOException
	 */
	public void iglutEpit() throws IOException {
		new Iglu(this);
		FileWriter output = new FileWriter("./kimenet.txt", true);
		output.write("Iglu epitese sikeres\n");
		output.close();
	}

	/**
	 * a Szereplo kihuzasaert felel, akit parametrben kapunk
	 * @param sz : Szereplo
	 * @throws IOException
	 */
	public void huzzKi(Szereplo sz) throws IOException {
		System.out.println(">Mezo.huzzki()");
		//System.out.println("Van a szereplonel kotel?\n1.: Igen\t2.: Nem");
		FileWriter output = new FileWriter("./kimenet.txt", true);
		output.write("Szereplo kihuzasa\n");
		output.close();
		boolean vankotel = false;
		for (IKarakter szereplo: this.getSzereplok()){
			if(szereplo.getEszkoz()!=null && szereplo.getEszkoz().getNev().equals("Kotel")){
				szereplo.huzdKi(sz);
				vankotel = true;
			}
		}
		if (!vankotel) {

			output.write("A jateknak vege: vesztettel.\n");
			if(sz.getjListener()!=null) {
				sz.getjListener().jatekVegeListener();
			}
		}

	}
	/*public void szereplokMeetMedve(){
		if(medvetolVedett){
			for (IKarakter szereplo: szereplok){
				szereplo.hitByMedve();
			}
		}
	}*/

	/**
	 * mezo teherbirast allitja be
	 * @param teherb int
	 */
	public void setTeherbiras(int teherb) {
		teherbiras = teherb;
	}
}
