import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public interface IDrawable {
    //JPanel DrawMezo() throws IOException;
    static JPanel DrawMezo(JPanel button) throws IOException {
        return null;
    }

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
