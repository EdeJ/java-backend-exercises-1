package nl.novi.opdrachten.methodes;

import java.util.ArrayList;
import java.util.List;

/**
 * Gegeven: een lijst met namen zonder hoofdletters van klanten.
 * Opdracht: Een luie stagiair heeft alle klanten in het systeem gezet, maar deze kon de Shift-knop niet vinden.
 * Het is aan jou om alle namen van een hoofdletter aan het begin te voorzien. Maak een methode die een List als
 * parameter ontvangt en de inhoud vervolgens van hoofdletters voorziet.
 * <p>
 * Bonus 1: Zorg ervoor dat tussenvoegsels geen hoofdletter krijgen.
 * Bonus 2: Zorg ervoor dat de eerste letter na een '-' wel een hoofdletter krijgt.
 */

public class Hoofdletters {

    public static void main(String[] args) {
        List<String> curstomerNames = new ArrayList<>();

        curstomerNames.add("nick piraat");
        curstomerNames.add("michael jackson");
        curstomerNames.add("glennis grace");
        curstomerNames.add("dreetje hazes");
        curstomerNames.add("robbie williams");
        curstomerNames.add("michiel de ruyter");
        curstomerNames.add("sjaak polak");
        curstomerNames.add("jan van jansen");
        curstomerNames.add("henk den hartog");
        curstomerNames.add("mo el-mecky");
        curstomerNames.add("fredje kadetje");
        curstomerNames.add("marie van der sloot");

        capitalizeNames(curstomerNames);
//        char myChar = 'c';
//        System.out.println((int) myChar - 96);
//
//        for (int i = 0; i < 100; i++) {
//            System.out.println( i + " " + (char) i );
//        }
    }

    private static void capitalizeNames(List<String> curstomerNames) {
        char letter;
        boolean isDash = false;

        for (String name : curstomerNames) {
            String newName = "";

            String[] parts = name.split(" ");

            for (int i = 0; i < parts.length; i++) {
                String newPart = "";
                for (int j = 0; j < parts[i].length(); j++) {
                    letter = parts[i].charAt(j);
                    if (isDash == true) {
                        letter = Character.toUpperCase(letter);
                        isDash = false;
                    }
                    if (letter == '-') {
                        isDash = true;
                    }
                    newPart += letter;
                }
                parts[i] = newPart;
                if (i == 0 || i == parts.length - 1) {
                    parts[i] = parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1);
                }
                newName += parts[i] + " ";
            }
            System.out.println(newName);
        }
    }
}
