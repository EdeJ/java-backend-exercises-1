package nl.novi.uitleg.week2.ondersteunend;

public class User {

    private String firstName;
    private String lastName;
    private String street;
    private String houseNumber, city, state, zipcode;

    // State kan zowel staat als in provincie betekent, maar ook de 'state' van een programma. Je zou ervoor kunnen
    // kiezen om de variabele dan (allemmaal voor consistency) zo te noemen:
    private String addrFistName, addrLastName, addrStreet, addrHouseNumber, addrCity, addrState, addrZipCode;

    // Bovenstaande is niet alleen klote typen (overal Addr voor), je kunt in java ook gewoon data sorteren op basis van
    // een klasse:

    private Address adress;

    public User() {
        
    }

}
