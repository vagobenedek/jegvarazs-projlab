import java.io.FileWriter;
import java.io.IOException;

public class Lyuk extends Instabil {
    public Lyuk() throws IOException {
        super();
        FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Lyuk letrejott\n");
        f.close();
    }
    public Lyuk(ITargy t, IEpulet e, int hoSzint,int teherbiras, boolean hovihartolVedett, boolean medvetolVedett)throws IOException{
        super(t,e,hoSzint,teherbiras,hovihartolVedett,medvetolVedett);
        FileWriter f = new FileWriter("./kimenet.txt", true);
        f.append("Lyuk letrejott\n");
        f.close();
    }
}
