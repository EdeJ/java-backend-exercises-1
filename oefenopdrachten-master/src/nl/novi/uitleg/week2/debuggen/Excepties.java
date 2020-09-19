package nl.novi.uitleg.week2.debuggen;

import java.io.IOException;


public class Excepties {

    /**
     * Java heeft verschillende ingebouwde excepties, zoals:
     *
     * 1. ArithmeticException
     * 2. ArrayIndexOutOfBoundsException
     * 3. FileNotFoundException
     * 4. IOException
     * 5. NullPointerException
     * 6. StringIndexOutOfBoundException
     */

    static char[] board;

    public static void main(String[] args) {
        voorbeeldArthmeticException();
        voorbeeldArrayIndexOutOfBoundsException();
        voorbeeldFileNotFoundException();
        voorbeeldIOException();
        voorbeeldNullPointerException();
        voorbeeldStringIndexOutOfBoundException();
    }

    //Haal de // weg op de exceptie te gooien.
    public static void voorbeeldArthmeticException() {
        //int cijfer = 12 / 0;
    }

    //Haal de // weg op de exceptie te gooien.
    public static void voorbeeldArrayIndexOutOfBoundsException() {
        int[] nummer = {1,2,3};
        //System.out.println(nummer[4]);
    }

    // Spreekt voor zich
    public static void voorbeeldFileNotFoundException() {

    }

    /**
     *
     * @throws IOException wanneer de code toegang probeert te krijgen tot een bestand dat
     * al in gebruik is of als het lezen of schrijven onverwacht onderbroken wordt.
     */
    public static void voorbeeldIOException() {

    }

    //Haal de // weg op de exceptie te fixen.
    public static void voorbeeldNullPointerException() {
        //board = new char[9];
        System.out.println(board.length);
    }

    //Haal de // weg op de exceptie te fixen.
    public static void voorbeeldStringIndexOutOfBoundException() {
        String s = "aa";
        //if(s.length() >= 77) {
            s.charAt(77);
        //}
    }


}
