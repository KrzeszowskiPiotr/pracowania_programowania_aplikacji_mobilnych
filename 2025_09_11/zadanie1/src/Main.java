import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File myObj = new File("przyklad.txt");
        int counter = 0;
        int counter2 = 0;

        int maxTotalFactors = 0;
        int numberWithMaxTotalFactors = 0;

        int maxUniqueFactors = 0;
        int numberWithMaxUniqueFactors = 0;

        // try-with-resources: Scanner will be closed automatically
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                counter2++;
                char firstDigit = data.charAt(0);
                char lastDigit = data.charAt(data.length() - 1);
                if (firstDigit == lastDigit)
                {
                    counter++;
                }
            }
            System.out.println(counter + " " + counter2);
        }





        catch (FileNotFoundException e) {
            System.out.println("nie powiodlo sie");
            e.printStackTrace();
        }
    }
}