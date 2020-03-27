import java.io.IOException;

public class Tenger extends Mezo {
	public Tenger(){}
	public void ralep(Szereplo sz) throws IOException {
		System.out.println(">Tenger.ralep()");
		new Eszkimo().tesoTeVizbeEstel();
		System.out.println("<Tenger.ralep()");
	}
}
