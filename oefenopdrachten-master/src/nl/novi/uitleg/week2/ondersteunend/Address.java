package nl.novi.uitleg.week2.ondersteunend;

/**
 * Is dit een goede klasse naam? Wat als jouw applicatie ook gebruik gaat maken van MAC- of URI-adressen?
 */
public class Address {


    private String street;
    private String houseNumber, city, state, zipcode;


    public Address(String street, String houseNumber, String city, String state,
                   String zipcode) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public String getState() {
        return state;
    }
}
