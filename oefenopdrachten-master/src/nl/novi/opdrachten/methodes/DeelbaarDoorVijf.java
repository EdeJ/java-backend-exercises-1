package nl.novi.opdrachten.methodes;

/**
 * Schrijf een methode die een Integer ontvangt.
 * Wanner het getal deelbaar is door 11, laat hem de volgende tekst returnen:
 * 'deelbaar door vijf'
 * Wanneer het getal niet deelbaar is door vijf:
 * 'ondeelbaar door vijf'
 */
public class DeelbaarDoorVijf {

    public static void main(String[] sammieKijkOmhoog) {

        int chosenNumber = 44;

        isDivisibleByFive(chosenNumber);

    }
    private static void isDivisibleByFive(int chosenNumber) {
        if(chosenNumber % 5 == 0) {
            System.out.println("deelbaar door vijf");
        } else {
            System.out.println("ondeelbaar door vijf");
        }
    }
}
