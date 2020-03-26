import java.io.IOException;

public abstract class Eszkoz extends Targy {
	public Eszkoz(){}
	@Override
	public void felvesz(Szereplo Sz) {
	}
	
	abstract public void hasznal(Szereplo sz) throws IOException;
}
