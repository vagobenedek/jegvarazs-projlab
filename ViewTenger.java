import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ViewTenger extends ViewMezo {

    @Override
    public void DrawMezo(Graphics2D g) throws IOException {
        BufferedImage tenger = ImageIO.read(new File("images/tenger.png"));
        g.drawImage(tenger, 0, 0, null);
    }

    @Override
    public void DrawJeg(Graphics2D g) {

    }

    @Override
    public void DrawHo(Graphics2D g) {

    }
}
