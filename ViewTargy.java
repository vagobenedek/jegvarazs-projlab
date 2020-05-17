import javax.swing.*;

public abstract class ViewTargy implements IDrawable{
    public static JPanel DrawMezo(){
        return null;
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
