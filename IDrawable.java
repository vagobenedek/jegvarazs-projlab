import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public interface IDrawable {
    //JPanel DrawMezo() throws IOException;
    public void DrawMezo(Graphics g, Integer id) throws IOException;
    /*
    void DrawMezo() throws IOException;
     */
    void DrawTargy();
    void DrawJeg();
    void DrawHo();
    void DrawIKarakter();
    void DrawEpulet();
    void DrawTulajdonsagok();
}
