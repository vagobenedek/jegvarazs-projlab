/*import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Comparator {
    private static void readOutput(String[] args) throws IOException {
        List<String> notFound;
        String  testString, aOutput, pOutput;
        Integer testNumber;
        int numberOfLines, matched;
        int numberOfTests;
        boolean found = false;
        if (args[0].equals("all")){
            numberOfTests = Integer.parseInt(args[1]);
        }
        else {
            numberOfTests = 1;
        }
        for (int i = 1; i != numberOfTests+1; i++){
            System.out.println(i);
            numberOfLines = 0;
            matched = 0;
            notFound = new ArrayList<>();
            BufferedReader actualOutput;
            BufferedReader preferredOutput = new BufferedReader(new FileReader("./Tesztesetek/Kimeneti/" + (numberOfTests == 1?args[0]:i) +"_kimenet.txt"));
            testNumber = i;
            testString = testNumber.toString();
            System.out.println("Test case: " + testString);
            while ((pOutput = preferredOutput.readLine()) != null){
                System.out.println("This is the print" + testString);
                String var;
                boolean flag = false;
                numberOfLines ++;
                found = false;
                actualOutput = new BufferedReader(new FileReader("./kimenet.txt"));
                var = actualOutput.readLine();
                while (!var.equals(testString)){
                    var = actualOutput.readLine();
                    //System.out.println("This is var: " + (var = actualOutput.readLine()).equals(testString));
                    System.out.println(var + " - " + testString);
                }
                while ( (aOutput = actualOutput.readLine()) != null){
                    if (aOutput.equals("")){
                        break;
                    }
                    if (pOutput.equals(aOutput)){
                        matched++;
                        found = true;
                    }
                }
                if (!found){
                    notFound.add(pOutput);
                }
                actualOutput.close();
            }
            preferredOutput.close();
            System.out.println(matched + "/" + numberOfLines);
            System.out.println("A(z) " + testNumber + "-es szamu teszt " + (matched == numberOfLines?"sikeres": "sikertelen") + " volt.");
            if (matched != numberOfLines){
                System.out.println("A kovetkezo esemenyek nem kovetkeztek be:");
                for (int j = 0; j != notFound.size(); j++){
                    System.out.println("\t" +notFound.get(j));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0){
            System.out.println("A program nem kapott argumentumot.");
            return;
        }
        readOutput(args);
    }
}*/

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Comparator osztaly hasonlitja ossze az elvart es a kapott kimenetet
 */
public class Comparator {
    private static void readOutput(String[] args) throws IOException {
        List<String> notFound;
        String testNumber, aOutput, pOutput;
        int numberOfLines, matched;
        int numberOfTests;
        boolean found = false;
        if (args[0].equals("all")){
            numberOfTests = Integer.parseInt(args[1]);
        }
        else {
            numberOfTests = 1;
        }
        for (int i = 1; i != numberOfTests+1; i++){
            numberOfLines = 0;
            matched = 0;
            notFound = new ArrayList<>();
            BufferedReader actualOutput;
            BufferedReader preferredOutput = new BufferedReader(new FileReader("./Tesztesetek/Kimeneti/" + (numberOfTests == 1?args[0]:i) +"_kimenet.txt"));
            testNumber = preferredOutput.readLine();
            System.out.println("Test case: " + testNumber);
            while ((pOutput = preferredOutput.readLine()) != null){
                numberOfLines ++;
                found = false;
                actualOutput = new BufferedReader(new FileReader("./kimenet.txt"));
                while (!actualOutput.readLine().equals(testNumber));
                while ( (aOutput = actualOutput.readLine()) != null){
                    if (aOutput.equals("")){
                        break;
                    }
                    if (pOutput.equals(aOutput)){
                        matched++;
                        found = true;
                    }
                }
                if (!found){
                    notFound.add(pOutput);
                }
                actualOutput.close();
            }
            preferredOutput.close();
            if (numberOfLines < matched){
                matched = numberOfLines;
            }
            System.out.println(matched + "/" + numberOfLines);
            System.out.println("A(z) " + testNumber + "-es szamu teszt " + (matched == numberOfLines?"sikeres": "sikertelen") + " volt.");
            if (matched != numberOfLines){
                System.out.println("A kovetkezo esemenyek nem kovetkeztek be:");
                for (int j = 0; j != notFound.size(); j++){
                    System.out.println("\t" +notFound.get(j));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0){
            System.out.println("A program nem kapott argumentumot.");
            return;
        }
        readOutput(args);
    }
}
