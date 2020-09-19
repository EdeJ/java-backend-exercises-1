package nl.novi.opdrachten.lijsten;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListOefening {

    public static void main(String[] uitlegList) {

        //We hebben een list die de namen van voetbalclubs bevat
        List<String> clubNames = new ArrayList<>();
        //Die vullen we alvast voor de opdracht
        clubNames.add("Ajax");
        clubNames.add("PSV");
        clubNames.add("Feyenoord");
        clubNames.add("Fc Utrecht");
        clubNames.add("Fc Groningen");
        clubNames.add("FC Twente");

        if(checkList(clubNames, "PSV")) {
            System.out.println("waar");
        } else  {
            System.out.println("niet waar");
        }

        // Vraag -1: Maak een methode die als taak heeft om de list per regel uit te printen.
        printClubs(clubNames);
        System.out.println("---");

        // Vraag 0: Maak een methode die als taak heeft om de list uit te printen: positie + inhoud.
        // Bovenstaande list zou dan dit zijn:
        // 0 - Ajax
        // 1 - PSv
        // etc...
        printClubsWidthIndex(clubNames);
        System.out.println("---");

        // Vraag 1: Maak een methode die checkt of een club al in de lijst zit en voeg deze anders toe.
        addClub(clubNames, "F.C. Knudde");
        addClub(clubNames, "F.C. Knudde");
        addClub(clubNames, "Ajax");
        System.out.println("---");

        // Vraag 2: Maak een methode die de positie van de club in de lijst teruggeeft.
        System.out.println("Index is: " + showIndex(clubNames, "PSV"));
        System.out.println("Index is: " + showIndex(clubNames, "Ajax"));

        // Vraag 3: Maak een methode die de lijst alfabetisch sorteert. Wanneer Ajax niet op positie 1 staat, moeten de
        // clubs die voor Ajax staan verwijderd worden.
        // We voegen nog wat clubs toe om de code te kunnen testen.
        clubNames.add("AA Aachen");
        clubNames.add("AFC Amsterdam");
        clubNames.add("AFC");

        System.out.println("---");
        printClubs(clubNames);

        System.out.println("--- clubs gesorteerd ---");
        orderClipStart(clubNames, "Ajax");
        printClubs(clubNames);
        System.out.println("---");

        // Vraag 4: Kun je hetzelfde doen als hierboven, maar PSV moet dan laatste zijn.
        clubNames.add("Zlotty FC");
        clubNames.add("SC Eindhoven");
        printClubs(clubNames);
        System.out.println("---");
        orderClipEnd(clubNames, "PSV");
        System.out.println("---");
        printClubs(clubNames);

    }

    public static void printClubs(List<String> clubNames) {
        for (String name : clubNames) {
            System.out.println(name);
        }
    }

    public static void printClubsWidthIndex(List<String> clubNames) {
        for (int i = 0; i < clubNames.size(); i++) {
            System.out.println(i + " - " + clubNames.get(i));
        }
    }

    public static boolean addClub(List<String> clubNames, String name) {
        for (String club : clubNames) {
            if (club.equalsIgnoreCase(name)) {
                System.out.println(name + " bestaat al in de lijst, " + name + " is niet toegevoegd");
                return false;
            }
        }
        clubNames.add(name);
        System.out.println(name + " is toegevoegd");
        return true;
    }

    public static int showIndex(List<String> clubNames, String name) {
        for (int i = 0; i < clubNames.size(); i++) {
            if (clubNames.get(i).equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public static void orderClipStart(List<String> clubNames, String clubName) {
        Collections.sort(clubNames);
        int i = 0;
        String name;
        while (i < clubNames.size()) {
            name = clubNames.get(i);
            if (i == 0 && !name.equalsIgnoreCase(clubName)) {
                clubNames.remove(0);
            } else {
                i++;
            }
        }
    }

    public static void orderClipEnd(List<String> clubNames, String clubName) {
        Collections.sort(clubNames);
        int i = clubNames.size() - 1;
        while (i > 0) {
            if (!clubNames.get(i).equalsIgnoreCase(clubName)) {
                System.out.println("club " + clubNames.get(i) + " is niet PSV");
                clubNames.remove(i);
                i--;
            } else {
                break;
            }

        }
    }

    public static boolean checkList(List<String> clubNames, String item) {
        for (int i = 0; i < clubNames.size(); i++) {
            if (item.equals(clubNames.get(i))) {
                return true;
            }
        }
        return false;
    }

}
