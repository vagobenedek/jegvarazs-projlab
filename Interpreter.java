import java.io.IOException;
import java.util.Dictionary;
import java.util.HashMap;

public class Interpreter {
    HashMap<String, Mezo> mezok;
    HashMap<String, Szereplo> szereplok;

    Interpreter(){
        mezok = new HashMap<String, Mezo>();
        szereplok = new HashMap<String, Szereplo>();
    }

    public void Translate(String command) throws IOException {
        String[] splitted = command.split("\\s+");

        if (splitted[0].equals("stabil")){
            mezok.put(splitted[1], new Stabil());
            if (splitted.length == 3){
                (mezok.get(splitted[1])).setHoSzint(Integer.parseInt(splitted[2]));
            }
        }
        else if (splitted[0].equals("setszomszed")){
            Mezo mezo1 = mezok.get(splitted[1]);
            Mezo mezo2 = mezok.get(splitted[3]);
            mezo1.setSzomszedMezo(mezo2, Integer.parseInt(splitted[2]));
        }
        else if (splitted[0].equals("eszkimo")){
            szereplok.put(splitted[1], new Eszkimo());
            szereplok.get(splitted[1]).setM(mezok.get(splitted[2]));
        }
        else if (splitted[0].equals("lep")){
            try {
                (szereplok.get(splitted[1])).lep(Integer.parseInt(splitted[2]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
