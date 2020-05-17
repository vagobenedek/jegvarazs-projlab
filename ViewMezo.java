import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public abstract class ViewMezo implements IDrawable{

    @Override
    public abstract void DrawMezo(Graphics2D g) throws IOException;
    /*
    @Override
    public void DrawMezo() throws IOException  {}
    */
    @Override
    public void DrawTargy(Graphics2D g) {}
    @Override
    abstract public void DrawJeg(Graphics2D g);
    @Override
    abstract public void DrawHo(Graphics2D g);
    @Override
    public void DrawIKarakter(Graphics2D g) {}
    @Override
    public void DrawEpulet(Graphics2D g) {}
    @Override
    public void DrawTulajdonsagok(Graphics2D g) {}
}
