import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Az instabil mezot reprezentalo grafikus osztaly
 */
public class ViewInstabil extends ViewMezo {
    /**
     * A mezo kirajzolasaert felelos fuggveny
     * @param g graphics tipus, amire a rajzolas tortenik
     * @throws IOException
     */
    @Override
    public void DrawMezo(Graphics2D g) throws IOException {

        BufferedImage instabil = ImageIO.read(new File("images/stabil-instabil.png"));
        g.drawImage(instabil, 0, 0, null);
    }
    /**
     * A mezon talalhato feltoretlen jeg kirajzolasaert felelos fuggveny
     * @param g graphics tipus, amire a rajzolas tortenik
     * @throws IOException
     */
    @Override
    public void DrawJeg(Graphics2D g){
        g.setColor(new Color(0,0,255,128));
        g.fillRect(0,0,50,50);
    }
    /**
     * A mezot borito ho kirajzolasaert felelos fuggveny
     * @param g graphics tipus, amire a rajzolas tortenik
     * @throws IOException
     */
    @Override
    public void DrawHo(Graphics2D g) throws IOException{
        BufferedImage ho = ImageIO.read(new File("images/ho.png"));
        g.drawImage(ho, 0, 0, null);
    }
}
