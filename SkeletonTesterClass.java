import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class SkeletonTesterClass {
    public void InitTest() throws IOException {
        System.out.println("Szkeleton teszt");
        System.out.println("1.: Init\n2.: Mezo asasa\n3.: Alkatreszek osszeszerelese\n 4.: Eszkoz hasznalata\n" +
                "5.: Lep\n6.: Kepesseg hasznalata\n7.: Targy felvetele\n");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        switch(number){
            case 1:break;
            case 2:
                feltorHoasasTest();
                break;
            case 3: break;
            case 4:
                eszkozHasznalatTest();
                break;
            case 5:
                lepTest();
                break;
            case 6:
                kepessegHasznalatTest();
                break;
            case 7: break;
        }

    }

    public static void kepessegHasznalatTest() throws IOException {
        System.out.println("Képesség használat szekvencia");
        System.out.println("Milyen Szereplo vagyok?");
        System.out.println("1.: Eszkimo\n2.: Sarkkutato");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if(str.equals("1")) {
            Random rand = new Random();
            new Eszkimo().kepessegHasznalat(rand.nextInt(1000));
        }
        if(str.equals("2")) {
            System.out.println("Melyik irányban szeretném alkalmazni a képességem?");
            System.out.println("1.: Észak\n2.: Kelet\n3.: Dél\n4.: Nyugat");
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            String string = buffer.readLine();
            System.out.println(Integer.parseInt(string));
            new Sarkkutato().kepessegHasznalat(Integer.parseInt(string));
        }
    }

    public static void eszkozHasznalatTest() throws IOException {
        System.out.println("Eszkoz használat szekvencia");
            //Egy szereplő létrehozása, aki használni fogja az élelmet
            Szereplo sz = new Eszkimo();
            //Meghívjuk az adott szereplő használ() függvényét.
            sz.hasznal();
    }

    public static void lepTest() throws IOException {
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
    
    public static void feltorHoasasTest() throws IOException {
    	System.out.println("Feltor + hoasas szekvenciak");
    	System.out.println("Van ho a mezon?");
    	System.out.println("1.: Igen\n2.: Nincs");
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String str = br.readLine();
    	if(str.equals("1")) {
    		new Eszkimo().hoAsas();
    	}
    	if(str.equals("2")) {
    		new Eszkimo().feltor();
    	}
    }
    
    public void Tabulators(){
        System.out.println("\t");
    }
}
