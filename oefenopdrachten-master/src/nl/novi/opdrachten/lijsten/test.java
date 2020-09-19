package nl.novi.opdrachten.lijsten;

import java.util.ArrayList;
import java.util.List;

public class test {


        public static void main(String[] secret) {
            List<String> laResistanceMembers = new ArrayList<>();
            laResistanceMembers = addMembers(laResistanceMembers, "Arie");
            laResistanceMembers = addMembers(laResistanceMembers, "Sjaak");
            laResistanceMembers = addMembers(laResistanceMembers, "Henrie");
            laResistanceMembers = addMembers(laResistanceMembers, "Piet");
            laResistanceMembers = addMembers(laResistanceMembers, "Piet");
            laResistanceMembers = addMembers(laResistanceMembers, "LeDroitCestMoi");
//      opdracht 1

            System.out.println("TEST");

            String test = "Arie";
            int chr = test.charAt(0);
            System.out.println((chr - 'a' + 1));


            System.out.println("Opdracht 1 \nprint LijstNamen");
            addMembers(laResistanceMembers, "Henk");
            printList(laResistanceMembers);
            System.out.print("\n\n");
        /*
        Opdracht 1: Hierboven zijn via de methode addMembers, leden aan de lijst toegevoegd. Pas de Methode zo aan dat
         er alleen unieke namen in voor mogen komen.
         */
        /*
        Opdracht 2: La Resistance wil niet dat de lijst met namen zo in handen komt te vallen van de bezetter. Versleutel
        Maak een methode die de lijst op de volgende manier versleuteld:
        a) Verander elke letter naar het nummer in het alfabet. Voeg na elke veranderde letter een - toe
        (behalve de laatste). Dus a wordt 1, b wordt 2 et cetera.
        Wanneer een letter een hoofdletter is, moet je beginnen met tellen bij 100. Dus A wordt 101, B wordt 102.
        Voorbeeld: Alex wordt versleuteld naar: 101-12-5-24
        b) Als de positie in de lijst een even getal is, dan moet de cijfercombinatie omgedraaid worden.
         */
            System.out.println("Opdracht 2 \nEncryptNames");
            String notEncryptedWord = "";
            for (int i = 0; i < laResistanceMembers.size(); i++) {
                String result = "";
                result = encryptWord(laResistanceMembers.get(i));
//
//                System.out.println("TEST**");
//                System.out.println(" " + result);
                laResistanceMembers.set(i, result);
            }
            printList(laResistanceMembers);
            System.out.print("\n\n");
        /*
        Opdracht 3:
        Schrijf een methode die de versleutelde lijst kan omzetten naar de ontsleutelde lijst.
         */
            System.out.println("Opdracht 3 \nDecryptingNames");
            String secretCodeName = "";
            for (int i = 0 ; i <  laResistanceMembers.size(); i++ ){
                secretCodeName = laResistanceMembers.get(i);
                String result = decryptCodeNames(secretCodeName);
                laResistanceMembers.set(i, result);
            }
            printList(laResistanceMembers);
        }
        private static String decryptCodeNames(String secretCodeName) {
            List<Integer> listOfIndexes = new ArrayList<>();
            listOfIndexes.add(0);
            List<String> listOfNumbers = new ArrayList<>();
            // find the index of all numbers
            for (int i = 0; i < secretCodeName.length(); i++) {
                char c = secretCodeName.charAt(i);
                if (c == 45) {
                    listOfIndexes.add(i + 1);
                }
            }
            // create a list of the numbers
            for (int i = 0; i < listOfIndexes.size(); i++) {
                if (i == listOfIndexes.size()-1) {
                    String result = secretCodeName.substring(listOfIndexes.get(i));
                    listOfNumbers.add(result);
                } else {
                    String result = secretCodeName.substring(listOfIndexes.get(i), listOfIndexes.get(i + 1) - 1);
                    listOfNumbers.add(result);
                }
            }
            // switch the even numbers
            for (int i = 0; i < listOfNumbers.size(); i++) {
                if (i > 0 & i % 2 == 0 & listOfNumbers.get(i).length() > 1) {
                    int value = Integer.parseInt(listOfNumbers.get(i));
                    String temp = convertEvenNumbers(value);
                    listOfNumbers.set(i, temp);
                }
            }
            // now decrypt to letters en reform the list
            String decryptedWord = "";

            for(int i = 0; i < listOfNumbers.size(); i++ ){
                int number = Integer.parseInt(listOfNumbers.get(i));
                if(number >= 1 & number <=26){
                    //from alfabet to charnumbers not capitalized
                    int charNumber = number + 96;
                    char ch = (char) charNumber;
                    decryptedWord = decryptedWord + ch;
                    //from alfabet to charnumbers  capitalized
                }else if(number >= 100 & number < 126){
                    int charNumber = number - 35;
                    char ch = (char) charNumber;
                    decryptedWord = decryptedWord + ch;
                }else {
                    System.out.println("error");
                }
            }
            return decryptedWord;
        }
        private static int encryptLettersToNumbers(String notEncryptedWord, int i) {
            int chr = notEncryptedWord.charAt(i);
            int tempResult = 0;
            if (chr >= 97 & chr < 123) {
                tempResult = chr - 'a' + 1;
            } else if (chr >= 65 & chr < 92) {
                tempResult = chr + 35;
            } else {
                System.out.println("Error");
            }
            return tempResult;
        }
        private static String encryptWord(String notEncryptedWord) {
            String encryptedWord = "";
            for (int i = 0; i < notEncryptedWord.length(); i++) {
                int tempResult = 0;
                String encryptedLetter = "";
                tempResult = encryptLettersToNumbers(notEncryptedWord, i);
                System.out.println("temp result" + tempResult);
                String value = tempResult + "";
                // At an even number > 0
                if (i > 0 & i % 2 == 0) {
                    value = convertEvenNumbers(tempResult);
                }
                // Setting the lines except on the last value
                if (i == notEncryptedWord.length() - 1) {
                    encryptedLetter = value + "";
                } else {
                    encryptedLetter = value + "-";
                }
                encryptedWord = encryptedWord + encryptedLetter;
            }
            return encryptedWord;
        }

        private static String convertEvenNumbers(int result) {
            String switchNumbers = Integer.toString(result);
            String afterSwitchNumbers = "";

            System.out.println("TEST switchnumber" + switchNumbers);

            if (switchNumbers.length() == 2) {
                char a = switchNumbers.charAt(0);
                char b = switchNumbers.charAt(1);
                afterSwitchNumbers = String.valueOf(b) + String.valueOf(a);
            } else if (switchNumbers.length() == 3) {
                char a = switchNumbers.charAt(0);
                char b = switchNumbers.charAt(1);
                char c = switchNumbers.charAt(2);
                afterSwitchNumbers = String.valueOf(c) + String.valueOf(b) + String.valueOf(a);
            } else afterSwitchNumbers = String.valueOf(switchNumbers.charAt(0));
            return (afterSwitchNumbers);
        }
        private static List<String> addMembers(List<String> members, String name) {
            if (!members.contains(name)) {
                members.add(name);
            }
            return members;
        }
        private static void printList(List<String> members) {
            for (String names : members) {
                System.out.println(names);
            }
        }
    }

