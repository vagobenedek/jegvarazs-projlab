import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ViewStabil extends ViewMezo{
    public ViewStabil(){}


    /*
    @Override
    public void DrawMezo() throws IOException {
        BufferedImage stabil = null;
        stabil = ImageIO.read(new File("images/tenger.png"));
        BufferedImage finalStabil = stabil;

        JPanel panel = new JPanel(){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(finalStabil, 0, 0, null);
            }
        };
    }
*/
    /*
        @Override
        public void DrawMezo(Graphics g) throws IOException {
            BufferedImage stabil = null;
            stabil = ImageIO.read(new File("images/stabil-instabil.png"));
            BufferedImage finalStabil = stabil;

            g.drawImage(finalStabil, 0, 0, null);
        }
    */
    @Override
    public void DrawMezo(Graphics2D g) throws IOException {
        BufferedImage stabil = ImageIO.read(new File("images/stabil-instabil.png"));
        g.drawImage(stabil, 0, 0, null);
    }

    @Override
    public void DrawJeg(Graphics2D g) {
    }

    @Override
    public void DrawHo(Graphics2D g) {

    }
}
