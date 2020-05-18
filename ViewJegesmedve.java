import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A jegesmedvet reprezentalo grafikus osztaly
 */
public class ViewJegesmedve extends ViewKarakter{
    /**
     * A karakter kirajzolasaert felelos fuggveny
     * @param g graphics tipus, amire a rajzolas tortenik
     * @throws IOException
     */
    @Override
    public void DrawIKarakter(Graphics2D g) throws IOException {
        BufferedImage img = ImageIO.read(new File("images/jegesmedve.png"));
        g.drawImage(img, 0, 0, null);
    }

    @Override
    public void DrawTulajdonsagok(Graphics2D g,Graphics2D g2, Integer lepesszam,Integer teherbiras, String eszkoz, String alkatresz, Integer testho) throws IOException {

    }
}
