import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * A sarkkutato grafikus osztalya
 */
public class ViewSarkkutato extends ViewKarakter{
    /**
     * az ososztaly DrawIKarakter felulirasa, ami kirajzolja a  Sarkkutatot
     * @param g :Graphics2D
     * @throws IOException
     */
    @Override
    public void DrawIKarakter(Graphics2D g) throws IOException {
        BufferedImage sarkkutato = ImageIO.read(new File("images/sarkkutato.png"));
        g.drawImage(sarkkutato, 0, 0, null);
    }
}
