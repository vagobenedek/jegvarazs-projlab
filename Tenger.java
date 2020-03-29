import java.io.IOException;

public class Tenger extends Mezo {
	public Tenger(){}
	public void ralep(Szereplo sz) throws IOException {
		System.out.println(">Tenger.ralep()");
		new Eszkimo().tesoTeVizbeEstel();
		System.out.println("<Tenger.ralep()");
	}
	public int getTeherBiras() throws IOException {
		System.out.println("\t\t>Tenger.getTeherBiras()");
		System.out.println("\t\t<Tenger.getTeherBiras()");
		//random visszatérési érték
		return 1;
	}
}
