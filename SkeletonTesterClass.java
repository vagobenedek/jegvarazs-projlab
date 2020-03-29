import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class SkeletonTesterClass {

    public void Test() throws IOException {
        boolean end = false;
        while (!end) {
            System.out.println("Szkeleton teszt");
            System.out.println("1.: Init\n2.: Mezo asasa\n3.: Alkatreszek osszeszerelese\n4.: Eszkoz hasznalata\n" +
                    "5.: Lep\n6.: Kepesseg hasznalata\n7.: Targy felvetele\n8.: Kilepes");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int number = Integer.parseInt(br.readLine());
            switch (number) {
                case 1:
                    initTest();
                    break;
                case 2:
                    feltorHoasasTest();
                    break;
                case 3:
                    alkatreszekOsszeszereleseTest();
                    break;
                case 4:
                    eszkozHasznalatTest();
                    break;
                case 5:
                    lepTest();
                    break;
                case 6:
                    kepessegHasznalatTest();
                    break;
                case 7:
                    targyFelveteleTest();
                    break;
                case 8:
                    end = true;
                    break;
            }
        }
    }

    public static void initTest() throws IOException {
        /*Letrejon egy Vezerlo peldany, melynek konstruktorában lefut az init szekvencia
        Tuladjonkeppen itt epul fel a jatek*/
        new Vezerlo("init");
    }
    public static void kepessegHasznalatTest() throws IOException {
        System.out.println("Kepesseg hasznalat szekvencia");
        System.out.println("Milyen Szereplo vagyok?");
        System.out.println("1.: Eszkimo\n2.: Sarkkutato");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if(str.equals("1")) {
            Random rand = new Random();
            new Eszkimo().kepessegHasznalat(rand.nextInt(1000));
        }
        if(str.equals("2")) {
            System.out.println("Melyik iranyban szeretnam alkalmazni a kepessegem?");
            System.out.println("1.: Eszak\n2.: Kelet\n3.: Del\n4.: Nyugat");
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            String string = buffer.readLine();
            System.out.println(Integer.parseInt(string));
            new Sarkkutato().kepessegHasznalat(Integer.parseInt(string));
        }
    }

    public static void eszkozHasznalatTest() throws IOException {
        System.out.println("Eszkoz hasznalat szekvencia");
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

    /**
     * Targy (eszkoz + alkatresz) felvetelet tesztelo fuggveny
     * @throws IOException
     */
    public static void targyFelveteleTest() throws IOException {
        System.out.println("Targy felvetele szekvencia");
        System.out.println("Fel van torve a jegtabla?");
        System.out.println("1.: igen\n2.: Nem");

        //a felhasznalo altal beolvasott szam megjelenitese
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if(str.equals("1")) {
            //alapvetoen a mezo tudni fogja milyen targy van benne elraktarozva
            //a mezo tarolja a ralepett szereplot és a targyat is
            //mikor a szereplo feltori a jeget a rajta levo targyat a targy felvesz fuggvenyevel teheti meg
            //amelynek az adott szereplot kell atadni

            //menu
            System.out.println("Mit szeretne felvenni?");
            System.out.println("1.: Alkatreszt");
            System.out.println("2. Eszkozt");

            //a felhasznalo altal beolvasott szam megjelenitese
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String read = buff.readLine();

            if(read.equals("1")){
                //alkatresz felvetele a felvesz(Szereplo) fuggvennyel
                new Pisztoly().felvesz(new Eszkimo());
            }
            if(read.equals("2")){
                //eszkoz felvetele a felvesz(Szereplo) fuggvennyel
                new Kotel().felvesz(new Eszkimo());
            }
        }
        if(str.equals("2")) {
            System.out.println("Targy felvetelehez eloszor fel kell torni");
        }
    }

    /**
     * Alkatreszek osszeszereleset tesztelo fuggveny
     * @throws IOException
     */
    public static void alkatreszekOsszeszereleseTest() throws IOException {
        System.out.println("Alkatreszek osszeszerelese szekvencia");
        System.out.println("Minden alkatresz egy mezon van?");
        System.out.println("1.: Igen\n2.: Nem");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if(str.equals("1")){
            System.out.println(">Listenerrel figyeli a vezerlo, hogy a jateknak vege e: Vezerlo.gyozelem() hivodik majd meg");
            System.out.println("Gratulalok! Gyoztel!");
            System.out.println("<Vezerlo.gyozelem()");
        }
        if(str.equals("2")){
            System.out.println("A jatek meg nem ert veget!");
        }
    }
    
    public void Tabulators(){
        System.out.println("\t");
    }
}
