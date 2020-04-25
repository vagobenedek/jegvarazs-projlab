import java.io.FileWriter;
import java.io.IOException;

public class Pisztoly extends Alkatresz {
    public Pisztoly() throws IOException {
        FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Pisztoly letrejott\n");
        f.close();
    }
    public Pisztoly(String s) throws IOException {
        FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Pisztoly letrejott\n");
        f.close();
    }
}
