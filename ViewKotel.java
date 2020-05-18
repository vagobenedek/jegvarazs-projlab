import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * a Kotel grafikus osztalya
 */
public class ViewKotel extends ViewTargy{
    /**
     * az ososztaly DrawTargy felulirasa, ami kirajzolja a kotelet
     * @param g :Graphics 2D
     * @throws IOException
     */
    @Override
    public void DrawTargy(Graphics2D g) throws IOException {
        BufferedImage img = ImageIO.read(new File("images/kotel.png"));
        g.drawImage(img, 0, 0, null);
    }
}
