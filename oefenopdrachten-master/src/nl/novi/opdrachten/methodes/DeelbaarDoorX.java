package nl.novi.opdrachten.methodes;

/**
 * Schrijf een methode die twee Integers ontvangt.
 * De eerste parameter heet 'number', de tweede 'divisible'
 * <p>
 * Het is de bedoeling dat je checkt of 'number' deelbaar is door 'divisible'
 * <p>
 * Wanneer het deelbaar is, return het volgende:
 * Het getal: %HIER GETAL% is deelbaar door %HIER DIVISIBLE%.
 * Wanneer het niet deelbaar is:
 * Het getal: %HIER GETAL% is niet deelbaar door %HIER DIVISIBLE%. Verlaag of verhoog het getal
 * %HET GETAL WAARMEE HET VERHOOGT OF VERLAAGD MOET WORDEN%
 * <p>
 * VOORBEELD:
 * <p>
 * De methode ontvangt de getallen 13 en 3, dan zou het resultaat moeten zijn:
 * Het getal: 13 is niet deelbaar door 3. Verlaag het getal met 1.
 * <p>
 * VOORBEELD 2:
 * De methode ontvangt de getallen 14 en 3, dan zou het resultaat moeten zijn:
 * Het getal: 14 is niet deelbaar door 3. Verhoog het getal met 1.
 */

public class DeelbaarDoorX {

    public static void main(String[] args) {

        isDivisible(13, 3);
    }

    private static void isDivisible(int number, int divisible) {

            // Het nummer is deelbaar
        if (number % divisible == 0) {
            System.out.println("Het getal: " + number + " is deelbaar door " + divisible + ".");

            // Het nummer is niet deelbaar
        } else {
            int rest = number % divisible;

            // Het dichtstbijzijnde getal naar beneden
            int closestNumberDown = number - rest;

            // Het dichtstbijzijnde getal naar boven
            int closestNumberUp = (number + divisible) - rest;

            // test code
            System.out.println("closestNumberDown = " + closestNumberDown);
            System.out.println("closestNumberUp = " + closestNumberUp);

            // het nummer is het dichtste bij closestNumberUp
            if ((number - closestNumberDown) > (closestNumberUp - number)) {
                System.out.println("Het getal: " + number + " is niet deelbaar door " +
                        divisible + ". Verhoog het getal met " + (closestNumberUp - number) + ".");

            // het nummer is het dichtste bij closestNumberDown
            } else {
                System.out.println("Het getal: " + number + " is niet deelbaar door " +
                        divisible + ". Verlaag het getal met " + (number - closestNumberDown) + ".");
            }
        }
    }
}
