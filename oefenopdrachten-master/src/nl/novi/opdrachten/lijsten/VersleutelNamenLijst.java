package nl.novi.opdrachten.lijsten;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VersleutelNamenLijst {

    /**
     * Bijgevoegd is verzetsleden.txt
     * Maak een programma dat verzetsleden.txt uitleest.
     * Versleutel de namen op dezelfde manier als in GeheimeCode.java
     * En sla de versleutelde namen op in secret.txt
     */
    public static void main(String[] args) throws IOException {

        File file = new File("src/nl/novi/opdrachten/lijsten/verzetsleden.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String name;
        List<String> members = new ArrayList<>();
        while ((name = reader.readLine()) != null) {
            System.out.println(name);
            members.add(name);
        }

        System.out.println(deHashMembers(members));

//        List<String> hashedMembers = hashMembers(members);
//        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//        for (String hashedMember : hashedMembers) {
//            writer.write(hashedMember + "\n");
//        }
//        writer.close();
    }

    private static List<String> hashMembers(List<String> members) {

        List<String> hashedMembers = new ArrayList<>();
        char letter;

        // loop door je members
        for (int i = 0; i < members.size(); i++) {

            // get name of a member
            String name = members.get(i);

            // create a empty string that will contain the hasedName
            String hashedName = "";

            // loop trough all the letters of the name
            for (int j = 0; j < name.length(); j++) {

                // get one letter
                letter = name.charAt(j);

                // cast letter to number. this is the ascii code of the letter.
                // subtract 96 if the letter is lowercase or add 36 if letter is not lowercase (Uppercase)
                hashedName += Character.isLowerCase(letter) ? (int) letter - 96 : (int) letter + 36;
                hashedName += (j < name.length() - 1) ? "-" : "";
            }

            // if name in list is even numer, turn around the string;
            if (i % 2 != 0) {
                hashedName = new StringBuilder(hashedName).reverse().toString();
            }
            hashedMembers.add(hashedName);
        }
        return hashedMembers;
    }

    private static List<String> deHashMembers(List<String> hashedMembers) {
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
                letter = (index < 100) ? (char) (index + 96) : (char) (index - 36);
                name += letter;
            }
            members.add(name);
        }
        return members;
    }
}
