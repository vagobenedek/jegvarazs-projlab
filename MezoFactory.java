import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
				mezok.get(j).setSzomszedMezo(new Tenger(), 3);
			}
			else {
				mezok.get(j).setSzomszedMezo(mezok.get(j+1), 3);
			}
			if (j < row){
				mezok.get(j).setSzomszedMezo(new Tenger(), 0);
			}
			else {
				mezok.get(j).setSzomszedMezo(mezok.get(j+row), 0);
			}
			if (Math.floor(j/row) == row-1){
				mezok.get(j).setSzomszedMezo(new Tenger(), 1);
			}
			else {
				mezok.get(j).setSzomszedMezo(mezok.get(j-row), 1);
			}
			if (j%row == row-1){
				mezok.get(j).setSzomszedMezo(new Tenger(), 2);
			}
			else {
				mezok.get(j).setSzomszedMezo(mezok.get(j-1), 2);
			}
		}
		return mezok;
	}
}
