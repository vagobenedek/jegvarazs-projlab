import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Targy {
	public Targy(){}
	public void felvesz(Szereplo sz) throws IOException {
		System.out.println(">Targy.felvesz(Szereplo sz)");
		//menü
		System.out.println("Mit szeretne felvenni?");
		System.out.println("1.: Alkatrészt");
		System.out.println("2. Eszközt");
		//a felhasználó által beolvasott szám megjelenítése
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		if(str.equals("1")){
			//menü
			System.out.println("Van már nála alkatrész?");
			System.out.println("1.: Van");
			System.out.println("2.: Nincs");
			//a felhasználó által beolvasott szám megjelenítése
			BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
			String read = buff.readLine();
			if(read.equals("1")){
				//az átadott szereplő alkatreszFelvetele függvényét hívjuk meg
				//itt most egy random alkatrészt hoztam létre és adtam át a függvény paramétereként
				sz.alkatreszFelvetele(new Pisztoly());
			}
			if(read.equals("2")){
				//az átadott szereplő alkatreszFelvetele függvényét hívjuk meg
				//itt most egy random alkatrészt hoztam létre és adtam át a függvény paramétereként
				sz.alkatreszFelvetele(new Pisztoly());
			}
		}
		if(str.equals("2")){
			//menü
			System.out.println("Van már nála eszköz?");
			System.out.println("1.: Van");
			System.out.println("2.: Nincs");
			BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
			String read = buff.readLine();
			if(read.equals("1")){
				//az átadott szereplő eszközFelvétele függvényét hívjuk meg
				//itt most egy random eszközt hoztam létre és adtam át a függvény paramétereként
				sz.eszkozFelvetele(new Kotel());
			}
			if(read.equals("2")) {
				//az átadott szereplő eszközFelvétele függvényét hívjuk meg
				//itt most egy random eszközt hoztam létre és adtam át a függvény paramétereként
				sz.eszkozFelvetele(new Kotel());
			}
		}
		System.out.println("<Targy.felvesz(Szereplo sz)");
	}
}
