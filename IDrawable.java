import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public interface IDrawable {
    //JPanel DrawMezo() throws IOException;
    void DrawMezo(Graphics2D g) throws IOException;
    /*
    void DrawMezo() throws IOException;
     */
    void DrawTargy(Graphics2D g) throws IOException;
    void DrawJeg(Graphics2D g);
    void DrawHo(Graphics2D g) throws IOException;
    void DrawIKarakter(Graphics2D g) throws IOException;
    void DrawEpulet(Graphics2D g) throws IOException;
    void DrawTulajdonsagok(Graphics2D g,Graphics2D g2,Integer lepesszam, String eszkoz,String alkatresz, Integer testho)throws IOException;
}
