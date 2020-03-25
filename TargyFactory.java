import java.util.ArrayList;

public class TargyFactory {
	public TargyFactory(){
		System.out.println(">TargyFactory konstruktor");
		System.out.println("<TargyFactory konstruktor");
	}
	public ArrayList<Targy> createTargy(int i) {

		System.out.println(">TargyFactory.createTargy(int i)");
		System.out.println("<TargyFactory.createTargy(int i)");
		return new ArrayList<Targy>();
	}
}
