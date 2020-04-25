import java.io.FileWriter;
import java.io.IOException;

public abstract class Epulet extends Targy {
    public Epulet() throws IOException {
        FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Epulet letrejott\n");
        f.close();
    }
}
