import java.io.FileWriter;
import java.io.IOException;

public class Tenger extends Mezo {
	public Tenger() throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Tenger letrejott.\n");
		f.close();
	}
	public Tenger(ITargy t, IEpulet e, int hoSzint,int teherbiras, boolean hovihartolVedett, boolean medvetolVedett)throws IOException{
		super(t,e,hoSzint,teherbiras,hovihartolVedett,medvetolVedett);
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Lyuk letrejott\n");
		f.close();
	}

	/**
	 * A Tenger mezore lepteteseert felelos fuggveny
	 * @param sz: Szereplo
	 * @throws IOException
	 */
	public void ralep(IKarakter sz) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("A Szereplo tengerbe esett.\n");
		f.close();
		//a Tengeren egybol vizbeesik a szereplo
		sz.tesoTeVizbeEstel();
	}
}
