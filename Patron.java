import java.io.FileWriter;
import java.io.IOException;

public class Patron extends Alkatresz {
    public Patron() throws IOException {
        FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Patron letrejott\n");
        f.close();
    }
    public Patron(String s) throws IOException {
        FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Patron letrejott\n");
        f.close();
    }
}
