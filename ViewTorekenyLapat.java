import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.File;
import java.io.IOException;

/**
 * A torekenylapat grafikus osztalya
 */
public class ViewTorekenyLapat extends ViewTargy{
    /**
     * az ososztaly DrawTargy felulirasa, ami kirajzolja a torekeny lapatot
     * @param g :Graphics2D
     * @throws IOException
     */
    @Override
    public void DrawTargy(Graphics2D g) throws IOException {
        BufferedImage torekenylapat = ImageIO.read(new File("images/torekenylapat.png"));
        g.drawImage(torekenylapat, 0, 0, null);

    }
}
