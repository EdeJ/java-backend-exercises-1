package nl.novi.opdrachten.lijsten;

import java.util.ArrayList;
import java.util.List;

public class GeheimeCode {

    public static void main(String[] secret) {

        List<String> laResistanceMembers = new ArrayList<>();

        laResistanceMembers = addMembers(laResistanceMembers, "Arie");
        laResistanceMembers = addMembers(laResistanceMembers, "Sjaak");
        laResistanceMembers = addMembers(laResistanceMembers, "Henrie");
        laResistanceMembers = addMembers(laResistanceMembers, "Piet");
        laResistanceMembers = addMembers(laResistanceMembers, "LeDroitCestMoi");

        /*
        Opdracht 1: Hierboven zijn via de methode addMembers, leden aan de lijst toegevoegd. Pas de Methode zo aan dat
         er alleen unieke namen in voor mogen komen.
         */
        printMembers(laResistanceMembers);
        laResistanceMembers = addMembers(laResistanceMembers, "Kees");
        laResistanceMembers = addMembers(laResistanceMembers, "Arie");

        System.out.println("---");

        printMembers(laResistanceMembers);
        //printList(hashMembers(laResistanceMembers));
        List<String> hashedMembers = hashMembers(laResistanceMembers);
        printMembers(hashedMembers);
        printMembers(deHashMembers(hashedMembers));

        /*
        Opdracht 2: La Resistance wil niet dat de lijst met namen zo in handen komt te vallen van de bezetter. Versleutel
        Maak een methode die de lijst op de volgende manier versleuteld:
        a) Verander elke letter naar het nummer in het alfabet. Voeg na elke veranderde letter een - toe
        (behalve de laatste). Dus a wordt 1, b wordt 2 et cetera.
        Wanneer een letter een hoofdletter is, moet je beginnen met tellen bij 100. Dus A wordt 101, B wordt 102.
        Voorbeeld: Alex wordt versleuteld naar: 101-12-5-24
        b) Als de positie in de lijst een even getal is, dan moet de cijfercombinatie omgedraaid worden.
         */

        /*
        Opdracht 3:
        Schrijf een methode die de versleutelde lijst kan omzetten naar de ontsleutelde lijst.
         */
    }

    private static List<String> addMembers(List<String> members, String name) {
        boolean memberExist = false;
        for (String member : members) {
            if (member.equalsIgnoreCase(name)) {
                memberExist = true;
                break;
            }
        }
        if (!memberExist) {
            members.add(name);
            System.out.println(name + " is toegevoegd aan de lijst");
        } else {
            System.out.println(name + " staat al in de lijst, " + name + " is niet toegevoegd");
        }
        return members;
    }

    private static List<String> hashMembers(List<String> members) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> hashedMembers = new ArrayList<>();
        char letter;

        for (int i = 0; i < members.size(); i++) {
            String name = members.get(i);
            String hashedName = "";
            for (int j = 0; j < name.length(); j++) {
                letter = name.charAt(j);
                hashedName += Character.isLowerCase(letter) ? alphabet.indexOf(letter) + 1 : alphabet.indexOf(Character.toLowerCase(letter)) + 101;
                hashedName += (j < name.length() - 1) ? "-" : "";
            }
            if (i % 2 != 0) {
                hashedName = new StringBuilder(hashedName).reverse().toString();
            }
            hashedMembers.add(hashedName);
        }
        return hashedMembers;
    }

    private static List<String> deHashMembers(List<String> hashedMembers) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> members = new ArrayList<>();
        char letter;
        int index;

        for (int i = 0; i < hashedMembers.size(); i++) {
            String hashedName = hashedMembers.get(i);
            String name = "";
            if (i % 2 != 0) {
                hashedName = new StringBuilder(hashedName).reverse().toString();
            }
            String[] parts = hashedName.split("-");
            for (int j = 0; j < parts.length; j++) {
                index = Integer.parseInt(parts[j]);
                letter = (index < 100) ? alphabet.charAt(index - 1) : Character.toUpperCase(alphabet.charAt(index - 101));
                name += letter;
            }
            members.add(name);
        }
        return members;
    }

    private static void printMembers(List<String> members) {
        for (String name : members) {
            System.out.println(name);
        }
    }


}
