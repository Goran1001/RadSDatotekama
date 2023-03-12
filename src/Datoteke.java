import java.io.*;

public class Datoteke {
    public static void main(String[] args) throws IOException {

        java.util.Scanner input = new java.util.Scanner(System.in);

        double brojKilometara;
        double konverzijskiFaktor;

        System.out.println("Unesite broj kilometara kao decimalni broj, npr. 3,15: ");
        do {
            brojKilometara = input.nextDouble();
            if (brojKilometara <= 0)
                System.out.println("Niste unijeli pozitivan broj kilometara. Pokušajte ponovo: ");

        } while (brojKilometara <= 0);

        System.out.println("Unesite konverzijski faktor za konverziju kilometara u milje, npr: 1,6: ");
        do {
            konverzijskiFaktor = input.nextDouble();
            if (konverzijskiFaktor <= 0)
                System.out.println("Niste unijeli pozitivan broj za konverzijski faktor. Pokušajte ponovo: ");

        } while (konverzijskiFaktor <= 0);



        double brojMiljaDecimalni = (brojKilometara / konverzijskiFaktor);
        int brojMilja = (int) brojMiljaDecimalni;
        System.out.println("Uneseno je " + brojKilometara + " km, što je " + brojMilja + " milja.");


        try {
            FileWriter writer = new FileWriter("konverzijski_faktor.txt");
            writer.write(Double.toString(konverzijskiFaktor));
            writer.close();
            System.out.println("Konverzijski faktor spremljen u datoteku.");
        } catch (IOException e) {
            System.out.println("Greška pri spremanju konverzijskog faktora u datoteku.");
            e.printStackTrace();
        }

        BufferedReader reader = new BufferedReader(new FileReader("konverzijski_faktor.txt"));
        double konverzijskiFaktorFromFile = Double.parseDouble(reader.readLine());

        System.out.print("Enter conversion factor: ");
        double konverzijskiFaktorFromUser = input.nextDouble();

        if (konverzijskiFaktorFromUser == konverzijskiFaktorFromFile) {
            System.out.println("Konverzijski faktor odgovara onom u datoteci.");
        } else {
            System.out.println("Konverzijski faktor ne odgovara onom u datoteci.");
        }

        input.close();
        reader.close();

    }

}
