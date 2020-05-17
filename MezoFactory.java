import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	public List<Mezo> createMezo(int i, int numberOfPlayers) throws IOException {
		List<Mezo> mezok = new ArrayList<>();
		int row = (int) Math.sqrt(i);
		for (int j = 0; j != i ; j++){
			if (j < row){
				Tenger t = new Tenger();
				for(int x = 0; x != 4; x++){
					t.setSzomszedMezo(null,x);
				}
				mezok.add(t);
			}
			else if (Math.floor(j/row) == row-1) {
				Tenger t = new Tenger();
				for(int x = 0; x != 4; x++){
					t.setSzomszedMezo(null,x);
				}
				mezok.add(t);
			}
			else if (j%row == row-1){
				Tenger t = new Tenger();
				for(int x = 0; x != 4; x++){
					t.setSzomszedMezo(null,x);
				}
				mezok.add(t);
			}
			else if (j%row == 0) {
				Tenger t = new Tenger();
				for(int x = 0; x != 4; x++){
					t.setSzomszedMezo(null,x);
				}
				mezok.add(t);
			}
			else {
				int p = new Random().nextInt(10);
				if (p <= 5){
					mezok.add(new Stabil());
				}
				else if (p <= 8){
					mezok.add(new Instabil(new Random().nextInt(numberOfPlayers)));
				}
				else if (p == 9){
					mezok.add(new Lyuk());
				}
			}
		}
		for (int j = 0; j != i; j++) {

			if (j%row == 0){
				System.out.println(j+"36");
				mezok.get(j).setSzomszedMezo(mezok.get(j+1), 3);

			}
			if (j < row){
				System.out.println(j+"46");
				mezok.get(j).setSzomszedMezo(mezok.get(j+row), 0);
			}
			if (Math.floor(j/row) == row-1){
				System.out.println(j+"56");
				mezok.get(j).setSzomszedMezo(mezok.get(j-row), 1);
			}
			if (j%row == row-1){
				System.out.println(j+"66");
				mezok.get(j).setSzomszedMezo(mezok.get(j-1), 2);
			}
			if ( !(j%row == 0) && !(j < row)  && ! (Math.floor(j/row) == row-1) && !(j%row == row-1) ) {
				mezok.get(j).setSzomszedMezo(mezok.get(j+1), 3);
				mezok.get(j).setSzomszedMezo(mezok.get(j+row), 0);
				mezok.get(j).setSzomszedMezo(mezok.get(j-row), 1);
				mezok.get(j).setSzomszedMezo(mezok.get(j-1), 2);
			}
		}
		System.out.println("76");
		return mezok;
	}
}
