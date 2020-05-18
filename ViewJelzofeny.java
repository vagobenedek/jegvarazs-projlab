import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A jelzofeny reprezentalasara szolgalo graifkus osztaly
 */
public class ViewJelzofeny extends ViewTargy{
    /**
     * A targy kirajzolasaert felelos fuggveny
     * @param g graphics tipus, amire a rajzolas tortenik
     * @throws IOException
     */
    @Override
    public void DrawTargy(Graphics2D g) throws IOException {
        BufferedImage img = ImageIO.read(new File("images/jelzofeny.png"));
        g.drawImage(img, 0, 0, null);
    }
}
