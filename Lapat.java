

public class Lapat extends Eszkoz {
	public Lapat(){
		super();
	}
	@Override
	public void hasznal(Szereplo Sz) {
		System.out.println("\t>Lapat.hasznal()");
		//Meghivjuk a hoAsas fuggvenyt
		Sz.hoAsas();
		System.out.println("\t<Lapat.hasznal()");
	}
}
