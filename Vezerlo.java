import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Vezerlo implements JegvarazsListener{
	/**
	 * az eppen soron levo jatekos
	 */
	private Szereplo aktualisSzereplo;
	/**
	 * az osszes szereplot tarolo lista
	 */
	private List<Szereplo> szereplok = new ArrayList<>();
	/**
	 * a vezerlo jegesmedve objektuma
	 */
	private Jegesmedve jegesmedve;
	/**
	 * a vezorlo palya eleme
	 */
	private Palya palya;
	/**
	 * a a hatralevo idot tarolja a kovetkezo hoviharig
	 */
	private int hovihar_szamlalo;
	private boolean gyoztel = false;
	private boolean vesztettel = false;
	/**
	 * Vezerlo Skeleton konstruktora
	 * @throws IOException
	 */
	public Vezerlo(int meret, int sarkkutato, int eszkimo) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", false);
		f.write("Vezerlo letrejott.\n");
		f.close();
		jegesmedve = new Jegesmedve();
		List<IKarakter> karakterek =  new SzereploFactory().createSzereplo(eszkimo, sarkkutato);
		for (int i = 0; i != karakterek.size(); i++){
			szereplok.add((Szereplo) karakterek.get(i));
		}
		//hozzaadja a jegesmedvet a karakterek listajahoz
		karakterek.add(jegesmedve);
		//Letrehozzuk a palyat, ami konstruktoraban gondoskodik az egyeb elemek letrehozasarol
		palya=new Palya(meret, meret, karakterek);
		//beallitjuk az aktualis szereplot
		aktualisSzereplo = szereplok.get(0);
		Init();
	}
	public Palya getPalya(){
		return palya;
	}
	/**
	 * Vezerlo Proto konstruktora
	 * @param szereplo: Szereplo
	 * @param medve: Jegesmedve
	 * @throws IOException
	 */
	public Vezerlo(Szereplo szereplo, Jegesmedve medve) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Vezerlo letrejott.\n");
		f.close();
		if (medve != null){
			medve.setjListener(this);
		}
		//Letrehozzuk a palyat, ami konstruktoraban gondoskodik az egyeb elemek letrehozasarol
		//palya = new Palya(10, 10);
		setAktualisSzereplo(szereplo);
		Init();
	}
	public boolean Gyoztel(){return gyoztel;}
	public boolean Vesztettel(){return vesztettel;}
	/**
	 * a listener hozzaadasa a szereplohoz
	 */
	private void Init(){
		for (Szereplo szereplo : szereplok){
			szereplo.setjListener(this);
		}
		jegesmedve.addJListener(this);
	}

	/**
	 * beallitja az aktualis szereplot
	 * @param szereplo
	 */
	public void setAktualisSzereplo(Szereplo szereplo){
		aktualisSzereplo=szereplo;
		// ha ez a szereplo epitett satrat az elozo korben akkor a satrat lebontjuk
		if(szereplo.getEpitettSatratElozoKorben()){
			try {
				szereplo.getSatrasmezo().Satorszetszed();
				szereplo.setSatrasmezo(null);
				szereplo.setEpitettSatratElozoKorben(false);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}

	/**
	 * az aktualis szereplot adja vissza
	 * @return
	 */
	public Szereplo getAktualisSzerelo(){
		return aktualisSzereplo;
	}
	/**
	 * A jatekvegeert felelos fuggveny
	 *
	 */
	public void jatekVege() {
		vesztettel = true;
	}

	/**
	 * beallitja a kovetkeo szereplot, aki jon a sorban
	 * ha nincs mar tobb, akkor az elso lesz ujra az aktualis szereplo
	 */
	public void kovetkezoSzereplo() {
		for(int i=0;i<szereplok.size();i++){
			if(aktualisSzereplo.equals(szereplok.get(i))){
				if(i+1==szereplok.size()){
					lepesekFeltoltese();
					try {
						jegesmedve.lep(new Random().nextInt(4));
					}
					catch(Exception e){
						e.printStackTrace();
					}
					setAktualisSzereplo(szereplok.get(0));
				}
				else
					setAktualisSzereplo(szereplok.get(i+1));
				break;
			}
		}
	}

	/**
	 * beallitja a hpviharszamlali erteket
	 * @param hovihar_szamlalo: int
	 */
	public void sethoviharSzamlalo(int hovihar_szamlalo) {
		this.hovihar_szamlalo=hovihar_szamlalo;
	}

	/**
	 * csokkentjuk a hovihar szamlalot random ertekkel
	 * ha nulla akkor meghivjuk a palya hovihar fuggvenyet
	 * es uj erteket kap a hovihar szamlalo
	 */
	public void hoviharSzamlaloCsokkentes() {
		hovihar_szamlalo -= new Random().nextInt(4) ;
		if(hovihar_szamlalo<=0){
			try {
				if(palya!=null) {
					palya.hovihar();
				}
				sethoviharSzamlalo(new Random().nextInt(20));
			}
			catch (Exception e){
				e.printStackTrace();
			}

		}
	}

	/**
	 *Az Vezerlo gyozelem fuggvenye
	 */
	public void gyozelem() throws IOException {
		FileWriter output = new FileWriter("./kimenet.txt", true);
		output.write(".A szereplonek sikerult osszeszerelni az alkatreszeket.\n");
		output.close();
		gyoztel=true;
	}

	/**
	 * feltolti az osszes szereplo lepesszamat maximalisra
	 */
	public void lepesekFeltoltese() {
		for (Szereplo szereplo: this.szereplok){
			szereplo.setLepesszam(4);
		}
		//System.out.println("<Vezerlo.lepesekFeltoltese()");
	}

	/**
	 * a jatek vegeert felelos listener Jegvarazslistener felulirtja
	 */
	@Override
	public void jatekVegeListener() {
		jatekVege();
	}

	/**
	 * a gyozelem listenerje JegvarazsListener felulirtja
	 */
	@Override
	public void gyozelemListener() {
		try {
			gyozelem();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * hoviharszamlalocsokkentes listenerje JegvarazsListener felulirtja
	 */
	@Override
	public void hoviharSzamlaloCsokkentoListener() {
		hoviharSzamlaloCsokkentes();
	}

	/**
	 * ez a Listener hivja meg a kovetkezo szereplo beallitasaert felelos fuggvenyt
	 */
	@Override
	public void kovetkezoSzereploListener() {
		kovetkezoSzereplo();
	}

	@Override
	public void SzereplokMeetMedve() {
		for (Szereplo szereplo: szereplok){
			try{
				Mezo mezo = jegesmedve.getMezo();
				if(mezo.equals(szereplo.getMezo())&&!mezo.isMedvetolVedett()){
				szereplo.hitByMedve();
			}}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
