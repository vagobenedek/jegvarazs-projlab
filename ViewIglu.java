import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Az iglut reprezentalo grafikus osztaly
 */
public class ViewIglu extends ViewEpulet{
    /**
     * @param g
     * @throws IOException
     */
    @Override
    public void DrawTargy(Graphics2D g) throws IOException {

    }
    /**
     * A epulet kirajzolasaert felelos fuggveny
     * @param g graphics tipus, amire a rajzolas tortenik
     * @throws IOException
     */
    @Override
    public void DrawEpulet(Graphics2D g) throws IOException {
        BufferedImage img = ImageIO.read(new File("images/iglu.png"));
        g.drawImage(img, 0, 0, null);
    }
}
