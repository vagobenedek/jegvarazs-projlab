import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Mezo {
	private ArrayList<IKarakter> szereplok;
	private ITargy targy;
	private IEpulet epulet;
	private boolean feltort;
	private int hoSzint;
	private int teherbiras;
	private boolean hovihartolVedett;
	private boolean medvetolVedett;
	private Mezo[] szomszedMezok = new Mezo[4];
	private Eszkoz eszkoz;
	private Alkatresz alkatresz;


	public void setSzomszedMezo(Mezo szomszedMezo, int irany) {
		szomszedMezok[irany] = szomszedMezo;
	}

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
	public Mezo() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Mezo letrejott\n");
		f.close();
	}
	public Mezo(String s) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Mezo letrejott\n");
		f.close();
	}
	public ArrayList<IKarakter> getSzereplok() {
		return szereplok;
	}

	public ITargy getTargy() {
		return targy;
	}

	public IEpulet getEpulet() {
		return epulet;
	}

	public boolean isFeltort() {
		return feltort;
	}

	public int getHoSzint() {
		return hoSzint;
	}

	public boolean isHovihartolVedett() {
		return hovihartolVedett;
	}

	public boolean isMedvetolVedett() {
		return medvetolVedett;
	}

	public void addKarakter(IKarakter szereplo) {
		this.szereplok.add(szereplo);
	}

	public void setAlkatresz(Alkatresz a){this.alkatresz=a;}
	public void setEszkoz(Eszkoz e){this.eszkoz=e;}

	public void removeSzereplo(IKarakter szereplo){
		this.szereplok.remove(szereplo);
	}
	public void setTargy(ITargy targy) {
		this.targy = targy;
	}

	public void setEpulet(IEpulet epulet) {
		this.epulet = epulet;
	}

	public void setHoSzint(int hoSzint) {
		this.hoSzint = hoSzint;
	}

	public void setHovihartolVedett(boolean hovihartolVedett) {
		this.hovihartolVedett = hovihartolVedett;
	}

	public void setMedvetolVedett(boolean medvetolVedett) {
		this.medvetolVedett = medvetolVedett;
	}

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
		/*Amennyiben van iglu a mezon, nem foglalkoznk azzal, hogy van-e szereplo a mezon
		Amennyiben nincs iglu, megkerdezzuk hogy szereplo van-e
		A kapott valasznak megfeleloen cselekszunk*/
		/*System.out.println("Van iglu a mezon?");
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
		}*/
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
	public void satratEpit(Sator sator){
		sator.SetVedelem();
	}
	public void Satorszetszed(){
		this.setHovihartolVedett(false);
		this.setMedvetolVedett(false);
	}
	public int getTeherBiras() throws IOException {

		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Teherbiras lekerdezese\n");
		f.close();
		/*
		System.out.println("\t>Mezo.getTeherBiras()");
		System.out.println("Milyen tipusu mezon allok?");
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
		*/
		//random visszateresi ertek

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

		/*
		System.out.println(">Mezo.lelep()");
		sz.setM(null);
		this.removeSzereplo(sz);
		System.out.println("<Mezo.lelep()");
		 */
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
	 * @param sz
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
	 * @param sz
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
		boolean vankotel = false;
		for (IKarakter szereplo: this.getSzereplok()){
			if(szereplo.getEszkoz()!=null && szereplo.getEszkoz().getNev().equals("Kotel")){
				szereplo.huzdKi(sz);
				vankotel = true;
			}
		}
		if (!vankotel) {
			if(sz.getjListener()!=null) {
				sz.getjListener().jatekVegeListener();
			}
		}/*
		// a beolvasert felelos objektum
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ha van a szereplon kotel, vagyis egyest irt be
		if (br.readLine().equals("1")) {
			//szolunk a mezon allo szereplonek, hogy huzza ki a parameterkent kapott szereplot
			//majd ezt a parametert adjuk tovabb
			new Sarkkutato().huzdKi(new Eszkimo());
		}*/

		System.out.println("<Mezo.huzzki()");
	}
	/*public void szereplokMeetMedve(){
		if(medvetolVedett){
			for (IKarakter szereplo: szereplok){
				szereplo.hitByMedve();
			}
		}
	}*/
	public void setTeherbiras(int teherb) {
		teherbiras = teherb;
	}
}
