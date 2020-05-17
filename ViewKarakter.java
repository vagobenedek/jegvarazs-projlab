import javax.swing.*;

public abstract class ViewKarakter implements IDrawable{

    public static JPanel DrawMezo(){
        return null;
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
