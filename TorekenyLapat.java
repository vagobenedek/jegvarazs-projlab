import java.io.FileWriter;
import java.io.IOException;

public class TorekenyLapat extends Lapat {
	private int elettartam;
	
	public TorekenyLapat() throws IOException {
		super();
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Torekeny lapat letrejott\n");
		f.close();
	}
	
	@Override
	public void hasznal(Szereplo sz) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Torekeny lapat hasznalata\n");
		f.close();
		
		elettartam -= 1;
		if (elettartam < 0){
		} else {
			sz.hoAsas(1);
		}
	}

	public void setVedelem(Mezo m) {
		
	}
}
