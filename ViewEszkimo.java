import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ViewEszkimo extends ViewKarakter{
    @Override
    public void DrawIKarakter() {

    }

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
    }

    @Override
    public void DrawTulajdonsagok() {

    }
}