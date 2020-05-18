import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class ViewKarakter implements IDrawable{

    public void DrawMezo(Graphics2D g){
    }

    @Override
    public void DrawTargy(Graphics2D g) {}

    @Override
    public void DrawJeg(Graphics2D g) {}

    @Override
    public void DrawHo(Graphics2D g) {}

    @Override
    abstract public void DrawIKarakter(Graphics2D g) throws IOException;

    @Override
    public void DrawEpulet(Graphics2D g) {}

    @Override
    public void DrawTulajdonsagok(Graphics2D g,Graphics2D g2,Integer lepesszam,Integer teherbiras, String eszkoz,String alkatresz, Integer testho) throws IOException{ BufferedImage sarkkutato = ImageIO.read(new File("images/kijelolo.png"));
        g.drawImage(sarkkutato, 0, 0, null);
        g2.drawRect(0,0,20,20);
        g2.drawString(lepesszam.toString(),8,15);
        g2.drawRect(20,0,20,20);
        g2.drawString(testho.toString(),28,15);
        if (teherbiras!=-1){
            g2.drawRect(40,0,20,20);
            if (teherbiras == (int)Double.POSITIVE_INFINITY){
                g2.drawOval(46,8,5,5);
                g2.drawOval(51,8,5,5);
            }
            else
            g2.drawString(teherbiras.toString(),48,15);
        }
        if(eszkoz.equals("Lapat")){
            g2.drawRect(60,0,20,20);
            BufferedImage img = ImageIO.read(new File("images/lapat.png"));
            g2.drawImage(img, 60, 0, null);
        }
        else if(eszkoz.equals("Torekenylapat")){
            g2.drawRect(60,0,20,20);
            BufferedImage img = ImageIO.read(new File("images/torekenylapat.png"));
            g2.drawImage(img, 60, 0, null);
        }
        else if(eszkoz.equals("Kotel")){
            g2.drawRect(60,0,20,20);
            BufferedImage img = ImageIO.read(new File("images/kotel.png"));
            g2.drawImage(img, 60, 0, null);
        }
        else if(eszkoz.equals("Buvarruha")){
            g2.drawRect(60,0,20,20);
            BufferedImage img = ImageIO.read(new File("images/buvarruha.png"));
            g2.drawImage(img, 60, 0, null);
        }
        else if(eszkoz.equals("Elelem")){
            g2.drawRect(60,0,20,20);
            BufferedImage img = ImageIO.read(new File("images/elelem.png"));
            g2.drawImage(img, 60, 0, null);
        }
        else if(eszkoz.equals("Sator")){
            g2.drawRect(60,0,20,20);
            BufferedImage img = ImageIO.read(new File("images/sator.png"));
            g2.drawImage(img, 60, -25, null);
        }
        if(alkatresz.equals("Pisztoly")) {
            g2.drawRect(80,0,20,20);
            BufferedImage img = ImageIO.read(new File("images/pisztoly.png"));
            g2.drawImage(img, 80, 0, null);
        }
        else if(alkatresz.equals("Patron")){
            g2.drawRect(80,0,20,20);
            BufferedImage img = ImageIO.read(new File("images/patron.png"));
            g2.drawImage(img, 80, 0, null);
        }
        else if(alkatresz.equals("Jelzofeny")){
            g2.drawRect(80,0,20,20);
            BufferedImage img = ImageIO.read(new File("images/jelzofeny.png"));
            g2.drawImage(img, 80, 0, null);
        }
    }
}
