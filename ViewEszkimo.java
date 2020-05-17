import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ViewEszkimo extends ViewKarakter{
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

    @Override
    public void DrawTulajdonsagok(Graphics2D g) throws IOException{
        BufferedImage sarkkutato = ImageIO.read(new File("images/kijelolo.png"));
        g.drawImage(sarkkutato, 0, 0, null);
    }
}
