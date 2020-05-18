import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Az eszkimot reprezentalo gafikus osztaly
 */
public class ViewEszkimo extends ViewKarakter{
    /**
     * A karakter kirajzolasaert felelos fuggveny
     * @param g graphics tipus, amire a rajzolas tortenik
     * @throws IOException
     */
    @Override
    public void DrawIKarakter(Graphics2D g) throws IOException {
        BufferedImage img = ImageIO.read(new File("images/eszkimo.png"));
        g.drawImage(img, 0, 0, null);
    }
/*
    public static JPanel DrawEszkimo(JPanel button) throws IOException {
        BufferedImage stabil = null;
        stabil = ImageIO.read(new File("images/eszkimo.png"));
        BufferedImage finalStabil = stabil;

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(finalStabil, 0, 0, null);
            }
        };
        return panel;
    }*/


}
