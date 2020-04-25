import java.io.*;

public class ProtoTester {

    //TODO: ezzel mukodjon
    public static void test1(String[] args) throws IOException {
        int numberOfTests;

        if (args.length == 0){
            System.out.println("A program nem kapott argumentumot.");
            return;
        } else {
            if (args[0].equals("all")){
                numberOfTests = Integer.parseInt(args[1]);
            } else {
                numberOfTests = 1;

            }
        }
    }

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
                    //TODO: bemeneti mappabol szedje
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
