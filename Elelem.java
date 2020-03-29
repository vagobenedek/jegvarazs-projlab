

public class Elelem extends Eszkoz {
	public Elelem(){}
	public Elelem(String s){
		super(s);
	}
	@Override
	public void hasznal(Szereplo Sz) {
		System.out.println("\t>Elelem.hasznal()");
			Sz.etkezes();
		System.out.println("\t<Elelem.hasznal()");
	}
}
