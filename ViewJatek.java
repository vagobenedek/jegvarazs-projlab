import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ViewJatek extends JComponent {
    HashMap<Mezo,ViewMezo> mezoHashMap;
    HashMap<IKarakter,ViewKarakter> karakterHashMap;
    HashMap<ITargy,ViewTargy> targyHashMap;
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
            buttons[i] = new JPanel();
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.black));

            ImageIcon tenger = new ImageIcon(getClass().getResource("images/stabil-instabil.png"));
            JLabel tengerLabel = new JLabel(tenger);
            ImageIcon eszkimo = new ImageIcon(getClass().getResource("images/eszkimo.png"));
            JLabel eszkimoLabel = new JLabel(eszkimo);
            buttons[i].add(tengerLabel);
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
                drawAll();
                code=e.getKeyChar();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
    public void addMezoToHashmap(Mezo m, ViewMezo vm){
        mezoHashMap = new HashMap<Mezo, ViewMezo>();
        Palya palya = vezerlo.getPalya();
        List<Mezo> mezok = palya.getMezoelemek();
        for (Mezo mezo : mezok) {
            //...
        }
    }
    public void addKarakterToHashmap(IKarakter k, ViewKarakter vk){

    }
    public void addTargyToHashmap(ITargy t, ViewTargy vt){

    }
    public void drawAll(){

    }
}
