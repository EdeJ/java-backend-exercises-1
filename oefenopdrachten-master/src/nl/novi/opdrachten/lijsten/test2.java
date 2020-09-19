package nl.novi.opdrachten.lijsten;

import java.util.ArrayList;
import java.util.List;

public class test2 {

    public static void main(String[] secret) {

        String name;


        List<String> laResistanceMembers = new ArrayList<>();

        laResistanceMembers = addMembers(laResistanceMembers, "Arie");
        laResistanceMembers = addMembers(laResistanceMembers, "Sjaak");
        laResistanceMembers = addMembers(laResistanceMembers, "Henrie");
        laResistanceMembers = addMembers(laResistanceMembers, "Henrie");
        laResistanceMembers = addMembers(laResistanceMembers, "Piet");
        laResistanceMembers = addMembers(laResistanceMembers, "LeDroitCestMoi");

        // i+1 omdat een ledenlijst niet bij 0 kan beginnen
        System.out.println("Memberlist:");

        for (int i = 0; i < laResistanceMembers.size(); i++) {
            String encryptedName = encryptMembers(laResistanceMembers.get(i), i + 1);
            laResistanceMembers.set(i, encryptedName);
            System.out.println(laResistanceMembers.get(i));
        }

        System.out.println("That's encrypted, now let's decrypt");
        //terugzetten naar naam
        for (int j = 0; j < laResistanceMembers.size(); j++) {
            String decryptedName = decryptMembers(laResistanceMembers.get(j), j + 1);
            laResistanceMembers.set(j, decryptedName);
            System.out.println(laResistanceMembers.get(j));
        }
    }
    /*
    Opdracht 1: Hierboven zijn via de methode addMembers, leden aan de lijst toegevoegd. Pas de Methode zo aan dat
     er alleen unieke namen in voor mogen komen.
     */
    private static List<String> addMembers(List<String> members, String name) {
        boolean memberExists = members.contains(name);
        if (memberExists == true) {
            System.out.println(name + " staat al in de lijst, en kan niet nogmaals opgenomen worden.\n");
            return members;
        } else {
            members.add(name);
            return members;
        }
    }
    /*
    Opdracht 2: La Resistance wil niet dat de lijst met namen zo in handen komt te vallen van de bezetter. Versleutel
    Maak een methode die de lijst op de volgende manier versleuteld:
    a) Verander elke letter naar het nummer in het alfabet. Voeg na elke veranderde letter een - toe
    (behalve de laatste). Dus a wordt 1, b wordt 2 et cetera.
    Wanneer een letter een hoofdletter is, moet je beginnen met tellen bij 100. Dus A wordt 101, B wordt 102.
    Voorbeeld: Alex wordt versleuteld naar: 101-12-5-24
    b) Als de positie in de lijst een even getal is, dan moet de cijfercombinatie omgedraaid worden.
    */
    private static String encryptMembers(String name, int i) {

        ArrayList<Integer> numbersForNameLetters;

        numbersForNameLetters = new ArrayList<>();

        int numberOfChar;
        boolean charCapital;

        //Eerst bepalen of de positie op de naamlijst even is. Bij oneven de naam omdraaien.
        if (i % 2 == 0) {
            name = new StringBuffer(name).reverse().toString();
            //System.out.println(name);
        }
        char[] nameToLetters = name.toCharArray();
        int lengthName = nameToLetters.length;
        /* controle regels om te kijken of lengte goed bepaald wordt en letters los doorgegeven.
        System.out.println("Char Array length: " + lengthName);
        System.out.println("Char Array elements: ");
        for (int j = 0; j < lengthName; j++) {
            System.out.println(nameToLetters[j]);
        }
        */
        //Bepalen of karakter hoofdletter is, om daarna de numerieke waarde mee te geven
        for (int k = 0; k < lengthName; k++) {
            if (Character.isUpperCase(nameToLetters[k])) {
                charCapital = true;
            } else {
                charCapital = false;
            }
            if (charCapital) {
                numberOfChar = Character.getNumericValue(nameToLetters[k]) - 9 + 100;
            } else {
                numberOfChar = Character.getNumericValue(nameToLetters[k]) - 9;
            }
            numbersForNameLetters.add(numberOfChar);
        }
        //de gemaakte string omzetten naar het gewenste formaat
        System.out.println(String.valueOf("TEST" + numbersForNameLetters));
        String numbersName = String.valueOf(numbersForNameLetters);
        String codedName = numbersName.replace(", ", "-");
        codedName = codedName.replace("[", "");
        codedName = codedName.replace("]", "");
        return codedName;
    }
    /*
    Opdracht 3:
    Schrijf een methode die de versleutelde lijst kan omzetten naar de ontsleutelde lijst.
     */
    private static String decryptMembers(String name, int j) {
        List<Character> decrCharForName;
        decrCharForName = new ArrayList<>();
        char letterOfNumber;
        boolean decrCapital = true;
        String decryptedName = new String();
        //eerst de String uit elkaar halen
        String[] numbersFromName = name.split("-");
        for (int l = 0; l < numbersFromName.length; l++) {
            int intNumbersFromName = Integer.parseInt(numbersFromName[l]);
            if (intNumbersFromName <= 99) {
                decrCapital = false;
            }else {
                decrCapital = true;
            }
            if (decrCapital) {
                intNumbersFromName = intNumbersFromName + 9 - 100;
                char tocapLetter = Character.forDigit(intNumbersFromName, 35);
                letterOfNumber = Character.toUpperCase(tocapLetter);
                //System.out.println(letterOfNumber);
            } else {
                intNumbersFromName = intNumbersFromName + 9;
                letterOfNumber = Character.forDigit(intNumbersFromName, 35);
                //System.out.println(letterOfNumber);
            }
            decrCharForName.add(letterOfNumber);
            decryptedName = String.valueOf(decrCharForName);
            decryptedName = decryptedName.replace(", ", "");
            decryptedName = decryptedName.replace("[", "");
            decryptedName = decryptedName.replace("]", "");
            if (j%2==0) {
                decryptedName = new StringBuffer(decryptedName).reverse().toString();
            }
        }
        return decryptedName;
    }
}
