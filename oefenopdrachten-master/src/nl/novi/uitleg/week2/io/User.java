package nl.novi.uitleg.week2.io;

public class User {

    private String username;
    private int score;

    public User(String username) {
        this.username = username;
    }

    public User(String username, int score) {
        this.username = username;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Returns a beautified String to be printed
     * @return a beautified String to be printed
     */
    public String getScoreText() {
        String text = "Speler: " + username + " en de score is: " + score;
        return text;
    }

    /**
     * returns a String to be saved to a textfile
     * @return a String to be saved to a textfile
     */
    public String getTextToSave() {
        return username + " | " + score;
    }
}
