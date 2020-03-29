import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Instabil extends Jegmezo {
	private int teherbiras;
	public Instabil(int teherbiras){

	}
	public Instabil(){}
	public void atfordul() {
	}

	/**
	 * a parameterkent kaptt szereplot ralepteti az instabil mezore
	 * @param sz: Szereplo
	 * @throws IOException
	 */
	public void ralep(Szereplo sz) throws IOException {
		System.out.println(">Instabil.ralep()");
		System.out.println("Van meg hely a mezon?");
		System.out.println("1.: Igen\t2.: Nem");
		//a beolvasasertfelelos eszkoz;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		//ha a felhasznalo kettest irt be, akkor a szereplo beleesik a vizbe
		if (string.equals("2")){
			sz.tesoTeVizbeEstel();
		}
		System.out.println("<Instabil.ralep()");
	}

	public int getTeherBiras() throws IOException {
		System.out.println("\t\t>Instabil.getTeherBiras()");
		System.out.println("\t\t<Instabil.getTeherBiras()");
		//random visszateresi ertek
		return 1;
	}
}
