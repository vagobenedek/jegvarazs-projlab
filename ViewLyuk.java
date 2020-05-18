import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * A lyuk grafikus osztalya
 */
public class ViewLyuk extends ViewMezo{
    /**
     * az ososztaly DrawMezo felulirasa, ami kirajzolja a lyukat es hatteret
     * @param g :Graphics2D
     * @throws IOException
     */
    @Override
    public void DrawMezo(Graphics2D g) throws IOException {
        BufferedImage img = ImageIO.read(new File("images/lyuk(hatter).png"));
        g.drawImage(img, 0, 0, null);
        img = ImageIO.read(new File("images/lyuk.png"));
        g.drawImage(img, 0, 0, null);
    }
    /**
     * az ososztaly DrawJeg felulirasa, ami kirajzolja a jeget
     * @param g :Graphics2D
     * @throws IOException
     */
    @Override
    public void DrawJeg(Graphics2D g) {
        g.setColor(new Color(0,0,255,128));
        g.fillRect(0,0,50,50);
    }
    /**
     * az ososztaly DrawHo felulirasa, ami kirajzolja a havat
     * @param g :Graphics2D
     * @throws IOException
     */
    @Override
    public void DrawHo(Graphics2D g) throws IOException {
        BufferedImage img = ImageIO.read(new File("images/ho.png"));
        g.drawImage(img, 0, 0, null);
    }
}
