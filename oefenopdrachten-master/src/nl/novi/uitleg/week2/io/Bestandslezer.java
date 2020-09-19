package nl.novi.uitleg.week2.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bestandslezer {

    private static final String FILE_LOCATION = "src/nl/novi/uitleg/week2/io/bestand.txt";

    /**
     * Deze methode maakt een ArrayList<User> BufferedReader aan.
     * De BufferedReader wordt vervolgens aan de readAllLines methode gegeven om het tekstbestand
     * uit te lezen.
     * @return lege of gevulde lijst met User-objecten.
     */
    public static List<User> readFile() {
        List<User> gebruikers = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_LOCATION));
            gebruikers = readAllLines(bufferedReader);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return gebruikers;
    }

    /**
     * Deze methode is private en kan dus alleen in de Bestandlezer.java klasse aangeroepen worden.
     *
     * Deze code ontvangt een BufferedReader en gaat het tekstbestand dat daaronder hangt regel voor regel
     * uitlezen.
     *
     * Daarna wordt de gelezen regel in een String[] array geplaatst. Vanuit deze array wordt uiteindelijk een
     * User-object aangemaakt. Dit User-object wordt toegevoegd aan de list en uiteindelijk gereturned.
     *
     * Deze methode is eigenlijk te groot. Deze heeft te veel verantwoordlijkheden. Het maken van een object op basis
     * van een String of Array zou ik bijvoorbeeld in een andere methode of klasse zetten.
     * Kun je verzinnen hoe dat moet? Deze oplossing is meer het niveau van Java 1.
     *
     * @param bufferedReader De bufferedreader met een FileReader en de locatie naar het tekstbestand
     * @return Lijst met user-objecten.
     * @throws IOException wanneer er iets fout gaat in de IO-operatie.
     */
    private static List<User> readAllLines(BufferedReader bufferedReader)  throws IOException {
        List<User> gebruikers = new ArrayList<>();
        String line;
        while((line = bufferedReader.readLine()) != null) {
            String[] inhoudRegel = line.split("\\|");

            String username = inhoudRegel[0];
            String score = inhoudRegel[1].trim();
            int scoreConverted;
            try {
                scoreConverted = Integer.parseInt(score);
            } catch (NumberFormatException numberFormatException) {
                scoreConverted = 0;
            }

            User user = new User(username, scoreConverted);
            gebruikers.add(user);

        }
        return gebruikers;
    }

    /**
     * Deze methode ontvangt een lijst met User-objecten. Deze worden met een methode uit het user-object omgevormd
     * naar Strings die opgeslagen kunnen worden.
     * @param users Lijst van users die opgeslagen moeten worden.
     * @throws IOException wanneer er iets foutgaat met het opslaan.
     */
    public static void save(List<User> users) throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter(FILE_LOCATION);
            for (User user : users) {
                String lineToSave = user.getTextToSave();
                writer.write(lineToSave + "\r\n");
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            writer.close();
        }
    }


    /**
     * Deze methode schrijft een lege String weg naar het tekstbestand. Alle data verdwijnt dus na het aanroepen van
     * deze methode.
     *
     * Public methode, dus deze kan van buiten deze klasse aangeroepen worden.
     *
     * @throws IOException wanneer er iets fout gaat met het wegschrijven.
     */
    public static void emptyFile() throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter(FILE_LOCATION);
            writer.write("");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            writer.close();
        }
    }

}
