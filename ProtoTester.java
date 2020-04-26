import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.io.*;
import java.lang.reflect.Parameter;

public class ProtoTester {

    //TODO: ezzel mukodjon
    public static void test(String[] args) throws IOException {
        File f = new File("./kimenet.txt");
        f.delete();
        int numberOfTests;
        String line;
        if (args.length == 0){
            System.out.println("A program nem kapott argumentumot.");
            return;
        }
        else {
            if (args[0].equals("all")){
                numberOfTests = Integer.parseInt(args[1]);
            } else {
                numberOfTests = 1;
            }
            FileWriter output = new FileWriter("./kimenet.txt", true);
            //output.write("1_teszt");
            for (int i = 1; i != numberOfTests+1; i++){
                System.out.println(i);
                output.append((numberOfTests == 1 ?args[0]:i) +"\n");
                Interpreter interpreter = new Interpreter();
                BufferedReader reader;
                //TODO: bemeneti mappabol szedje
                //reader = new BufferedReader(new FileReader("./Tesztesetek/Bemeneti/6_bemenet.txt"));
                reader = new BufferedReader(new FileReader("./Tesztesetek/Bemeneti/"+ (numberOfTests == 1?args[0]:i) +"_bemenet.txt"));
                System.out.println(reader);
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    //parancs ertelmezese
                    interpreter.Translate(line);
                    // kovetkezo sor beolvasasa
                }
                reader.close();
                output.write("\n\n");
            }
            output.close();
        }
    }
}
