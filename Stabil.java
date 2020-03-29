import java.io.IOException;

public class Stabil extends Jegmezo {
	public Stabil(){}

	/**
	 * a parameterkent kaptt szereplot ralepteti a stabil mezore
	 * @param sz: Szereplo
	 */
	public void ralep(Szereplo sz) {
		System.out.println(">Stabil.ralep()");
		System.out.println("<Stabil.ralep()");
	}
	public int getTeherBiras() throws IOException {
		System.out.println("\t\t>Stabil.getTeherBiras()");
		System.out.println("\t\t<Stabil.getTeherBiras()");
		//random visszateresi ertek
		return 1;
	}
}
