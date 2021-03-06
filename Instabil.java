import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Instabil osztaly, jegmezobol szarmazik le
 */
public class Instabil extends Jegmezo {
	/**
	 * Teherbiras
	 */
	private int teherbiras;

	/**
	 * Konstruktor
	 * @param teherbiras int
	 * @throws IOException
	 */
	public Instabil(int teherbiras) throws IOException {
		//super(t,e,hoSzint,teherbiras,vedett);
		setTeherbiras(teherbiras);
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Instabil letrejott\n");
		f.close();
	}

	@Override
	public String getNev() {
		return "Instabil";
	}

	/**
	 * Konstruktor
	 * @throws IOException
	 */
	public Instabil() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Instabil letrejott\n");
		f.close();
	}

	/**
	 * Instabil mezo atfordul fuggveny, szereplo vizbe esik
	 * @throws IOException
	 */
	public void atfordul() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Az Instabil mezo atfordult\n");
		f.close();
		for (Iterator<IKarakter> szereplok = this.getSzereplok().iterator(); szereplok.hasNext();){
			if(this.getSzereplok().isEmpty()){
				break;
			}
			IKarakter szereplo = szereplok.next();
			szereplo.tesoTeVizbeEstel();
		}
	}

	/**
	 * a parameterkent kaptt szereplot ralepteti az instabil mezore
	 * @param sz: Szereplo
	 * @throws IOException
	 */
	public void ralep(IKarakter sz) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("A szereplo instabil mezon all.\n");
		f.close();
		sz.setM(this);
		this.addKarakter(sz);
		if (this.getTeherBiras()<this.getSzereplok().size()){
			atfordul();
		}
		
		/*System.out.println("1.: Igen\t2.: Nem");
		//a beolvasasertfelelos eszkoz;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		//ha a felhasznalo kettest irt be, akkor a szereplo beleesik a vizbe
		if (string.equals("2")){
			sz.tesoTeVizbeEstel();
		}*/
	}

	/*public int getTeherBiras() throws IOException {
		System.out.println("\t\t>Instabil.getTeherBiras()");
		System.out.println("\t\t<Instabil.getTeherBiras()");
		//random visszateresi ertek
		return teherbiras;
	}*/

}
