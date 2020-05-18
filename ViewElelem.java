import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Az elelem grafikus osztalya
 */
public class ViewElelem extends ViewTargy {
    /**
     * A targy kirajzolasaert felelos fuggveny
     * @param g graphics tipus, amire a rajzolas tortenik
     * @throws IOException
     */
    @Override
    public void DrawTargy(Graphics2D g) throws IOException {
        BufferedImage img = ImageIO.read(new File("images/elelem.png"));
        g.drawImage(img, 0, 0, null);
    }
}
