import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ViewSarkkutato extends ViewKarakter{
    @Override
    public void DrawIKarakter(Graphics2D g) throws IOException {
        BufferedImage sarkkutato = ImageIO.read(new File("images/sarkkutato.png"));
        g.drawImage(sarkkutato, 0, 0, null);
    }
}
