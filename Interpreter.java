import java.io.IOException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Interpreter {
    HashMap<String, Mezo> mezok;
    HashMap<String, Szereplo> szereplok;

    Interpreter(){
        mezok = new HashMap<String, Mezo>();
        szereplok = new HashMap<String, Szereplo>();
    }

    public void Translate(String command) throws IOException {
        String[] splitted = command.split("\\s+");

        //TODO: atalakitani
        StringTokenizer split = new StringTokenizer(command);
        String split0 = split.nextToken();
        split.hasMoreTokens();

        //Stabil mezo letrehozasa
        if (splitted[0].equals("stabil")){
            mezok.put(splitted[1], new Stabil());
            if (splitted.length == 3){
                (mezok.get(splitted[1])).setHoSzint(Integer.parseInt(splitted[2]));
            }
        }
        //Szomszed mezo beallitasa
        else if (splitted[0].equals("setszomszed")){
            Mezo mezo1 = mezok.get(splitted[1]);
            Mezo mezo2 = mezok.get(splitted[3]);
            mezo1.setSzomszedMezo(mezo2, Integer.parseInt(splitted[2]));
        }
        //Eszkimo letrehozasa
        else if (splitted[0].equals("eszkimo")){
            szereplok.put(splitted[1], new Eszkimo());
            szereplok.get(splitted[1]).setM(mezok.get(splitted[2]));
        }
        //Szereplo lepese
        else if (splitted[0].equals("lep")){
            try {
                (szereplok.get(splitted[1])).lep(Integer.parseInt(splitted[2]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Instabil mezo letrehozasa
        else if (splitted[0].equals("instabil")){

        }
        //Lyuk letrehozasa
        else if (splitted[0].equals("lyuk")){

        }
        //Tenger letrehozasa
        else if (splitted[0].equals("tenger")){

        }
        //Hoszint beallitasa
        else if (splitted[0].equals("sethoszint")){

        }
        //Sarkkutato letrehozasa
        else if (splitted[0].equals("sarkkutato")){

        }
        //Jegesmedve letrehozasa
        else if (splitted[0].equals("jegesmedve")){

        }
        //Testho beallitasa
        else if (splitted[0].equals("settestho")){

        }
        //Elelem letrehozasa
        else if (splitted[0].equals("elelem")){

        }
        //Kotel letrehozasa
        else if (splitted[0].equals("kotel")){

        }
        //Lapat letrehozasa
        else if (splitted[0].equals("lapat")){

        }
        //Torkenyaso letrehozasa
        else if (splitted[0].equals("torekenyaso")){

        }
        //Sator letrehozasa
        else if (splitted[0].equals("sator")){

        }
        //Eszkoz hozzaadasa
        else if (splitted[0].equals("addeszkoz")){

        }
        //Pisztoly letrehozasa
        else if (splitted[0].equals("pisztoly")){

        }
        //Jelzofeny letrehozasa
        else if (splitted[0].equals("jelzofeny")){

        }
        //Patron letrehozasa
        else if (splitted[0].equals("patron")){

        }
        //Alkatrész hozzaadasa
        else if (splitted[0].equals("addalkatresz")){

        }
        //Iglu letrehozasa
        else if (splitted[0].equals("iglu")){

        }
        //Lepes
        else if (splitted[0].equals("lep")){

        }
        //Kepesseghasznalat
        else if (splitted[0].equals("kepesseg")){

        }
        //Targy felvetele
        else if (splitted[0].equals("felvesz")){

        }
        //Eszkoz hasznalata
        else if (splitted[0].equals("hasznal")){

        }
        //Alkatreszek osszeszerelese
        else if (splitted[0].equals("osszeszerel")){

        }
        //Asas
        else if (splitted[0].equals("asas")){

        }
        //Mezo feltorese
        else if (splitted[0].equals("feltor")){

        }
        //Hovihar
        else if (splitted[0].equals("hovihar")){

        }
    }
}
