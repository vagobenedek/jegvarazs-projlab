import java.awt.*;
import java.io.IOException;

/**
 * Az epuletek abstract ososztalya
 */
public abstract class ViewEpulet extends ViewTargy{
    @Override
    abstract public void DrawTargy(Graphics2D g) throws IOException;
    @Override
    abstract public void DrawEpulet(Graphics2D g) throws IOException;
}
