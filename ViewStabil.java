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

    public static void rajzol(Canvas c) throws IOException {
        BufferedImage stabil = null;
        stabil = ImageIO.read(new File("images/tenger.png"));
        BufferedImage finalStabil = stabil;
        c.getGraphics().drawImage(stabil, 0,0, null);
        Graphics g = c.getGraphics();
        g.drawImage(stabil, 20, 20, null);
        c.update(g);
    }

    public static JPanel DrawMezo(JPanel button) throws IOException {
        BufferedImage stabil = null;
        stabil = ImageIO.read(new File("images/tenger.png"));
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
    public void DrawJeg() {

    }

    @Override
    public void DrawHo() {

    }
}