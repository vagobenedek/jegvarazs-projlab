import java.io.*;

public class ProtoTester {
    public static void Test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        switch (number) {
            case 1:
                FileWriter output = new FileWriter("./kimenet.txt", true);
                output.write("1. teszteset\n");
                output.close();

                Interpreter i = new Interpreter();
                BufferedReader reader;
                try {
                    reader = new BufferedReader(new FileReader("C:/Bemeneti/1_bemenet.txt"));
                    String line = reader.readLine();
                    while (line != null) {
                        //parancs ertelmezese
                        i.Translate(line);
                        // kovetkezo sor beolvasasa
                        line = reader.readLine();
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                output.write("\n");
                output.close();

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
        }
    }
}
