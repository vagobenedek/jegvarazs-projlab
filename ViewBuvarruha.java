import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * A buvarruha grafikus osztalya
 */
public class ViewBuvarruha extends ViewTargy {
    /**
     * A targy kirajzolasaert felelos fuggveny
     * @param g graphics tipus, amire a rajzolas tortenik
     * @throws IOException
     */
    @Override
    public void DrawTargy(Graphics2D g) throws IOException {
        BufferedImage buvar = ImageIO.read(new File("images/buvarruha.png"));
        g.drawImage(buvar, 0, 0, null);
    }
}
