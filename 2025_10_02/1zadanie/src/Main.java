import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String decyzja = "t";

        do {
            System.out.println("Ile kostek chcesz rzucić? (3-10)");
            int n = 0;
            do {
                while (!sc.hasNextInt()) {
                    System.out.println("To nie jest liczba. Podaj liczbę od 3 do 10:");
                    sc.next(); //
                }
                n = sc.nextInt();
            } while (n < 3 || n > 10);

            int[] wyniki = new int[n];
            for (int i = 0; i < n; i++) {
                int losowa = LosowanieWartosci();
                wyniki[i] = losowa;
                System.out.println("Kostka " + (i + 1) + ": " + losowa);
            }

            int sumaPunktow = SumowaniePunktow(wyniki);
            System.out.println("Liczba uzyskanych punktów: " + sumaPunktow);

            System.out.println("Jeszcze raz? (t/n)");
            sc.nextLine();
            decyzja = sc.nextLine().trim().toLowerCase();

        } while (decyzja.equals("t"));

        sc.close();
        System.out.println("Dziękujemy za grę!");
    }

    public static int LosowanieWartosci() {
        return (int)(Math.random() * 6) + 1;
    }

    public static int SumowaniePunktow(int[] tablicaWynikow) {
        int suma = 0;
        for (int i = 0; i < tablicaWynikow.length; i++) {
            suma += tablicaWynikow[i];
        }
        return suma;
    }
}
