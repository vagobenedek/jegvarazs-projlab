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

public class ViewJatek extends Canvas implements IDrawable {
    HashMap<ViewMezo, Mezo> mezoHashMap = new HashMap<ViewMezo, Mezo>();
    HashMap<ViewKarakter,IKarakter> karakterHashMap;
    HashMap<ViewTargy, ITargy> targyHashMap;
    private Vezerlo vezerlo;
    private Palya palya;
    private char code;
    public ViewJatek() throws IOException {
        viewGame();
        Init();
    }
    public ViewJatek(ViewController vc) throws IOException {
        vezerlo = new Vezerlo(vc.getMeret(),vc.getSSzam(),vc.getESzam());
        palya = vezerlo.getPalya();
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
            for (int j = 0; j!= karakterek.size(); j ++){
                IKarakter k = karakterek.get(j);
                nev = k.getNev();
                if (nev.equals("Sarkkutato")) vk = new ViewSarkkutato();
                else if (nev.equals("Eszkimo")) vk = new ViewEszkimo();
                else if (nev.equals("Jegesmedve")) vk = new ViewJegesmedve();
                karakterHashMap.put(vk, k);
            }
            ITargy t = m.getTargy();
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
        viewGame();
        Init();
    }

    public JPanel gamePanel;
    private JPanel[] buttons = new JPanel[100];
    public JFrame frame;

    public void viewGame() throws IOException {
        frame = new JFrame();
        frame.setTitle("Jegvarazs");
        gamePanel = new JPanel();
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);


        Canvas canvas = new Canvas();
        canvas.setSize(500,500);
        canvas.setBackground(Color.red);
        ViewStabil s = new ViewStabil();
        s.rajzol(canvas);

        frame.add(canvas);

        gamePanel.setLayout(new GridLayout(10,10));

        HashMap<ViewMezo, Mezo> stabilmezok = new HashMap<>();
        Mezo stabil = new Stabil();
        ViewStabil viewStabil = new ViewStabil();
        stabilmezok.put(viewStabil, stabil);


        for(Map.Entry<ViewMezo, Mezo> m: stabilmezok.entrySet()) {
            ViewMezo keyMezo = m.getKey();
            Mezo valueMezo = m.getValue();
        }

        HashMap<Integer, Mezo> azonosito = new HashMap<>();
        azonosito.put(1, stabil);

        for(Map.Entry<Integer, Mezo> m: azonosito.entrySet()) {
            Integer keyMezo = m.getKey();
            Mezo valueMezo = m.getValue();
        }


        for(int i = 0; i<100; i++){

            if (azonosito.get(i) instanceof Stabil){
                buttons[i] = ViewStabil.DrawMezo(buttons[i]);
                buttons[i] = ViewEszkimo.DrawEszkimo(buttons[i]);
            } else {
                buttons[i] = new JPanel();
            }


            /*
            BufferedImage stabil = null;
            stabil = ImageIO.read(new File("images/stabil-instabil.png"));
            BufferedImage finalStabil = stabil;

            BufferedImage tenger = null;
            tenger = ImageIO.read(new File("images/tenger.png"));
            BufferedImage finalTenger = tenger;

            BufferedImage eszkimo = null;
            eszkimo = ImageIO.read(new File("images/eszkimo.png"));
            BufferedImage finalEszkimo = eszkimo;
            */
            //buttons[i] = ViewMezo.DrawMezo(buttons[i]);
            /*
                buttons[i] = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.drawImage(finalTenger, 0, 0, null);
                        g.drawImage(finalEszkimo, 0, 0, null);
                    }
                };

             */
                gamePanel.add(buttons[i]);
            }
        gamePanel.setVisible(true);
        frame.add(gamePanel);

        frame.setVisible(true);
    }


    /**
     * A billentyuesemenyek hozzadasa a komponenshez
     */
    public void Init(){
        //erre a fokuszra helyezzuk a fokuszt
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
                                szereplo.kepessegHasznalat(0);
                            }
                            else
                            szereplo.lep(0);
                            break;
                        //a szereplo lep s gomb hatasara 1 iranyba
                        case 's':
                            if(code=='k'){
                                //ha lenyomtuk a k billentyut, akkor a kepesseget hasznaltuk
                            szereplo.kepessegHasznalat(1);
                            }
                            else
                                szereplo.lep(1);
                            break;
                        //a szereplo lep a gomb hatasara 3 iranyba
                        case 'a':
                            if(code=='k'){
                                //ha lenyomtuk a k billentyut, akkor a kepesseget hasznaltuk
                            szereplo.kepessegHasznalat(3);
                            }
                            else
                                szereplo.lep(3);
                            break;
                        //a szereplo lep d gomb hatasara 2 iranyba
                        case 'd':
                            if(code=='k'){
                                //ha lenyomtuk a k billentyut, akkor a kepesseget hasznaltuk
                                szereplo.kepessegHasznalat(2);
                            }
                            else
                                szereplo.lep(2);
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
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                try {
                    // ujrarajzolunk a billentyu lenyomas utan
                    drawAll();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

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
    public void drawAll() throws IOException {

        for(Map.Entry<ViewMezo, Mezo> m: mezoHashMap.entrySet())
        {
            ViewMezo keyMezo = m.getKey();
            Mezo valueMezo = m.getValue();
            //mezoket kirajzolja
            DrawMezo();

            //mezon levo targyakat rajzolja ki
            if(mezoHashMap.get(keyMezo).getTargy() != null)
            {
                DrawTargy();
            }

            //ha a mezo nincs feltorve kirajzolja a jeget
            //ha a mezon van ho kirajzolja
            if(!mezoHashMap.get(keyMezo).isFeltort())
            {
                DrawJeg();
            } else if(mezoHashMap.get(keyMezo).getHoSzint()!=0)
            {
                DrawHo();
            }

            //karakterek kirajzolasa a mezon
            for(Map.Entry<ViewKarakter, IKarakter> k: karakterHashMap.entrySet())
            {
                ViewKarakter keyKarakter = k.getKey();
                IKarakter valueKarakter = k.getValue();
                //ha a jelenlegi mezo megegyezik a karakter mezojevel
                if(mezoHashMap.get(keyMezo) == karakterHashMap.get(keyKarakter).getMezo())
                {
                    DrawIKarakter();
                }

            }

            //ha van a mezon epulet
            if(mezoHashMap.get(keyMezo).getEpulet() != null)
            {
                DrawEpulet();
            }
        }

        ////////////MEG KELL MEG IRNI////////////
        Szereplo sz = vezerlo.getAktualisSzerelo();
        //Lekerdezi a szereplo tulajdonsagait es megjeleníti (testho, lepesszam...stb.)
        //DrawTulajdonsagok(sz.getLepesszam(), sz.getTestho(), sz.getEszkoz(), sz.getAlkatresz());
        DrawTulajdonsagok();
        ////////////MEG KELL MEG IRNI VEGE////////////

    }

    public static JPanel DrawMezo(){
        return null;
    }

    @Override
    public void DrawTargy() {
        //if
    }

    @Override
    public void DrawJeg() {

    }

    @Override
    public void DrawHo() {

    }

    @Override
    public void DrawIKarakter() {

    }

    @Override
    public void DrawEpulet() {

    }

    /*
    @Override
    public void DrawTulajdonsagok(int lepesszam, int testho, Eszkoz e, Alkatresz a) {

    }
    */
     @Override
    public void DrawTulajdonsagok()
     {

     }
}
