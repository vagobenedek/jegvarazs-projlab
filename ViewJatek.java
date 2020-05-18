import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 */
public class ViewJatek extends JComponent{
    HashMap<ViewMezo, Mezo> mezoHashMap = new HashMap<ViewMezo, Mezo>();
    HashMap<ViewKarakter,IKarakter> karakterHashMap= new HashMap<ViewKarakter,IKarakter>();
    HashMap<ViewTargy, ITargy> targyHashMap = new HashMap<ViewTargy, ITargy>();
    /**
     * a jatekbeli vezerlo
     */
    private Vezerlo vezerlo;
    /**
     * a jatekbeli palya
     */
    private Palya palya;
    /**
     * egy karakter char erteke
     */
    private char code;
    /**
     * az ablak amihez tartozik a komponens
     */
    private ViewController vc;

    /**
     * ViewJatek konstruktor parameterkent az ablakot kapja, amire rarakjuk
     * @param vc: ViewController
     * @throws IOException
     */
    public ViewJatek(ViewController vc) throws IOException {
        this.vc = vc;
        //letrehozunk a komponenshez tartozo vezerlot, ami letrehozza a jatekbeli elemeket
        vezerlo = new Vezerlo(vc.getMeret(),vc.getSSzam(),vc.getESzam());
        // a palya objektumnak erteket adunk
        palya = vezerlo.getPalya();
        //hozzaadjuk az ablakhoz ezt a komponenst
        vc.add(this);
        //lathatova tesszuk ezt a komponenst
        this.setVisible(true);
        //beallitjuk a meretet a mezok szamatol fuggoen
        this.setSize(vc.getMeret()*50+15, vc.getMeret()*50+60);
        List<Mezo> mezok = palya.getMezoelemek();
        ViewMezo vm = null;
        ViewKarakter vk = null;
        ViewTargy vt = null;
        String nev;
        for (int i = 0; i != mezok.size(); i++){
            Mezo m = mezok.get(i);
            nev = m.getNev();
            if (nev.equals("Instabil")) vm = new ViewInstabil();
            else if (nev.equals("Stabil")) vm = new ViewStabil();
            else if (nev.equals("Lyuk")) vm = new ViewLyuk();
            else if (nev.equals("Tenger")) vm = new ViewTenger();
            mezoHashMap.put(vm, m);
            List<IKarakter> karakterek = m.getKarakterek();
            for (int j = 0; j!= karakterek.size(); j ++) {
                IKarakter k = karakterek.get(j);
                nev = k.getNev();
                if (nev.equals("Sarkkutato")) vk = new ViewSarkkutato();
                else if (nev.equals("Eszkimo")) vk = new ViewEszkimo();
                else if (nev.equals("Jegesmedve")) vk = new ViewJegesmedve();
                if (vk == null)
                    System.out.println("hiba");
                karakterHashMap.put(vk, k);
            }
            ITargy t = m.getTargy();
            if (t != null) {
                nev = t.getNev();
                if (nev.equals("Buvarruha")) vt = new ViewBuvarruha();
                else if (nev.equals("Elelem")) vt = new ViewElelem();
                else if (nev.equals("Jelzofeny")) vt = new ViewJelzofeny();
                else if (nev.equals("Kotel")) vt = new ViewKotel();
                else if (nev.equals("Lapat")) vt = new ViewLapat();
                else if (nev.equals("Patron")) vt = new ViewPatron();
                else if (nev.equals("Pisztoly")) vt = new ViewPisztoly();
                else if (nev.equals("Sator")) vt = new ViewSator();
                else if (nev.equals("Torekenylapat")) vt = new ViewTorekenyLapat();
                targyHashMap.put(vt, t);
            }
        }
        this.setVisible(true);
        Init();
    }

