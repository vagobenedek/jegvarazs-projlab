import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public abstract class ViewTargy implements IDrawable{
    public void DrawMezo(Graphics2D g){
    }

    @Override
    public abstract void DrawTargy(Graphics2D g) throws IOException;

    @Override
    public void DrawJeg(Graphics2D g) {}

    @Override
    public void DrawHo(Graphics2D g) {}

    @Override
    public void DrawIKarakter(Graphics2D g) {}

    @Override
    public void DrawEpulet(Graphics2D g) throws IOException {}

    @Override
    public void DrawTulajdonsagok(Graphics2D g,Graphics2D g2,Integer lepesszam,Integer teherbiras, String eszkoz,String alkatresz, Integer testho) throws IOException{}
}
