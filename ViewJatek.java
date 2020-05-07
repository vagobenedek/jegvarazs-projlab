import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class ViewJatek extends JComponent {
    HashMap<Mezo,ViewMezo> mezoHashMap;
    HashMap<IKarakter,ViewKarakter> karakterHashMap;
    HashMap<ITargy,ViewTargy> targyHashMap;
    private Vezerlo vezerlo;
    private char code;
    public ViewJatek(){
        Init();
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

    }
    public void addKarakterToHashmap(IKarakter k, ViewKarakter vk){

    }
    public void addTargyToHashmap(ITargy t, ViewTargy vt){

    }
    public void drawAll(){

    }
}
