import java.io.FileWriter;
import java.io.IOException;

public class TorekenyLapat extends Lapat {
	private int elettartam;
	
	public TorekenyLapat() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void hasznal(Szereplo sz) throws IOException {
		elettartam -= 1;
		if (elettartam <= 0){
		} else {
			sz.hoAsas(1);
		}
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Torekeny lapat hasznalata\n");
		f.close();
	}

	public void setVedelem(Mezo m) {
		
	}
}
