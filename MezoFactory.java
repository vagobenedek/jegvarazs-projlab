import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Mezoket hozza letre
 */
public class MezoFactory {
	/**
	 * Konstruktor
	 * @throws IOException
	 */
	public MezoFactory() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("MezoFactory letrejott\n");
		f.close();
	}

	/**
	 * Letrehozza a mezoket es beallitja a szomszedait
	 * @param i int
	 * @return mezok
	 * @throws IOException
	 */
	public List<Mezo> createMezo(int i) throws IOException {
		List<Mezo> mezok = new ArrayList<>();
		int row = (int) Math.sqrt(i);
		for (int j = 0; j != i ; j++){
			mezok.add(new Stabil());

		}

		for (int j = 0; j != i; j++){
			if (j%row == 0){
				System.out.println(j+"36");
				Tenger t = new Tenger();
				mezok.add(t);
				mezok.get(j).setSzomszedMezo(t, 3);
			}
			else {
				System.out.println(j+"42");
				mezok.get(j).setSzomszedMezo(mezok.get(j+1), 3);
			}
			if (j < row){
				System.out.println(j+"46");
				Tenger t = new Tenger();
				mezok.add(t);
				mezok.get(j).setSzomszedMezo(t, 0);
			}
			else {
				System.out.println(j+"52");
				mezok.get(j).setSzomszedMezo(mezok.get(j+row), 0);
			}
			if (Math.floor(j/row) == row-1){
				System.out.println(j+"56");
				Tenger t = new Tenger();
				mezok.add(t);
				mezok.get(j).setSzomszedMezo(t, 1);
			}
			else {
				System.out.println(j+"62");
				mezok.get(j).setSzomszedMezo(mezok.get(j+row), 1);
			}
			if (j%row == row-1){
				System.out.println(j+"66");
				Tenger t = new Tenger();
				mezok.add(t);
				mezok.get(j).setSzomszedMezo(t, 2);
			}
			else {
				System.out.println(j+"72");
				mezok.get(j).setSzomszedMezo(mezok.get(j-1), 2);
			}
		}
		System.out.println("76");
		return mezok;
	}
}
