import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SkeletonTesterClass {
    public void InitTest() throws IOException {
        lepTest();
        
    }
    private void lepTest() throws IOException {
        System.out.println("Lep szekvencia");
        System.out.println("Van meg lepes szamom?");
        System.out.println("1.: Van\t2.: Nincs");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if(br.readLine().equals("1")){
            System.out.println("Melyik iranyba akarsz lepni?");
            System.out.println("1.: Fel\t2.: Jobbra\t3.: Le\t4.: Balra");
            new Eszkimo().lep(Integer.parseInt(br.readLine()));
        }
    }
    public void Tabulators(){
        System.out.println("\t");
    }
}
