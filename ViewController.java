import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewController extends JFrame{
	private int meret = 10;
	private int eSzam = 2;
	private int sSzam = 1;
	private int nyertel = 0;
	ViewMenu vm;


	public ViewController() throws IOException {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Jegvarazs");
		vm = new ViewMenu(this);
		add(vm);
		Dimension location = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(location.width/2-this.getWidth()/2,location.height/2-this.getHeight()/2);
		//CreateUjJatek();
	}
	
    public static void main(String args[]){
        try {
        	ViewController vc = new ViewController();
        	vc.setVisible(true);
            //CreateUjJatek();
        }
        catch (Exception e){}
    }
    public void CreateUjJatek() throws IOException {
		new ViewJatek(this);
		vm.setVisible(false);
        this.setSize(getMeret()*50+15, getMeret()*50+60);
		Dimension location = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(location.width/2-this.getWidth()/2,location.height/2-this.getHeight()/2);
        this.remove(vm);
    }
	public void Gyoztel()
	{
		nyertel = 1;
	}
	public void Vesztettel() {
		nyertel = 2;
	}
	@Override
	public void paintComponents(Graphics g){
		/*this.paintAll(g);
		this.update(g);*/
		this.paint(g);
		//super.paintComponents(g);
	}
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Graphics g2 = g.create();
		g2.translate(this.getWidth()/2-this.getWidth()/8,this.getHeight()/2-15);
		g2.setFont(new Font(Font.SANS_SERIF,Font.ROMAN_BASELINE,30));
		if(nyertel == 1){
			g2.drawString("Game over",0,0);
			g2.drawString("You Won!",0,35);
		}
		else if (nyertel == 2){
			g2.drawString("Game over",0,0);
			g2.drawString("You Lose!",0,35);
		}
	}

	public int getMeret() {
		return meret;
	}

	public void setMeret(int meret) {
		this.meret = meret;
	}

	public int getESzam() {
		return eSzam;
	}

	public void setESzam(int eSzam) {
		this.eSzam = eSzam;
	}

	public int getSSzam() {
		return sSzam;
	}

	public void setSSzam(int sSzam) {
		this.sSzam = sSzam;
	}

}
