import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Instabil extends Jegmezo {
	private int teherbiras;
	public Instabil(ITargy t, int hoSzint,int teherbiras, boolean vedett) throws IOException {
		//super(t,e,hoSzint,teherbiras,vedett);
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Instabil letrejott\n");
		f.close();
	}
	public Instabil() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Instabil letrejott\n");
		f.close();
	}
	public void atfordul() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Az Instabil mez oatfordult\n");
		f.close();
		for (IKarakter szereplo : this.getSzereplok()){
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
		f.append("A Szereplo instabil mezon all\n");
		f.close();
		sz.setM(this);
		this.addKarakter(sz);
		if (this.getTeherBiras()<this.getSzereplok().size()){
			atfordul();
		}
		/*System.out.println("Van meg hely a mezon?");
		System.out.println("1.: Igen\t2.: Nem");
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
