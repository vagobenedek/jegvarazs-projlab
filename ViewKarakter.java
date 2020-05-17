import javax.swing.*;
import java.awt.*;

public abstract class ViewKarakter implements IDrawable{

    public void DrawMezo(Graphics g, Integer id){
    }

    @Override
    public void DrawTargy() {}

    @Override
    public void DrawJeg() {}

    @Override
    public void DrawHo() {}

    @Override
    abstract public void DrawIKarakter();

    @Override
    public void DrawEpulet() {}

    @Override
    abstract public void DrawTulajdonsagok();
}
