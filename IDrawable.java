import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public interface IDrawable {
    void DrawMezo() throws IOException;
    void DrawTargy();
    void DrawJeg();
    void DrawHo();
    void DrawIKarakter();
    void DrawEpulet();
    void DrawTulajdonsagok(Szereplo sz);
}
