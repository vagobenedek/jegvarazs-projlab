

public class Lapat extends Eszkoz {
	public Lapat(){}
	@Override
	public void hasznal(Szereplo Sz) {
		System.out.println("\t>Lapat.hasznal()");
		//Meghívjuk a hóÁsás függvényt
		Sz.hoAsas();
		System.out.println("\t<Lapat.hasznal()");
	}
}
