import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ViewLyuk extends ViewMezo{
    @Override
    public void DrawMezo(Graphics2D g) throws IOException {
        BufferedImage img = ImageIO.read(new File("images/lyuk.png"));
        g.drawImage(img, 0, 0, null);
    }
    @Override
    public void DrawJeg(Graphics2D g) {
    }

    @Override
    public void DrawHo(Graphics2D g) throws IOException {
        BufferedImage img = ImageIO.read(new File("images/ho.png"));
        g.drawImage(img, 0, 0, null);
    }
}
