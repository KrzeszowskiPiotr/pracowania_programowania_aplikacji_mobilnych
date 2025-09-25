
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File myObj = new File("przyklad.txt");

        // Zadanie 4.1
        int counter = 0;
        int counter2 = 0;

        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                counter2++;
                char firstDigit = data.charAt(0);
                char lastDigit = data.charAt(data.length() - 1);
                if (firstDigit == lastDigit) {
                    counter++;
                }
            }
            System.out.println("Zadanie 4.1:");
            System.out.println("Liczb, w których pierwsza cyfra jest równa ostatniej: " + counter);
            System.out.println("Łączna liczba wierszy: " + counter2);
        } catch (FileNotFoundException e) {
            System.out.println("Nie powiodło się");
            e.printStackTrace();
        }

        // Zadanie 4.2
        int maxTotalFactors = 0;
        int numberWithMaxTotalFactors = 0;

        int maxUniqueFactors = 0;
        int numberWithMaxUniqueFactors = 0;

        List<Integer> numbers = new ArrayList<>();

        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int number = Integer.parseInt(data);
                numbers.add(number);

                List<Integer> primeFactors = getPrimeFactors(number);
                Set<Integer> uniqueFactors = new HashSet<>(primeFactors);

                if (primeFactors.size() > maxTotalFactors) {
                    maxTotalFactors = primeFactors.size();
                    numberWithMaxTotalFactors = number;
                }

                if (uniqueFactors.size() > maxUniqueFactors) {
                    maxUniqueFactors = uniqueFactors.size();
                    numberWithMaxUniqueFactors = number;
                }
            }

            System.out.println("\nZadanie 4.2:");
            System.out.println("Liczba z największą liczbą czynników pierwszych: " + numberWithMaxTotalFactors + " (" + maxTotalFactors + ")");
            System.out.println("Liczba z największą liczbą różnych czynników pierwszych: " + numberWithMaxUniqueFactors + " (" + maxUniqueFactors + ")");
        } catch (FileNotFoundException e) {
            System.out.println("Nie powiodło się");
            e.printStackTrace();
        }

        // Zadanie 4.3
        int goodTriplets = 0;
        int goodQuintuples = 0;

        try (FileWriter writer = new FileWriter("trojki.txt")) {
            for (int i = 0; i < numbers.size(); i++) {
                for (int j = 0; j < numbers.size(); j++) {
                    for (int k = 0; k < numbers.size(); k++) {
                        int x = numbers.get(i);
                        int y = numbers.get(j);
                        int z = numbers.get(k);
                        if (x != y && y != z && x != z && y % x == 0 && z % y == 0) {
                            goodTriplets++;
                            writer.write(x + " " + y + " " + z + "\n");
                        }
                    }
                }
            }

            for (int a = 0; a < numbers.size(); a++) {
                for (int b = 0; b < numbers.size(); b++) {
                    for (int c = 0; c < numbers.size(); c++) {
                        for (int d = 0; d < numbers.size(); d++) {
                            for (int e = 0; e < numbers.size(); e++) {
                                int u = numbers.get(a);
                                int w = numbers.get(b);
                                int x = numbers.get(c);
                                int y = numbers.get(d);
                                int z = numbers.get(e);
                                Set<Integer> set = new HashSet<>(Arrays.asList(u, w, x, y, z));
                                if (set.size() == 5 && w % u == 0 && x % w == 0 && y % x == 0 && z % y == 0) {
                                    goodQuintuples++;
                                }
                            }
                        }
                    }
                }
            }

            System.out.println("\nZadanie 4.3:");
            System.out.println("Liczba dobrych trójek: " + goodTriplets);
            System.out.println("Liczba dobrych piątek: " + goodQuintuples);

        } catch (IOException e) {
            System.out.println("Błąd zapisu do pliku trojki.txt");
            e.printStackTrace();
        }
    }

    public static List<Integer> getPrimeFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        int n = number;
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }
}
