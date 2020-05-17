import java.io.FileWriter;
import java.io.IOException;

/**
 * Pisztoly osztaly
 * Alkatreszbol szarmazik le
 */
public class Pisztoly extends Alkatresz {
    /**
     * Konstruktor
     * @throws IOException
     */
    public Pisztoly() throws IOException {
        FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Pisztoly letrejott\n");
        f.close();
    }

    /**
     * Konstruktor
     * @param s String
     * @throws IOException
     */
    public Pisztoly(String s) throws IOException {
        FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Pisztoly letrejott\n");
        f.close();
    }
    @Override
    public String getNev(){
        return "Pisztoly";
    }
}
