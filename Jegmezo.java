import java.io.FileWriter;
import java.io.IOException;

public abstract class Jegmezo extends Mezo {
    public Jegmezo() throws IOException {
        FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Jegmezo letrejott\n");
        f.close();
    }
}
