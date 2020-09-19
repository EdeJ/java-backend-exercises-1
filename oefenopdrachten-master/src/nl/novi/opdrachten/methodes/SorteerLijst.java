package nl.novi.opdrachten.methodes;


import java.util.*;

/**
 * Schrijf een methode  die een List<Integer> ontvangt.
 * <p>
 * Check in de methode of deze list 3 entries heeft.
 * <p>
 * Wanneer dit niet zo is: return de foutmelding: "Er zijn te veel of te weinig getallen in de lijst."
 * BONUS: Kun je een foutmelding voor te veel en een foutmelding voor te weinig maken?
 * <p>
 * Wanneer er wel drie getallen in zijn:
 * Return het volgende:
 * Een list met getallen gesorteerd van laag naar hoog.
 * <p>
 * Je mag hier geen Collections.sort of java.streams gebruiken.
 */
public class SorteerLijst {

    public static void main(String[] argeblabla) {

        List<Integer> wrongList = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 6, 7, 8));
        List<Integer> wrongList2 = new ArrayList<>(Arrays.asList(17, 23));
        List<Integer> correctList = new ArrayList<>(Arrays.asList(88, 888, 909909));
        List<Integer> correctList2 = new ArrayList<>(Arrays.asList(67, 2, 777));

//        sortThreeNumbers(wrongList);
//        sortThreeNumbers(wrongList2);
       // List<Integer> sortedList = sortThreeNumbers(correctList2);

        checkList(correctList2);
       // System.out.println(sortedList);
    }

    public static List<Integer> sortThreeNumbers(List<Integer> numbers) {
        if (numbers.size() < 3) {
            System.out.println("Er zijn te weinig getallen in de lijst.");
        } else if (numbers.size() > 3) {
            System.out.println("Er zijn te veel getallen in de lijst.");
        } else {

            int highestNumber = 0;
            for (int number : numbers) {
                if (number > highestNumber) {
                    highestNumber = number;
                }
            }

           // Collections.sort(numbers);
            return numbers;
        }
        return null;
    }

    public static void checkList(List<Integer> a) {
        String result = "";
        if (a.size() > 3) {
            System.out.println("Er zijn te veel getallen in de lijst");
        } else if (a.size() < 3) {
            System.out.println("Er zijn te veel getallen in de lijst");
        } else {
            for (int i = 0; i < a.size() ; i++) {
                for (int j = 0; j < a.size() - 1 - i; j++) {
                    if (a.get(j) > a.get(j + 1)) {
                        int temp = a.get(j);
                        a.set(j, a.get(j + 1));
                        a.set(a.get(j + 1), temp);
                    }
                }
            }
            for (int i = 0; i < a.size(); i++) {
                for (int j = i + 1; j < a.size(); j++) {
                    int tmp = 0;
                    if (a.get(i) > a.get(j)) {
                        tmp = a.get(i);
                        a.set(i, a.get(j));
                        a.set(j, tmp);
                    }
                }
            }

            System.out.println("Er zijn 3 getallen in de lijst.");
            System.out.println(a);
        }

    }
}
