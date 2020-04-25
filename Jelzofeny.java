import java.io.FileWriter;
import java.io.IOException;

public class Jelzofeny extends Alkatresz {
    public Jelzofeny() throws IOException {
        FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Jelzofeny letrejott\n");
        f.close();
    }
    public Jelzofeny(String s) throws IOException {
        FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Jelzofeny letrejott\n");
        f.close();
    }
}
