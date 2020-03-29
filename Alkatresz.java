import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Alkatresz extends Targy {
	public Alkatresz(){}

	/**
	 * Az alkatresz felvesz fuggvenye
	 * @param sz szereplot adja meg
	 * @throws IOException
	 */
	@Override
	public void felvesz(Szereplo sz) throws IOException {
		System.out.println(">Alkatresz.felvesz(Szereplo)");

		//az atadott szereplo alkatreszFelvetele függvenyet hivjuk meg
		//itt most egy random alkatreszt hoztam letre és adtam at a függveny parameterekent
		sz.alkatreszFelvetele(new Pisztoly());

		System.out.println("<Alkatresz.felvesz(Szereplo)");
	}

	/**
	 * Az alkatreszt a mezohoz ado fuggveny
	 * @param m mezot adja meg
	 */
	public void addAlkatreszToMezo(Mezo m){
		System.out.println(">Alkatresz.addAlkatreszToMezo()");
		System.out.println("<Alkatresz.addAlkatreszToMezo()");
	}
}
