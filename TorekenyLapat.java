import java.io.FileWriter;
import java.io.IOException;

public class TorekenyLapat extends Lapat {
	private int elettartam;
	
	public TorekenyLapat() throws IOException {
		super();
		this.elettartam = 3;
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Torekeny lapat letrejott\n");
		f.close();
	}
	@Override
	public void hasznal(Szereplo sz) throws IOException {
		FileWriter f = new FileWriter("./kimenet.txt", true);
		f.append("Torekeny lapat hasznalata\n");
		f.close();
		
		
		if (elettartam <= 0){
			sz.setEszkoz(null);
		} else {
			sz.hoAsas(1);
			elettartam--;
		}
	}

	public void setVedelem(Mezo m) {
		
	}
}
