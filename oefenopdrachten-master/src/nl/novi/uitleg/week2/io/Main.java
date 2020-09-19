package nl.novi.uitleg.week2.io;

import java.io.IOException;
import java.util.List;

import static nl.novi.uitleg.week2.io.Bestandslezer.*;

public class Main {
    public static void main(String[] args) throws IOException {

        List<User> users = readFile();

        printUsers(users);
        upTheScores(users, 5);
        printUsers(users);

        addUser(users, "Henrik");
        addUser(users, "Jarin");
        addUser(users, "Edwin");
        addUser(users, "Mark");
        addUser(users, "Marc");
        printUsers(users);

        save(users);
    }

    /**
     * Deze methode voegt een user toe aan de gegeven list op basis van de gegeven Name.
     *
     * We hebben vandaag geleerd dat als je een variabele geen waarde geeft bij het initialiseren van de klasse, deze
     * automatisch de waarde 0 krijgt. Deze hoeven we dan ook niet specifiek mee te geven.
     * @param groupOfUsers Lijst met users
     * @param name Naam van de user
     */
    public static void addUser(List<User> groupOfUsers, String name) {
        groupOfUsers.add(new User(name));
    }

    /**
     * Deze methode verhoogt de score van alle gebruikers met @amount.
     * @param groupOfUsers Collectie met gebruikers.
     * @param amount aantal waarmee de score verhoogd moet worden.
     */
    private static void upTheScores(List<User> groupOfUsers, int amount) {
        for(User user : groupOfUsers) {
            user.setScore(user.getScore() + amount);
        }
    }

    /**
     * Print de users met score
     * @param groupOfUsers lijst van user-objecten
     */
    private static void printUsers(List<User> groupOfUsers) {
        for(User user : groupOfUsers) {
            System.out.println(user.getScoreText());
        }
    }
}
