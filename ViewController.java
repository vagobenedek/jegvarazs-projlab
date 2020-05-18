import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * a jatekhoz tartozo ablakert felelos osztaly
 */
public class ViewController extends JFrame{
	/**
	 * a palya meretet tarolja
	 */
	private int meret = 10;
	/**
	 * az eszkimok szamat tarolja
	 */
	private int eSzam = 2;
	/**
	 * a sarkkutatok szamat tarolja
	 */
	private int sSzam = 1;
	/**
	 * a nyertel tagvaltozo erteket tarolja
	 */
	private int nyertel = 0;
	/**
	 * a jatekhoz tartozo menu komponens
	 */
	ViewMenu vm;

	/**
	 * az ablak letrehozasaert felelos kostruktor
	 * @throws IOException
	 */
	public ViewController() {
		//beallitjuk a default bezarasi lehetoseget az ablaknak
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//beallitjuk az ablak cimet
		setTitle("Jegvarazs");
		//letrehozzuk a menut
		vm = new ViewMenu(this);
		//hozzaadjuk az ablakhoz a menu komponenst
		add(vm);
		//lekerjuk a felhasznalo kepernyo meretet
		Dimension location = Toolkit.getDefaultToolkit().getScreenSize();
		//beallitjuk a helyet az ablaknak a kepernyo meretehez
		this.setLocation(location.width/2-this.getWidth()/2,location.height/2-this.getHeight()/2);
		//lathatova tesszuk az ablakot
		this.setVisible(true);
	}

	/**
	 * main metodus a jatek kezdete
	 * @param args
	 */
    public static void main(String args[]){
    	ViewController vc = new ViewController();
    }

	/**
	 * a ViewJatek komponenst letrehozasaert es megjeleniteseert felel
	 * @throws IOException
	 */
	public void CreateUjJatek() throws IOException {
		//letrehozzuk a jatek komponenst
		new ViewJatek(this);
		//nem lathatova tesszuk a menu komponenst
		vm.setVisible(false);
		//beallitjuk az ablak meretet a mezok meretehez igazitva
        this.setSize(getMeret()*50+15, getMeret()*50+60);
        //lekerjuk a kepernyo meretet
		Dimension location = Toolkit.getDefaultToolkit().getScreenSize();
		//beallitjuk az ablak elhelyezkedeset kozepre
		this.setLocation(location.width/2-this.getWidth()/2,location.height/2-this.getHeight()/2);
		//eltavolitjuk a menu komponenst az ablaktol
        this.remove(vm);
    }

	/**
	 * beallitja 1 ertekre a nyertel tagvaltozot
	 */
	public void Gyoztel()
	{
		nyertel = 1;
	}
	/**
	 * beallitja 2 ertekre a nyertel tagvaltozot
	 */
	public void Vesztettel() {
		nyertel = 2;
	}

	/**
	 * felulirja az ososztaly paintComponents metodusat
	 * @param g :Graphics
	 */
	@Override
	public void paintComponents(Graphics g){
		this.paint(g);
	}

	/**
	 * az ososztaly paint metodusanak felulirasa
	 * @param g
	 */
	@Override
	public void paint(Graphics g){
		super.paint(g);
		//uj grafikus elem letrehozasa
		Graphics g2 = g.create();
		//a grafikus elem origojanak eltolasa
		g2.translate(this.getWidth()/2-this.getWidth()/8,this.getHeight()/2-15);
		//beallitjuk a betutipust es abetumeretet
		g2.setFont(new Font(Font.SANS_SERIF,Font.ROMAN_BASELINE,30));
		//ha nyertel egyenlo 1
		if(nyertel == 1){
			//akkor a jateknak vege
			g2.drawString("Game over",0,0);
			//es kiirjuk hogy nyerte jatekos
			g2.drawString("You Won!",0,35);
		}
		//ha a nyertel kettovel egyenlo
		else if (nyertel == 2){
			//akkor a jateknak vege
			g2.drawString("Game over",0,0);
			//es kiirjuk hogy vesztett jatekos
			g2.drawString("You Lose!",0,35);
		}
	}

	/**
	 * visszaadja a meret tagvaltozot
	 * @return :int
	 */
	public int getMeret() {
		return meret;
	}

	/**
	 * a parameterkent kapott ertekre allitja a meret tagvaltozot
	 * @param meret :int
	 */
	public void setMeret(int meret) {
		this.meret = meret;
	}

	/**
	 * visszaadja az eSzam tagvaltozot
	 * @return
	 */
	public int getESzam() {
		return eSzam;
	}

	/**
	 * a parameterkent kapott ertekre allitja a eSzam tagvaltozot
	 * @param eSzam
	 */
	public void setESzam(int eSzam) {
		this.eSzam = eSzam;
	}

	/**
	 *  visszaadja az sSzam tagvaltozot
	 * @return
	 */
	public int getSSzam() {
		return sSzam;
	}

	/**
	 * a parameterkent kapott ertekre allitja a sSzam tagvaltozot
	 * @param sSzam
	 */
	public void setSSzam(int sSzam) {
		this.sSzam = sSzam;
	}

}
