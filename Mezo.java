import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Mezo {
	private ArrayList<Szereplo> szereplok;
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

	public ArrayList<Szereplo> getSzereplok() {
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

	public void addSzereplo(Szereplo szereplo) {
		this.szereplok.add(szereplo);
	}
	public void setAlkatresz(Alkatresz a){this.alkatresz=a;}
	public void setEszkoz(Eszkoz e){this.eszkoz=e;}
	public void removeSzereplo(Szereplo szereplo){
		this.szereplok.remove(szereplo);
	}
	public void setTargy(ITargy targy) {
		this.targy = targy;
	}

	public void setEpulet(IEpulet epulet) {
		this.epulet = epulet;
	}

	public void setFeltort(boolean feltort) {
		this.feltort = feltort;
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
		hoNovelo();
		if (true){													//Ez itt még elég szar, bocsi :(
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
	public void ralep(Szereplo sz) throws IOException {
		System.out.println(">Mezo.ralep()");
		sz.setM(this);
		addSzereplo(sz);
		System.out.println("<Mezo.ralep()");
	}

	public int getTeherBiras() throws IOException {
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
		//random visszateresi ertek
		return teherbiras;
	}

	/**
	 * ez a fuggveny lepteti le a parameterkent kapott szereplot, a mezorol
	 * @param sz : Szereplo
	 */
	public void lelep(Szereplo sz) {
		System.out.println(">Mezo.lelep()");
		sz.setM(null);
		this.removeSzereplo(sz);
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
	
	public void hoNovelo() throws IOException {
		hoSzint++;
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Hoszint megnott\n");
		f.close();
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
	
	public void epit(Szereplo sz) throws IOException {
		int count = 0;
		if(szereplok.size()  >= 3) {
			for (Szereplo szereplo : szereplok) {
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
	
	public void targyFelvetele(Szereplo sz) throws IOException {
		//0425
		if(feltort) {
			targy.felvesz(sz);
		}
		else {
			FileWriter output = new FileWriter("./kimenet.txt", true);
			output.write("Szereplo targyfelvetele meghiusult.\n");
			output.close();
		}
	}
	
	public void iglutEpit() throws IOException {
		System.out.println("\t>Mezo.iglutEpit()");
		//A mezo, amit atadunk az az a mezo, amin all az eszkimo. Erre fog kerulni az iglu.
		new Iglu(new Mezo());
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
		for (Szereplo szereplo: this.getSzereplok()){
			if(szereplo.getEszkoz().equals("Kotel")){
				szereplo.huzdKi(sz);
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
}
