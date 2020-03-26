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
	
	public void ralep(Szereplo sz) throws IOException {
		System.out.println(">Instabil.ralep()");
		System.out.println("Van még hely a mezőn?");
		System.out.println("1.: Igen\t2.: Nem");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		if (string.equals("2")){
			sz.tesoTeVizbeEstel();
		}
		System.out.println("<Instabil.ralep()");
	}
}
