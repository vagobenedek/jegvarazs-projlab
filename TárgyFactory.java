import java.util.ArrayList;

public class T�rgyFactory {
	public T�rgyFactory(){
		System.out.println(">T�rgyFactory konstruktor");
		System.out.println("<T�rgyFactory konstruktor");
	}
	public ArrayList<T�rgy> createT�rgy(int i) {

		System.out.println(">T�rgyFactory.createT�rgy(int i)");
		System.out.println("<T�rgyFactory.createT�rgy(int i)");
		return new ArrayList<T�rgy>();
	}
}
