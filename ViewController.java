import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ViewController extends JFrame{
	private int meret = 10;
	private int eSzam = 2;
	private int sSzam = 1;
	
	public ViewController() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Jegvarazs");
		
		ViewMenu vm = new ViewMenu(this);
		add(vm);
	}
	
    public static void main(String args[]){
        try {
        	ViewController vc = new ViewController();
        	vc.setVisible(true);
            //CreateUjJatek();
        }
        catch (Exception e){}
    }

    public static void CreateUjJatek() throws IOException {
        new ViewJatek();
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
