import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ViewJatek extends JComponent implements IDrawable {
    HashMap<ViewMezo, Mezo> mezoHashMap = new HashMap<ViewMezo, Mezo>();
    HashMap<ViewKarakter,IKarakter> karakterHashMap;
    HashMap<ViewTargy, ITargy> targyHashMap;
    private Vezerlo vezerlo;
    private char code;
    public ViewJatek() throws IOException {
        viewGame();
        Init();
    }

    public static JPanel gamePanel;
    private static JPanel[] buttons = new JPanel[100];
    public static JFrame frame;

    public void viewGame() throws IOException {
        frame = new JFrame();
        frame.setTitle("Jegvarazs");
        gamePanel = new JPanel();
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gamePanel.setLayout(new GridLayout(10,10));
        for(int i = 0; i<100; i++){
            BufferedImage stabil = null;
            stabil = ImageIO.read(new File("images/stabil-instabil.png"));
            BufferedImage finalStabil = stabil;

            BufferedImage tenger = null;
            tenger = ImageIO.read(new File("images/tenger.png"));
            BufferedImage finalTenger = tenger;

            BufferedImage eszkimo = null;
            eszkimo = ImageIO.read(new File("images/eszkimo.png"));
            BufferedImage finalEszkimo = eszkimo;

            buttons[i] = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(finalTenger, 0, 0, null);
                    g.drawImage(finalEszkimo, 0, 0, null);
                }
            };
            gamePanel.add(buttons[i]);
        }
        gamePanel.setVisible(true);
        frame.add(gamePanel);

        frame.setVisible(true);
    }



    public void Init(){
        this.setFocusable(true);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                Szereplo szereplo = vezerlo.getAktualisSzerelo();

                try {
                    switch (e.getKeyChar()) {
                        case 'w':
                            if(code=='k'){
                                szereplo.kepessegHasznalat(0);
                            }
                            else
                            szereplo.lep(0);
                            break;
                        case 's':
                            if(code=='k'){
                            szereplo.kepessegHasznalat(1);
                            }
                            else
                                szereplo.lep(1);
                            break;
                        case 'a':
                            if(code=='k'){
                            szereplo.kepessegHasznalat(3);
                            }
                            else
                                szereplo.lep(3);
                            break;
                        case 'd':
                            if(code=='k'){
                                szereplo.kepessegHasznalat(2);
                            }
                            else
                                szereplo.lep(2);
                            break;
                        case 'i':
                            if(code=='k'){
                            szereplo.kepessegHasznalat(-1);
                            }
                            break;
                        case 'h':szereplo.hasznal();
                            break;
                        case 'f':szereplo.felvesz();
                            break;
                        case 'b':szereplo.feltor();
                            break;
                        case 'x':szereplo.hoAsas(0);
                            break;
                        case 'y':
                            if(szereplo.getEszkoz().getNev().equals("Lapat")) {
                            szereplo.hoAsas(1);
                            }
                            break;
                        case 'p':vezerlo.kovetkezoSzereplo();
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                try {
                    drawAll();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                code=e.getKeyChar();
            }

            @Override
            public void keyReleased(KeyEvent e) {

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

    @Override
    public void DrawMezo(){

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
