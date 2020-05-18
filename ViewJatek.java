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

public class ViewJatek extends JComponent{
    HashMap<ViewMezo, Mezo> mezoHashMap = new HashMap<ViewMezo, Mezo>();
    HashMap<ViewKarakter,IKarakter> karakterHashMap= new HashMap<ViewKarakter,IKarakter>();
    HashMap<ViewTargy, ITargy> targyHashMap = new HashMap<ViewTargy, ITargy>();
    private Vezerlo vezerlo;
    private Palya palya;
    private char code;
    private ViewController vc;
    public ViewJatek() throws IOException {
        Init();
    }
    public ViewJatek(ViewController vc) throws IOException {
        this.vc = vc;
        vezerlo = new Vezerlo(vc.getMeret(),vc.getSSzam(),vc.getESzam());
        palya = vezerlo.getPalya();
        vc.add(this);
        this.setVisible(true);
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
        System.out.println("itt");
        Init();

        System.out.println("itt");
    }
    @Override
    public void paint(Graphics g){
        //super.paint(g);
        try{
            drawAll(g);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if (vezerlo.Gyoztel()){
               vc.Gyoztel();
               vc.repaint();
               vc.remove(this);
        }
        if(vezerlo.Vesztettel()) {
            vc.Vesztettel();
            vc.repaint();
            vc.remove(this);
        }
    }

    /**
     * A billentyuesemenyek hozzadasa a komponenshez
     */
    public void Init(){
        this.setFocusable(true);
        //a Listenerek hozzaadasa

        System.out.println("in");
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            //gomb lenyomasok felulirasa
            @Override
            public void keyPressed(KeyEvent e) {
                // az aktualis szereplo elerese
                Szereplo szereplo = vezerlo.getAktualisSzerelo();
                System.out.println("in");
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
    @Override
    public void paintComponent(Graphics g){
        paint(g);
    }
    public void addMezoToHashmap(Mezo m, ViewMezo vm) throws IOException {
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

    }

    /**
     * Draw szekvencia
     * mindent újra kirajzol
     */
    public void drawAll(Graphics g) throws IOException {

        int number = 0;
        for(Mezo valueMezo:vezerlo.getPalya().getMezoelemek()) {
            ViewMezo keyMezo = null;
            for (Map.Entry<ViewMezo, Mezo> m: mezoHashMap.entrySet()){
                if (valueMezo.equals(m.getValue())){
                    keyMezo=m.getKey();
                }
            }
            double position = Math.sqrt(mezoHashMap.size());
            Graphics2D g2 = (Graphics2D)g.create();
            g2.translate(number%position*50,((int)(number/position)*50));
            try {
                keyMezo.DrawMezo(g2);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //mezoket kirajzolja

            //mezon levo targyakat rajzolja ki
            ITargy targy = mezoHashMap.get(keyMezo).getTargy();
            if( targy != null)
            {
                for (Map.Entry<ViewTargy,ITargy> t:targyHashMap.entrySet()) {
                    if (t.getValue().equals(targy)) {
                        t.getKey().DrawTargy(g2);
                    }
                }
            }

            //ha a mezo nincs feltorve kirajzolja a jeget
            //ha a mezon van ho kirajzolja
            if(!valueMezo.isFeltort())
            {
                keyMezo.DrawJeg(g2);
            }
            if(valueMezo.getHoSzint()!=0)
            {
                keyMezo.DrawHo(g2);
            }


            IEpulet epulet = valueMezo.getEpulet();
            //ha van a mezon epulet
            if(epulet != null)
            {
                if (!mezoHashMap.get(keyMezo).isMedvetolVedett()&&mezoHashMap.get(keyMezo).isHovihartolVedett())
                    new ViewSator().DrawEpulet(g2);
                else if (mezoHashMap.get(keyMezo).isMedvetolVedett()&&mezoHashMap.get(keyMezo).isHovihartolVedett())
                    new ViewIglu().DrawEpulet(g2);
                for(Map.Entry<ViewKarakter, IKarakter> k: karakterHashMap.entrySet())
                {
                    ViewKarakter keyKarakter = k.getKey();
                    IKarakter valueKarakter = k.getValue();
                    //ha a jelenlegi mezo megegyezik a karakter mezojevel
                    if( valueKarakter.getNev().equals("Jegesmedve") && valueMezo == karakterHashMap.get(keyKarakter).getMezo())
                    {
                        keyKarakter.DrawIKarakter(g2);
                    }
                }
                //karakterek kirajzolasa a mezon
            }
            else{

                for(Map.Entry<ViewKarakter, IKarakter> k: karakterHashMap.entrySet())
                {
                    ViewKarakter keyKarakter = k.getKey();
                    IKarakter valueKarakter = k.getValue();
                    //ha a jelenlegi mezo megegyezik a karakter mezojevel
                    if(valueMezo == karakterHashMap.get(keyKarakter).getMezo())
                    {
                        keyKarakter.DrawIKarakter(g2);
                    }
                }
            }
            number++;
        }
        ////////////MEG KELL MEG IRNI////////////
        Szereplo sz = vezerlo.getAktualisSzerelo();
        Graphics2D g3 = (Graphics2D)g.create();
        g3.translate(0,this.getHeight()-20);
        Graphics2D g4 = (Graphics2D)g.create();
        double position = Math.sqrt(mezoHashMap.size());
        for (int i = 0; i< vezerlo.getPalya().getMezoelemek().size();i++){
            Mezo m = vezerlo.getPalya().getMezoelemek().get(i);
            if (m.equals(sz.getMezo())){
                number = i;
                break;
            }
        }
        g4.translate(number%position*50,((int)(number/position)*50));
        String eszkoz = "";
        String alkatresz = "";
        //Lekerdezi a szereplo tulajdonsagait es megjeleníti (testho, lepesszam...stb.)
        //DrawTulajdonsagok(sz.getLepesszam(), sz.getTestho(), sz.getEszkoz(), sz.getAlkatresz());
        for(Map.Entry<ViewKarakter, IKarakter> k: karakterHashMap.entrySet()) {
            ViewKarakter keyKarakter = k.getKey();
            IKarakter valueKarakter = k.getValue();
            if (sz.equals(valueKarakter)) {
                if (sz.getEszkoz()!=null){
                    eszkoz = sz.getEszkoz().getNev();
                }
                if (sz.getAlkatresz()!=null){
                    alkatresz = sz.getAlkatresz().getNev();
                }
                keyKarakter.DrawTulajdonsagok(g4,g3,sz.getLepesszam(),sz.getTeherbiras(),eszkoz,alkatresz,sz.getTestho());
            }
        }
        ////////////MEG KELL MEG IRNI VEGE////////////
    }
}
