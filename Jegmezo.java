import java.io.FileWriter;
import java.io.IOException;

public abstract class Jegmezo extends Mezo {
    public Jegmezo(ITargy t, IEpulet e, int hoSzint,int teherbiras, boolean hovihartolVedett, boolean medvetolVedett) throws IOException {
        super(t,e,hoSzint,teherbiras,hovihartolVedett,medvetolVedett);
        FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Jegmezo letrejott.\n");
        f.close();
    }
    public Jegmezo()throws IOException{
        super();
        FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Jegmezo letrejott.\n");
        f.close();
    }
}
