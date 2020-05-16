import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ViewStabil extends ViewMezo{
    @Override
    public void DrawMezo() throws IOException {
        BufferedImage mezo = ImageIO.read(ViewJatek.class.getResource("images/stabil-instabil.png"));
        JLabel picLabel = new JLabel(new ImageIcon(mezo));
    }

    @Override
    public void DrawJeg() {

    }

    @Override
    public void DrawHo() {

    }
}
