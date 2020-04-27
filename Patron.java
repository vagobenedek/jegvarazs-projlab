import java.io.FileWriter;
import java.io.IOException;

/**
 * Patron osztaly
 * Alkatresz osztalybol szarmazik le
 */
public class Patron extends Alkatresz {
    /**
     * Konstruktor
     * @throws IOException
     */
    public Patron() throws IOException {
        FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Patron letrejott\n");
        f.close();
    }

    /**
     * Konstukrot
     * @param s String
     * @throws IOException
     */
    public Patron(String s) throws IOException {
        FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Patron letrejott\n");
        f.close();
    }
    public String getNev(){
        return "Patron";
    }
}
