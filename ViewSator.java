import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ViewSator extends ViewEpulet {
    @Override
    public void DrawTargy(Graphics2D g) throws IOException {
        BufferedImage stabil = ImageIO.read(new File("images/sator.png"));
        g.drawImage(stabil, 0, 0, null);
    }

    @Override
    public void DrawEpulet(Graphics2D g) throws IOException {
        BufferedImage sator = ImageIO.read(new File("images/sator.png"));
        g.drawImage(sator, 0, 0, null);
    }
}
