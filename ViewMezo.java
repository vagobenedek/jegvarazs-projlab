import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public abstract class ViewMezo implements IDrawable{

    @Override
    public abstract void DrawMezo(Graphics g, Integer id) throws IOException;
    /*
    @Override
    public void DrawMezo() throws IOException  {}
    */
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