    /**
     * az ososztaly paint metodusanak felulirasa
     * @param g
     */
    @Override
    public void paint(Graphics g){
        //super.paint(g);
        try{
            //kirajzolunk mindent
            drawAll(g);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //ha a vezerlo gyoztel tagvaltozoja igaz
        if (vezerlo.Gyoztel()){
            //meghivja a ViewConroller Gyoztel fuggvenyet
               vc.Gyoztel();
               //ujrarajzoljuk az ablakot
               vc.repaint();
               //eltavolitjuk az ablakbol ezt a komponenset
               vc.remove(this);
        }
        //ha a vezerlo vesztettel tagvaltozoja igaz
        if(vezerlo.Vesztettel()) {
            //meghivja a ViewConroller Vesztettel fuggvenyet
            vc.Vesztettel();
            //ujrarajzoljuk az ablakot
            vc.repaint();
            //eltavolitjuk az ablakbol ezt a komponenset
            vc.remove(this);
        }
    }

    /**
     * A billentyuesemenyek hozzadasa a komponenshez
     */
    public void Init(){
        //a fokuszba helyezzuk ezt a komponenest
        this.setFocusable(true);
        //a Listenerek hozzaadasa
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            //gomb lenyomasok felulirasa
            @Override
            public void keyPressed(KeyEvent e) {
                // az aktualis szereplo elerese
                Szereplo szereplo = vezerlo.getAktualisSzerelo();
                try {
                    //szetvalasztjuk a lenyomott billentyu
                    switch (e.getKeyChar()) {
                        //a szereplo lep w gomb hatasara 0 iranyba
                        case 'w':
                            //ha lenyomtuk a k billentyut, akkor a kepesseget hasznaltuk
                            if(code=='k'){
                                szereplo.kepessegHasznalat(1);
                            }
                            else
                            szereplo.lep(1);
                            break;
                        //a szereplo lep s gomb hatasara 1 iranyba
                        case 's':
                            if(code=='k'){
                                //ha lenyomtuk a k billentyut, akkor a kepesseget hasznaltuk
                            szereplo.kepessegHasznalat(0);
                            }
                            else
                                szereplo.lep(0);
                            break;
                        //a szereplo lep a gomb hatasara 3 iranyba
                        case 'a':
                            if(code=='k'){
                                //ha lenyomtuk a k billentyut, akkor a kepesseget hasznaltuk
                            szereplo.kepessegHasznalat(2);
                            }
                            else
                                szereplo.lep(2);
                            break;
                        //a szereplo lep d gomb hatasara 2 iranyba
                        case 'd':
                            if(code=='k'){
                                //ha lenyomtuk a k billentyut, akkor a kepesseget hasznaltuk
                                szereplo.kepessegHasznalat(3);
                            }
                            else
                                szereplo.lep(3);
                            break;
                            // a szereplo az iglu kepesseget hasznalja
                        case 'i':
                            if(code=='k'){
                            szereplo.kepessegHasznalat(-1);
                            }
                            break;
                        case 'k':
                            code=e.getKeyChar();
                            break;
                            //a szereplo az eszkozet hasznalja a h billentyu eseten
                        case 'h':szereplo.hasznal();
                            break;
                        //a szereplo az eszkozet felveszi az f billentyu eseten
                        case 'f':szereplo.felvesz();
                            break;
                        //a szereplo az mezot feltori a b billentyu eseten
                        case 'b':szereplo.feltor();
                            break;
                        //a szereplo a havat assa az x billentyu eseten (lapat nelkul)
                        case 'x':szereplo.hoAsas(0);
                            break;
                        //a szereplo a havat assa az y billentyu eseten lapattal
                        case 'y':
                            if(szereplo.getEszkoz()!=null||szereplo.getEszkoz().getNev().equals("Lapat")) {
                            szereplo.hoAsas(1);
                            }
                            break;
                            // a kovetkezo szereplore lepunk a passzolassal
                        case 'p':vezerlo.kovetkezoSzereplo();
                        break;
                        //osszerakatjuk a szereplovel a harom alkatreszt
                        case 'o': szereplo.osszerak();
                            break;
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                //ujrarajzolas az esemenyek utan
                repaint();
            }
            // a gomb felengedesenek felulirasa
            @Override
            public void keyReleased(KeyEvent e) {
                // ha elengedjuk a k gombot utana nem hasznalhatjuk a kepesseget
                // uj erteket adunk a code valtozonak, olyat amit nem hasznalunk
                if (code == 'k'){
                    code = '_';
                }

            }
        });

    }

    /**
     * Az ososztaly paintComponent felulirasa, hogy a paint metodust hivja meg az ujrarajzolasnal
     * @param g
     */
    @Override
    public void paintComponent(Graphics g){
        paint(g);
    }
   /* public void addMezoToHashmap(Mezo m, ViewMezo vm) throws IOException {
        Mezo mezo = new Stabil();
        ViewMezo viewMezo = new ViewStabil();
        mezoHashMap = new HashMap<ViewMezo, Mezo>();
        Palya palya = vezerlo.getPalya();
        List<Mezo> mezok = palya.getMezoelemek();
        for (Mezo me : mezok) {
            //...
            if(me instanceof Stabil)
            {
                mezoHashMap.put(new ViewStabil(), me);
            }
        }
    }
    public void addKarakterToHashmap(IKarakter k, ViewKarakter vk){

    }
    public void addTargyToHashmap(ITargy t, ViewTargy vt){

    }*/

    /**
     * Draw szekvencia
     * mindent újra kirajzol
     */
    public void drawAll(Graphics g) throws IOException {
        //mezo sorszama
        int number = 0;
        //ciklus ami vegigmegy az osszes mezon
        for(Mezo valueMezo:palya.getMezoelemek()) {
            //a grafikus mezo objektum
            ViewMezo keyMezo = null;
            // a ciklusban megkeressuk az aktualis mezohoz tartozo grafikus objektumot
            for (Map.Entry<ViewMezo, Mezo> m: mezoHashMap.entrySet()){
                if (valueMezo.equals(m.getValue())){
                    keyMezo=m.getKey();
                    break;
                }
            }
            // megkapjuk a sorok/oszlopok szamat
            double position = Math.sqrt(mezoHashMap.size());
            //letrehozunk egy 2D-s grafikus elemet
            Graphics2D g2 = (Graphics2D)g.create();
            //eltoljuk az origojat, ugy, hogy minden mezo jo helyre keruljon
            g2.translate(number%position*50,((int)(number/position)*50));
            try {
                //kirajzoljuk a mezot
                keyMezo.DrawMezo(g2);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //mezon levo targyakat rajzolja ki
            ITargy targy = mezoHashMap.get(keyMezo).getTargy();
            //ha  van targy a mezon
            if( targy != null)
            {
                //megkeressuk a grafikus objektumat a mezon levo targyhoz
                for (Map.Entry<ViewTargy,ITargy> t:targyHashMap.entrySet()) {
                    if (t.getValue().equals(targy)) {
                        //kirajzoljuk a targyat
                        t.getKey().DrawTargy(g2);
                    }
                }
            }

            //ha a mezo nincs feltorve kirajzolja a jeget
            if(!valueMezo.isFeltort())
            {
                keyMezo.DrawJeg(g2);
            }
            //ha a mezon van ho kirajzolja
            if(valueMezo.getHoSzint()!=0)
            {
                keyMezo.DrawHo(g2);
            }


            IEpulet epulet = valueMezo.getEpulet();
            //ha van a mezon epulet
            if(epulet != null)
            {
                //ha mezo mddvetol nem vedett, de hotol igen, akkor az sator
                if (!mezoHashMap.get(keyMezo).isMedvetolVedett()&&mezoHashMap.get(keyMezo).isHovihartolVedett())
                    //kirajzoljuk a satort;
                    new ViewSator().DrawEpulet(g2);
                //ha medvetol es hotol is vedett, akkor iglu
                else if (mezoHashMap.get(keyMezo).isMedvetolVedett()&&mezoHashMap.get(keyMezo).isHovihartolVedett())
                    //kirajzoljuk az iglut
                    new ViewIglu().DrawEpulet(g2);
                //kirajzoljuk a jegesmedvet
                for(Map.Entry<ViewKarakter, IKarakter> k: karakterHashMap.entrySet())
                {
                    ViewKarakter keyKarakter = k.getKey();
                    IKarakter valueKarakter = k.getValue();
                    //ha a jelenlegi mezo megegyezik a karakter mezojevel es a karakter jegesmedve
                    if( valueKarakter.getNev().equals("Jegesmedve") && valueMezo == valueKarakter.getMezo())
                    {
                        //karakterek kirajzolasa a mezon
                        keyKarakter.DrawIKarakter(g2);
                    }
                }
            }
            //ha nincs epulet akkor az osszes szereplot kirajzoljuk
            else{

                for(Map.Entry<ViewKarakter, IKarakter> k: karakterHashMap.entrySet())
                {
                    ViewKarakter keyKarakter = k.getKey();
                    IKarakter valueKarakter = k.getValue();
                    //ha a jelenlegi mezo megegyezik a karakter mezojevel
                    if(valueMezo == valueKarakter.getMezo())
                    {
                        //karakterek kirajzolasa a mezon
                        keyKarakter.DrawIKarakter(g2);
                    }
                }
            }
            // a mezo szamanak a novelese
            number++;
        }
        // az aktualis szereplo
        Szereplo sz = vezerlo.getAktualisSzerelo();
        //uj grafikus elem, amikkel a tulajdonsagokat rajzolom ki
        Graphics2D g3 = (Graphics2D)g.create();
        //az ablak bal also sarkaba helyez az origot
        g3.translate(0,this.getHeight()-20);
        //uj grafikus elem, amivel a szereplot jelolo nyilat rajzolom ki
        Graphics2D g4 = (Graphics2D)g.create();
        // megkapjuk a sorok/oszlopok szamat
        double position = Math.sqrt(mezoHashMap.size());
        //megkapjuk a sorszamat a mezonek, amin all a szereplo
        for (int i = 0; i< vezerlo.getPalya().getMezoelemek().size();i++){
            Mezo m = vezerlo.getPalya().getMezoelemek().get(i);
            if (m.equals(sz.getMezo())){
                number = i;
                break;
            }
        }
        //eltoljuk az origojat, ugy, a szereplo mezojehez keruljon
        g4.translate(number%position*50,((int)(number/position)*50));
        String eszkoz = "";
        String alkatresz = "";
        for(Map.Entry<ViewKarakter, IKarakter> k: karakterHashMap.entrySet()) {
            ViewKarakter keyKarakter = k.getKey();
            IKarakter valueKarakter = k.getValue();
            if (sz.equals(valueKarakter)) {
                if (sz.getEszkoz()!=null){
                    //ha van eszkoz akkor beallitjuk, hogy annak a nevet adja tovabb a tulajdonsagok rajzolasanal
                    eszkoz = sz.getEszkoz().getNev();
                }
                if (sz.getAlkatresz()!=null){
                    //ha van alkatresz akkor beallitjuk, hogy annak anevet adja at a tulajdonsagok rajzolasanal
                    alkatresz = sz.getAlkatresz().getNev();
                }
                //a szereplo tulajdonsagainak kirajzolasa
                keyKarakter.DrawTulajdonsagok(g4,g3,sz.getLepesszam(),sz.getTeherbiras(),eszkoz,alkatresz,sz.getTestho());
            }
        }
    }
}
