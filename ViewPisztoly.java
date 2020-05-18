import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * A torekenylapat grafikus osztalya
 */
public class ViewPisztoly extends ViewTargy{
    /**
     * az ososztaly DrawTargy felulirasa, ami kirajzolja a  pisztolyt
     * @param g :Graphics2D
     * @throws IOException
     */
    @Override
    public void DrawTargy(Graphics2D g) throws IOException {
        BufferedImage img = ImageIO.read(new File("images/pisztoly.png"));
        g.drawImage(img, 0, 0, null);
    }
}
