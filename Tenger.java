import java.io.IOException;

public class Tenger extends Mezo {
	public Tenger(){}

	/**
	 * A Tenger mezore lepteteseert felelos fuggveny
	 * @param sz: Szereplo
	 * @throws IOException
	 */
	public void ralep(Szereplo sz) throws IOException {
		System.out.println(">Tenger.ralep()");
		//a Tengeren egybol vizbeesik a szereplo
		new Eszkimo().tesoTeVizbeEstel();
		System.out.println("<Tenger.ralep()");
	}
	public int getTeherBiras() throws IOException {
		System.out.println("\t\t>Tenger.getTeherBiras()");
		System.out.println("\t\t<Tenger.getTeherBiras()");
		//random visszateresi értek
		return 1;
	}
}
