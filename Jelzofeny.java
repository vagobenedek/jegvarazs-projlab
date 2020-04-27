import java.io.FileWriter;
import java.io.IOException;

/**
 * Jelzofeny osztaly
 * Alkatreszbol szarmazik le
 */
public class Jelzofeny extends Alkatresz {
    /**
     * Konstuktor: letrehozza a jelzofenyt
     * @throws IOException
     */
    public Jelzofeny() throws IOException {
        FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Jelzofeny letrejott.\n");
        f.close();
    }

    /**
     * Kostuktor: letrehozza a jelzofenyt
     * @param s String
     * @throws IOException
     */
    public Jelzofeny(String s) throws IOException {
        FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Jelzofeny letrejott.\n");
        f.close();
    }
    public String getNev(){
        return "Jelzofeny";
    }
}
