import java.io.FileWriter;
import java.io.IOException;

/**
 * Jegmezo osztaly, Mezobol szarmazik le
 */
public abstract class Jegmezo extends Mezo {
    /**
     * Konstruktor
     * @param t Targy
     * @param e IEpulet
     * @param hoSzint int
     * @param teherbiras int
     * @param hovihartolVedett boolean
     * @param medvetolVedett boolean
     * @throws IOException
     */
    public Jegmezo(ITargy t, IEpulet e, int hoSzint,int teherbiras, boolean hovihartolVedett, boolean medvetolVedett) throws IOException {
        super(t,e,hoSzint,teherbiras,hovihartolVedett,medvetolVedett);
        FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Jegmezo letrejott.\n");
        f.close();
    }

    /**
     * Konstruktor
     * @throws IOException
     */
    public Jegmezo()throws IOException{
        super();
        FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Jegmezo letrejott.\n");
        f.close();
    }
}
