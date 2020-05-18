import javax.swing.*;
import java.awt.*;
import java.io.IOException;
/**
 * A mezo grafikus ososztalya
 */
public abstract class ViewMezo implements IDrawable{
    /**
     * az interfesz implementalasa es absztrakta teszzuk, hogy a leszarmazott definialhassa
     * @param g :Graphics2D
     * @throws IOException
     */
    @Override
    public abstract void DrawMezo(Graphics2D g) throws IOException;
    /**
     * az interfesz implementalasa
     * @param g :Graphics2D
     * @throws IOException
     */
    @Override
    public void DrawTargy(Graphics2D g) {}
    /**
     * az interfesz implementalasa es absztrakta teszzuk, hogy a leszarmazott definialhassa
     * @param g :Graphics2D
     * @throws IOException
     */
    @Override
    abstract public void DrawJeg(Graphics2D g);
    /**
     * az interfesz implementalasa es absztrakta teszzuk, hogy a leszarmazott definialhassa
     * @param g :Graphics2D
     * @throws IOException
     */
    @Override
    abstract public void DrawHo(Graphics2D g) throws IOException;
    /**
     * az interfesz implementalasa
     * @param g :Graphics2D
     * @throws IOException
     */
    @Override
    public void DrawIKarakter(Graphics2D g) {}
    /**
     * az interfesz implementalasa
     * @param g :Graphics2D
     * @throws IOException
     */
    @Override
    public void DrawEpulet(Graphics2D g) {}
    /**
     * az interfesz implementalasa
     * @param g :Graphics2D
     * @throws IOException
     */
    @Override
    public void DrawTulajdonsagok(Graphics2D g,Graphics2D g2,Integer lepesszam,Integer teherbiras, String eszkoz,String alkatresz, Integer testho) throws IOException{}
}
