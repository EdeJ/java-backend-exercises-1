package nl.novi.uitleg.week2.ondersteunend;

public class Company {
    private String city, adress, houseNumber;

    private Address address;

    public Company(Address address) {
        this.address = address;
    }

    public String getState() {
        return address.getState();
    }



}
