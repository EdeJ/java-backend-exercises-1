package nl.novi.opdrachten.methodes;

import java.util.ArrayList;
import java.util.List;

/**
 * Schrijf een methode  die een List<Integer> ontvangt.
 * <p>
 * Wanneer er twee getallen of meer in zijn:
 * Return het volgende:
 * "Het hoogste getal van de gegeven getallen is: %GETAL%"
 * <p>
 * Je mag hier geen Collections.sort of java.streams gebruiken.
 */
public class HoogsteGetalAbstract {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(6);
        numbers.add(82);
        numbers.add(8);

        highestValue(numbers);
    }

    public static void highestValue(List<Integer> numbers) {
        if (numbers.size() > 1) {
            int highestNumber = 0;
            for (int number : numbers) {
                if (number > highestNumber) {
                    highestNumber = number;
                }
            }
            System.out.println("Het hoogste getal van de gegeven getallen is: " + highestNumber);
        } else {
            System.out.println("Voeg minimaal twee getallen aan de lijst toe!");
        }
    }
}
