import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Vezerlo implements JegvarazsListener{
	private Szereplo aktualisSzereplo;
	private List<Szereplo> szereplok = new ArrayList<>();
	private Jegesmedve jegesmedve;
	private Palya palya;
	private int hovihar_szamlalo;
	public Vezerlo(String s) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Vezerlo letrejott.\n");
		f.close();
		//Letrehozzuk a palyat, ami konstruktoraban gondoskodik az egyeb elemek letrehozasarol
		jegesmedve = new Jegesmedve();
		List<IKarakter> karakterek =  new SzereploFactory().createSzereplo(3);
		for (int i = 0; i != karakterek.size(); i++){
			szereplok.add((Szereplo) karakterek.get(i));
		}
		karakterek.add(jegesmedve);
		palya=new Palya(10,10, karakterek);
		aktualisSzereplo = szereplok.get(0);
	}
	public Vezerlo(Szereplo szereplo) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Vezerlo letrejott.\n");
		f.close();
		//Letrehozzuk a palyat, ami konstruktoraban gondoskodik az egyeb elemek letrehozasarol
		//palya = new Palya(10, 10);
		setAktualisSzereplo(szereplo);
		Init();
	}
	private void Init(){
		/*for (Szereplo szereplo:szereplok){
			szereplo.setjListener(this);
		}*/

		aktualisSzereplo.setjListener(this);
	}
	public void setAktualisSzereplo(Szereplo szereplo){
		aktualisSzereplo=szereplo;
		if(szereplo.getEpitettSatratElozoKorben()){
			try {
				szereplo.getMezo().Satorszetszed();
				szereplo.setEpitettSatratElozoKorben(false);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	/**
	 * A Vezerlo alabb lathato fuggvenyei mind listenereken keresztul hivodnak majd meg
	 * bizonyos esemenyke bekovetkeztekor
	 */
	public void jatekVege() {
		System.out.println(">Vezerlo.jatekVege()");
		System.out.println("A jateknak vege");
		System.out.println("<Vezerlo.jatekVege()");
	}
	
	public void kovetkezoSzereplo() {
		System.out.println(">Vezerlo.kovetkezoSzereplo()");
		for(int i=0;i<szereplok.size();i++){
			if(aktualisSzereplo.equals(szereplok.get(i))){
				if(i+1==szereplok.size()){
					lepesekFeltoltese();
					setAktualisSzereplo(szereplok.get(0));
				}
				else
					setAktualisSzereplo(szereplok.get(i));
			}
		}
		System.out.println("<Vezerlo.kovetkezoSzereplo()");
	}
	
	public void sethoviharSzamlalo(int hovihar_szamlalo) {
		System.out.println(">Vezerlo.hoviharSzamlalo()");
		this.hovihar_szamlalo=hovihar_szamlalo;
		System.out.println("<Vezerlo.hoviharSzamlalo()");
	}
	
	public void hoviharSzamlaloCsokkentes() {
		System.out.println(">Vezerlo.hoviharSzamlaloCsokkentes()");
		hovihar_szamlalo -= new Random().nextInt(4) ;
		if(hovihar_szamlalo==0){
			try {
				palya.hovihar();
				sethoviharSzamlalo(new Random().nextInt(20));
			}
			catch (Exception e){
				e.printStackTrace();
			}

		}
		System.out.println("<Vezerlo.hoviharSzamlaloCsokkentes()");
	}

	/**
	 *Az Vezerlo gyozelem fuggvenye
	 */
	public void gyozelem() throws IOException {
		FileWriter output = new FileWriter("./kimenet.txt", true);
		output.write(".A szereplonek sikerult osszeszerelni az alkatreszeket.\n");
		output.close();
	}

	public void lepesekFeltoltese() {
		System.out.println(">Vezerlo.lepesekFeltoltese()");
		for (Szereplo szereplo: this.szereplok){
			szereplo.setLepesszam(4);
		}
		System.out.println("<Vezerlo.lepesekFeltoltese()");
	}

	@Override
	public void jatekVegeListener() {
		jatekVege();
	}

	@Override
	public void gyozelemListener() {
		try {
			gyozelem();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void hoviharSzamlaloCsokkentoListener() {
		hoviharSzamlaloCsokkentes();
	}

	@Override
	public void kovetkezoSzereploListener() {
		kovetkezoSzereplo();
	}

	@Override
	public void SzereplokMeetMedve(Jegesmedve jmedve) {
		for (Szereplo szereplo: szereplok){
			try{
				Mezo mezo = jmedve.getMezo();
			if(mezo.equals(szereplo.getMezo())&&mezo.isMedvetolVedett()){
				szereplo.hitByMedve();
			}}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
