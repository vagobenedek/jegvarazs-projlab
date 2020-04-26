import java.io.FileWriter;
import java.io.IOException;

public class Stabil extends Jegmezo {
	public Stabil(ITargy t, IEpulet e, int hoSzint,int teherbiras, boolean hovihartolVedett, boolean medvetolVedett) throws IOException {
		super(t,e,hoSzint,teherbiras,hovihartolVedett,medvetolVedett);
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Stabil letrejott\n");
		f.close();
	}
	public Stabil()throws IOException{
		FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Jegmezo letrejott\n");
        f.close();
	}

	/**
	 * a parameterkent kaptt szereplot ralepteti a stabil mezore
	 * @param sz: Szereplo
	 */
	public void ralep(IKarakter sz)throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		sz.setM(this);
		addKarakter(sz);
		f.append("A Szereplo stabil mezon all\n");
		f.close();
	}
	/*public int getTeherBiras() throws IOException {
		System.out.println("\t\t>Stabil.getTeherBiras()");
		System.out.println("\t\t<Stabil.getTeherBiras()");
		//random visszateresi ertek
		return teherbiras;
	}*/
}
