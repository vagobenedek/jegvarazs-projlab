import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.File;
import java.io.IOException;

public class ViewTorekenyLapat extends ViewTargy{
    @Override
    public void DrawTargy(Graphics2D g) throws IOException {
        BufferedImage torekenylapat = ImageIO.read(new File("images/torekenylapat.png"));
        g.drawImage(torekenylapat, 0, 0, null);

    }
}
