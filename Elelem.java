

public class Elelem extends Eszkoz {
	public Elelem(){
		super();
	}
	@Override
	public void hasznal(Szereplo Sz) {
		System.out.println("\t>Elelem.hasznal()");
			Sz.etkezes();
		System.out.println("\t<Elelem.hasznal()");
	}
}
