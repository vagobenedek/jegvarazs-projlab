import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public abstract class ViewKarakter implements IDrawable{

    public void DrawMezo(Graphics2D g){
    }

    @Override
    public void DrawTargy(Graphics2D g) {}

    @Override
    public void DrawJeg(Graphics2D g) {}

    @Override
    public void DrawHo(Graphics2D g) {}

    @Override
    abstract public void DrawIKarakter(Graphics2D g) throws IOException;

    @Override
    public void DrawEpulet(Graphics2D g) {}

    @Override
    abstract public void DrawTulajdonsagok(Graphics2D g) throws IOException;
}
