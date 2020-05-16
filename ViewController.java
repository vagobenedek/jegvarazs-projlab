import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ViewController extends JFrame{

    public static void main(String args[]){
        try {
            CreateUjJatek();
        }
        catch (Exception e){}
    }

    public static void CreateUjJatek() throws IOException {
        new ViewJatek();
    }

}
