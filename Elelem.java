

public class Elelem extends Eszkoz {
	public Elelem(){
		System.out.println(">Elelem konstruktor");
		System.out.println("<Elelem konstruktor");
	}
	@Override
	public void hasznal(Szereplo Sz) {
		System.out.println("\t>Elelem.hasznal()");
			Sz.etkezes();
		System.out.println("\t<Elelem.hasznal()");
	}
}
