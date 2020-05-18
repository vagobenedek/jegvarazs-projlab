import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * A sator grafikus osztalya
 */
public class ViewSator extends ViewEpulet {

    /**
     *az ososztaly DrawTargy felulirasa, ami kirajzolja a satrat( a szereplo tulajdonsagainal)
     * @param g :Graphics2D
     * @throws IOException
     */
    @Override
    public void DrawTargy(Graphics2D g) throws IOException {
        BufferedImage sator = ImageIO.read(new File("images/sator.png"));
        g.drawImage(sator, 0, 0, null);
    }
    //az ososztaly DrawEpulet felulirasa, ami kirajzolja a satrat
    /**
     * az ososztaly DrawTargy felulirasa, ami kirajzolja a  lapatot
     * @param g :Graphics2D
     * @throws IOException
     */
    @Override
    public void DrawEpulet(Graphics2D g) throws IOException {
        BufferedImage sator = ImageIO.read(new File("images/sator.png"));
        g.drawImage(sator, 0, 0, null);
    }
}
