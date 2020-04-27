import java.io.FileWriter;
import java.io.IOException;

/**
 * Lyuk osztaly
 * Instabilbol szarmazik le
 */
public class Lyuk extends Instabil {
    /**
     * Konstuktor
     */
    public Lyuk() throws IOException {
        super();
        FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Lyuk letrejott.\n");
        f.close();
    }

    /**
     * Lyuk konstuktor
     * @param t ITargy
     * @param e IEpulet
     * @param hoSzint int
     * @param teherbiras int
     * @param hovihartolVedett boolean
     * @param medvetolVedett boolean
     * @throws IOException
     */
    public Lyuk(ITargy t, IEpulet e, int hoSzint,int teherbiras, boolean hovihartolVedett, boolean medvetolVedett)throws IOException{
        //super(t,e,hoSzint,teherbiras,hovihartolVedett,medvetolVedett);
        FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Lyuk letrejott.\n");
        f.close();
    }
}
