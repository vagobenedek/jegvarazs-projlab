import java.io.IOException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Interpreter {
    HashMap<String, Mezo> mezok;
    HashMap<String, Stabil> stabilMezok;
    HashMap<String, Instabil> instabilMezok;
    HashMap<String, Lyuk> lyukak;
    HashMap<String, Szereplo> szereplok;
    HashMap<String, Eszkimo> eszkimok;
    HashMap<String, Sarkkutato> sarkkutatok;
    HashMap<String, Jegesmedve> jegesmedvek;
    HashMap<String, Tenger> tenger;

    HashMap<String, Eszkoz> eszkozok;
    HashMap<String, Elelem> elelem;
    HashMap<String, Kotel> kotel;
    HashMap<String, Lapat> lapat;
    HashMap<String, TorekenyLapat> torekenylapat;
    HashMap<String, Sator> sator;
    HashMap<String, Buvarruha> buvarruha;

    HashMap<String, Alkatresz> alkatreszek;
    HashMap<String, Pisztoly> pisztoly;
    HashMap<String, Jelzofeny> jelzofeny;
    HashMap<String, Patron> patron;

    HashMap<String, Iglu> igluk;

    Interpreter(){
        mezok = new HashMap<String, Mezo>();
        szereplok = new HashMap<String, Szereplo>();
        eszkimok = new HashMap<String, Eszkimo>();
        sarkkutatok = new HashMap<String, Sarkkutato>();
        jegesmedvek = new HashMap<String, Jegesmedve>();
        stabilMezok = new HashMap<String, Stabil>();
        instabilMezok = new HashMap<String, Instabil>();
        lyukak = new HashMap<String, Lyuk>();
        tenger = new HashMap<String, Tenger>();

        eszkozok = new HashMap<String, Eszkoz>();
        elelem = new HashMap<String, Elelem>();
        kotel = new HashMap<String, Kotel>();
        lapat = new HashMap<String, Lapat>();
        torekenylapat = new HashMap<String, TorekenyLapat>();
        sator = new HashMap<String, Sator>();
        buvarruha = new HashMap<String, Buvarruha>();

        alkatreszek = new HashMap<String, Alkatresz>();
        pisztoly = new HashMap<String, Pisztoly>();
        jelzofeny = new HashMap<String, Jelzofeny>();
        patron = new HashMap<String, Patron>();

        igluk = new HashMap<String, Iglu>();

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
            stabilMezok.put(splitted[1], new Stabil());
            if (splitted.length == 3){
                (mezok.get(splitted[1])).setHoSzint(Integer.parseInt(splitted[2]));
                (stabilMezok.get(splitted[1])).setHoSzint(Integer.parseInt(splitted[2]));
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
            (mezok.get(splitted[2])).addKarakter(szereplok.get(splitted[1]));
            eszkimok.put(splitted[1], new Eszkimo());
            eszkimok.get(splitted[1]).setM(mezok.get(splitted[2]));
        }
        //Szereplo lepese
        else if (splitted[0].equals("lep")){
            try {
                System.out.println("elotte");
                (szereplok.get(splitted[1])).lep(Integer.parseInt(splitted[2]));
                System.out.println("utana");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Instabil mezo letrehozasa
        else if (splitted[0].equals("instabil")){
            mezok.put(splitted[1], new Instabil());
            instabilMezok.put(splitted[1], new Instabil());
            if (splitted.length == 3){
                (mezok.get(splitted[1])).setTeherbiras(Integer.parseInt(splitted[2]));
                (instabilMezok.get(splitted[1])).setTeherbiras(Integer.parseInt(splitted[2]));
            }
            if (splitted.length == 4){
                (mezok.get(splitted[1])).setTeherbiras(Integer.parseInt(splitted[2]));
                (instabilMezok.get(splitted[1])).setTeherbiras(Integer.parseInt(splitted[2]));
                (mezok.get(splitted[1])).setHoSzint(Integer.parseInt(splitted[3]));
                (instabilMezok.get(splitted[1])).setHoSzint(Integer.parseInt(splitted[3]));
            }
        }
        //Lyuk letrehozasa
        else if (splitted[0].equals("lyuk")){
            mezok.put(splitted[1], new Lyuk());
            lyukak.put(splitted[1], new Lyuk());
            if (splitted.length == 3){
                (mezok.get(splitted[1])).setHoSzint(Integer.parseInt(splitted[2]));
                (lyukak.get(splitted[1])).setHoSzint(Integer.parseInt(splitted[2]));
            }
        }
        //Tenger letrehozasa
        else if (splitted[0].equals("tenger")){
            mezok.put(splitted[1], new Tenger());
            tenger.put(splitted[1], new Tenger());
            if (splitted.length == 3){
                (mezok.get(splitted[1])).setHoSzint(Integer.parseInt(splitted[2]));
                (tenger.get(splitted[1])).setHoSzint(Integer.parseInt(splitted[2]));
            }
        }
        //Hoszint beallitasa
        else if (splitted[0].equals("sethoszint")){
            (mezok.get(splitted[1])).setHoSzint(Integer.parseInt(splitted[2]));
        }
        //Sarkkutato letrehozasa
        else if (splitted[0].equals("sarkkutato")){
            szereplok.put(splitted[1], new Sarkkutato());
            new Vezerlo(szereplok.get(splitted[1]), new Jegesmedve());
            szereplok.get(splitted[1]).setM(mezok.get(splitted[2]));
            (mezok.get(splitted[2])).addKarakter(szereplok.get(splitted[1]));
            sarkkutatok.put(splitted[1], new Sarkkutato());
            sarkkutatok.get(splitted[1]).setM(mezok.get(splitted[2]));
        }
        //Jegesmedve letrehozasa
        else if (splitted[0].equals("jegesmedve")){
            jegesmedvek.put(splitted[1], new Jegesmedve());
            (mezok.get(splitted[2])).addKarakter(jegesmedvek.get(splitted[1]));
            jegesmedvek.get(splitted[1]).setM(mezok.get(splitted[2]));
        }
        //Testho beallitasa
        else if (splitted[0].equals("settestho")){
            (szereplok.get(splitted[1])).setTestho(Integer.parseInt(splitted[2]));
        }
        //Elelem letrehozasa
        else if (splitted[0].equals("elelem")){
            eszkozok.put(splitted[1], new Elelem());
            eszkozok.get(splitted[1]).addEszkozToMezo(mezok.get(splitted[2]));
            elelem.put(splitted[1], new Elelem());
            elelem.get(splitted[1]).addEszkozToMezo(mezok.get(splitted[2]));
        }
        //Buvarruha letrehozasa
        else if (splitted[0].equals("buvarruha")){
            eszkozok.put(splitted[1], new Buvarruha());
            eszkozok.get(splitted[1]).addEszkozToMezo(mezok.get(splitted[2]));
            mezok.get(splitted[2]).setTargy(eszkozok.get(splitted[1]));
            buvarruha.put(splitted[1], new Buvarruha());
            buvarruha.get(splitted[1]).addEszkozToMezo(mezok.get(splitted[2]));
        }
        //Kotel letrehozasa
        else if (splitted[0].equals("kotel")){
            eszkozok.put(splitted[1], new Kotel());
            eszkozok.get(splitted[1]).addEszkozToMezo(mezok.get(splitted[2]));
            kotel.put(splitted[1], new Kotel());
            kotel.get(splitted[1]).addEszkozToMezo(mezok.get(splitted[2]));
        }
        //Lapat letrehozasa
        else if (splitted[0].equals("lapat")){
            eszkozok.put(splitted[1], new Lapat());
            eszkozok.get(splitted[1]).addEszkozToMezo(mezok.get(splitted[2]));
            lapat.put(splitted[1], new Lapat());
            lapat.get(splitted[1]).addEszkozToMezo(mezok.get(splitted[2]));
        }
        //Torkenyaso letrehozasa
        else if (splitted[0].equals("torekenyaso")){
            eszkozok.put(splitted[1], new TorekenyLapat());
            eszkozok.get(splitted[1]).addEszkozToMezo(mezok.get(splitted[2]));
            torekenylapat.put(splitted[1], new TorekenyLapat());
            torekenylapat.get(splitted[1]).addEszkozToMezo(mezok.get(splitted[2]));
        }
        //Sator letrehozasa
        else if (splitted[0].equals("sator")){
            Sator s = new Sator(mezok.get(splitted[2]));
            eszkozok.put(splitted[1], s);
            eszkozok.get(splitted[1]).addEszkozToMezo(mezok.get(splitted[2]));
            sator.put(splitted[1], s);
            sator.get(splitted[1]).addEszkozToMezo(mezok.get(splitted[2]));
        }
        //Hozzárendel egy eszközt a szereplőhöz.
        else if (splitted[0].equals("addeszkoz")){
            eszkozok.get(splitted[1]).felvesz(szereplok.get(splitted[2]));
        }
        //Pisztoly letrehozasa
        else if (splitted[0].equals("pisztoly")){
            alkatreszek.put(splitted[1], new Pisztoly());
            alkatreszek.get(splitted[1]).addAlkatreszToMezo(mezok.get(splitted[2]));
            pisztoly.put(splitted[1], new Pisztoly());
            pisztoly.get(splitted[1]).addAlkatreszToMezo(mezok.get(splitted[2]));
        }
        //Jelzofeny letrehozasa
        else if (splitted[0].equals("jelzofeny")){
            alkatreszek.put(splitted[1], new Jelzofeny());
            alkatreszek.get(splitted[1]).addAlkatreszToMezo(mezok.get(splitted[2]));
            jelzofeny.put(splitted[1], new Jelzofeny());
            jelzofeny.get(splitted[1]).addAlkatreszToMezo(mezok.get(splitted[2]));
        }
        //Patron letrehozasa
        else if (splitted[0].equals("patron")){
            alkatreszek.put(splitted[1], new Patron());
            alkatreszek.get(splitted[1]).addAlkatreszToMezo(mezok.get(splitted[2]));
            patron.put(splitted[1], new Patron());
            patron.get(splitted[1]).addAlkatreszToMezo(mezok.get(splitted[2]));
        }
        //Alkatrész hozzaadasa
        else if (splitted[0].equals("addalkatresz")){
            alkatreszek.get(splitted[1]).felvesz(szereplok.get(splitted[2]));
        }
        //Iglu letrehozasa
        else if (splitted[0].equals("iglu")){
            igluk.put(splitted[1], new Iglu(mezok.get(splitted[2])));
        }
        //Kepesseghasznalat
        else if (splitted[0].equals("kepesseg")){
            szereplok.get(splitted[1]).kepessegHasznalat(Integer.parseInt(splitted[2]));
        }
        //Targy felvetele
        else if (splitted[0].equals("felvesz")){
            szereplok.get(splitted[1]).getMezo().targyFelvetele(szereplok.get(splitted[1]));
        }
        //Eszkoz hasznalata
        else if (splitted[0].equals("hasznal")){
            System.out.println("hasznal elott");
            szereplok.get(splitted[1]).hasznal();
            System.out.println("pls work");
        }
        //Alkatreszek osszeszerelese
        else if (splitted[0].equals("osszeszerel")){
            szereplok.get(splitted[1]).osszerak();
        }
        //Asas
        else if (splitted[0].equals("asas")){
            szereplok.get((splitted[1])).hoAsas(0);
        }
        //Mezo feltorese
        else if (splitted[0].equals("feltor")){
            szereplok.get(splitted[1]).feltor();
        }
        //Hovihar
        else if (splitted[0].equals("hovihar")){
            mezok.get(splitted[1]).hovihar();
        }
        else if (splitted[0].equals("kor")){
            Vezerlo v = new Vezerlo(new Eszkimo(), null);
            v.getAktualisSzerelo().setLepesszam(0);
        }
    }
}
