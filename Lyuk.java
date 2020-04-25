import java.io.FileWriter;
import java.io.IOException;

public class Lyuk extends Instabil {
    public Lyuk() throws IOException {
        //super()
        FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Lyuk letrejott\n");
        f.close();
    }
}
