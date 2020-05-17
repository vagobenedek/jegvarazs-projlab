import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ViewBuvarruha extends ViewTargy {
    @Override
    public void DrawTargy(Graphics2D g) throws IOException {
        BufferedImage buvar = ImageIO.read(new File("images/buvar.png"));
        g.drawImage(buvar, 0, 0, null);
    }
}
