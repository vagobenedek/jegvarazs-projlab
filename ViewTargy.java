import javax.swing.*;
import java.awt.*;

public abstract class ViewTargy implements IDrawable{
    public void DrawMezo(Graphics2D g, Integer id){
    }

    @Override
    abstract public void DrawTargy();

    @Override
    public void DrawJeg() {}

    @Override
    public void DrawHo() {}

    @Override
    public void DrawIKarakter() {}

    @Override
    public void DrawEpulet() {}

    @Override
    public void DrawTulajdonsagok() {}
}
