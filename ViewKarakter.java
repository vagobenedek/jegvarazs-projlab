import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A karaktereket reprezentáló grafikus abstract osztaly
 */
public abstract class ViewKarakter implements IDrawable{
    /**
     * A mezo kirajzolasaert felelos fuggveny
     * @param g graphics tipus, amire a rajzolas tortenik
     * @throws IOException
     */
    public void DrawMezo(Graphics2D g){
    }

    /**
     * A targy kirajzolasaert felelos fuggveny
     * @param g graphics tipus, amire a rajzolas tortenik
     * @throws IOException
     */
    @Override
    public void DrawTargy(Graphics2D g) {}

    /**
     * A mezon leve feltoretlen jeg kirajzolasaert felelos fuggveny
     * @param g graphics tipus, amire a rajzolas tortenik
     * @throws IOException
     */
    @Override
    public void DrawJeg(Graphics2D g) {}
    /**
     * A mezot borito ho kirajzolasaert felelos fuggveny
     * @param g graphics tipus, amire a rajzolas tortenik
     * @throws IOException
     */
    @Override
    public void DrawHo(Graphics2D g) {}

    /**
     * A mezon talalhato karakterek kirajzolasaert felelos fuggveny
     * @param g graphics tipus, amire a rajzolas tortenik
     * @throws IOException
     */
    @Override
    abstract public void DrawIKarakter(Graphics2D g) throws IOException;

    /**
     * A mezon levo epuletek kirajzolasaert felelos fuggveny
     * @param g graphics tipus, amire a rajzolas tortenik
     * @throws IOException
     */
    @Override
    public void DrawEpulet(Graphics2D g) {}

    /**
     * A karakter testhojenek, hatralevo lepeseinek, nala levo targyak
     * kirajzolasaert felelos fuggveny
     * @param g graphics tipus, amire a rajzolas tortenik
     * @throws IOException
     */
    @Override
    public void DrawTulajdonsagok(Graphics2D g,Graphics2D g2,Integer lepesszam,Integer teherbiras, String eszkoz,String alkatresz, Integer testho) throws IOException{
        //betoltjuk az aktualisan lepo szereplo kijelolesere szant kijelolo kepet
        BufferedImage kijelol = ImageIO.read(new File("images/kijelolo.png"));
        //kirajzoljuk arra a mezore, amin az aktuali szereplo all
        g.drawImage(kijelol, 0, 0, null);
        //kirajzolunk ket negyzetet, amikben feltuntetjuk a hatralevo lepesszamot, illetve a karakter testhojet
        g2.drawRect(0,0,20,20);
        g2.drawString(lepesszam.toString(),8,15);
        g2.drawRect(20,0,20,20);
        g2.drawString(testho.toString(),28,15);
        //amennyiben a karakter kepesseghasznalat soran lekerdezte egy mezo teherbirasat, azt is kirajzoljuk a kepernyore
        if (teherbiras!=-1){
            g2.drawRect(40,0,20,20);
            //ha egy stabil mezot kerdeztunk le, aminek vegtelen a teherbirasa, akkor egy vegtelen jelet rajzolunk a dobozba
            if (teherbiras == (int)Double.POSITIVE_INFINITY){
                g2.drawOval(46,8,5,5);
                g2.drawOval(51,8,5,5);
            }
            //ha a teherbiras egy konret szam, akkor azt irjuk ki
            else
            g2.drawString(teherbiras.toString(),48,15);
        }
        //amennyiben valamilyen eszkoz talalhato a szereplonel, azt is kirajzoljuk a kepernyore egy dobozkaban
        //ha az eszkoz lapat, akkor betoltjuk a lapat kepet, es azt rajzoljuk ki
        if(eszkoz.equals("Lapat")){
            g2.drawRect(60,0,20,20);
            BufferedImage img = ImageIO.read(new File("images/lapat.png"));
            g2.drawImage(img, 60, 0, null);
        }
        //ha az eszkoz torekenylapat, akkor betoltjuk a torekenylapat kepet, es azt rajzoljuk ki
        else if(eszkoz.equals("Torekenylapat")){
            g2.drawRect(60,0,20,20);
            BufferedImage img = ImageIO.read(new File("images/torekenylapat.png"));
            g2.drawImage(img, 60, 0, null);
        }
        //ha az eszkoz kotel, akkor betoltjuk a kotel kepet, es azt rajzoljuk ki
        else if(eszkoz.equals("Kotel")){
            g2.drawRect(60,0,20,20);
            BufferedImage img = ImageIO.read(new File("images/kotel.png"));
            g2.drawImage(img, 60, 0, null);
        }
        //ha az eszkoz buvarruha, akkor betoltjuk a buvarruha kepet, es azt rajzoljuk ki
        else if(eszkoz.equals("Buvarruha")){
            g2.drawRect(60,0,20,20);
            BufferedImage img = ImageIO.read(new File("images/buvarruha.png"));
            g2.drawImage(img, 60, 0, null);
        }
        //ha az eszkoz elelem, akkor betoltjuk a elelem kepet, es azt rajzoljuk ki
        else if(eszkoz.equals("Elelem")){
            g2.drawRect(60,0,20,20);
            BufferedImage img = ImageIO.read(new File("images/elelem.png"));
            g2.drawImage(img, 60, 0, null);
        }
        //ha az eszkoz sator, akkor betoltjuk a sator kepet, es azt rajzoljuk ki
        else if(eszkoz.equals("Sator")){
            g2.drawRect(60,0,20,20);
            BufferedImage img = ImageIO.read(new File("images/sator.png"));
            g2.drawImage(img, 60, -25, null);
        }
        //ha az eszkoz pisztoly, akkor betoltjuk a pisztoly kepet, es azt rajzoljuk ki
        if(alkatresz.equals("Pisztoly")) {
            g2.drawRect(80,0,20,20);
            BufferedImage img = ImageIO.read(new File("images/pisztoly.png"));
            g2.drawImage(img, 80, 0, null);
        }
        //ha az eszkoz patron, akkor betoltjuk a patron kepet, es azt rajzoljuk ki
        else if(alkatresz.equals("Patron")){
            g2.drawRect(80,0,20,20);
            BufferedImage img = ImageIO.read(new File("images/patron.png"));
            g2.drawImage(img, 80, 0, null);
        }
        //ha az eszkoz jelzofeny, akkor betoltjuk a jelzofeny kepet, es azt rajzoljuk ki
        else if(alkatresz.equals("Jelzofeny")){
            g2.drawRect(80,0,20,20);
            BufferedImage img = ImageIO.read(new File("images/jelzofeny.png"));
            g2.drawImage(img, 80, 0, null);
        }
    }
}
