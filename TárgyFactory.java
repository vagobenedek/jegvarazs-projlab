import java.util.ArrayList;

public class TárgyFactory {
	public TárgyFactory(){
		System.out.println(">TárgyFactory konstruktor");
		System.out.println("<TárgyFactory konstruktor");
	}
	public ArrayList<Tárgy> createTárgy(int i) {

		System.out.println(">TárgyFactory.createTárgy(int i)");
		System.out.println("<TárgyFactory.createTárgy(int i)");
		return new ArrayList<Tárgy>();
	}
}
