import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ViewLyuk extends ViewMezo{
    @Override
    public void DrawMezo(Graphics2D g) throws IOException {
        BufferedImage img = ImageIO.read(new File("images/lyuk(hatter).png"));
        g.drawImage(img, 0, 0, null);
        img = ImageIO.read(new File("images/lyuk.png"));
        g.drawImage(img, 0, 0, null);
    }
    @Override
    public void DrawJeg(Graphics2D g) {
        g.setColor(new Color(0,0,255,128));
        g.fillRect(0,0,50,50);
    }

    @Override
    public void DrawHo(Graphics2D g) throws IOException {
        BufferedImage img = ImageIO.read(new File("images/ho.png"));
        g.drawImage(img, 0, 0, null);
    }
}
