import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Random;

/**
 * Main fuggveny
 */
public class Main {
    public static void main(String args[]){
        try {
            //Szereplo szereplo = new Eszkimo();
            //SkeletonTesterClass.Test();
            ProtoTester.test(args);
            System.out.println("Vegeztem!!");
            //new Vezerlo(szereplo);
            //szereplo.elsut();
        }
        catch (Exception e){}
    }
}
