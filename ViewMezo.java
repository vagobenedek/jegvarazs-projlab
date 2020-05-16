import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public abstract class ViewMezo implements IDrawable{
    @Override
    abstract public void DrawMezo() throws IOException;
    @Override
    public void DrawTargy() {}
    @Override
    abstract public void DrawJeg();
    @Override
    abstract public void DrawHo();
    @Override
    public void DrawIKarakter() {}
    @Override
    public void DrawEpulet() {}
    @Override
    public void DrawTulajdonsagok() {}
}
