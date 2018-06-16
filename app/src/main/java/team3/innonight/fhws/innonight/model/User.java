package team3.innonight.fhws.innonight.model;

public class User {
    private String email;
    private int icon;
    private String firstname;
    private String surname;
    private String street;
    private int postcode;
    private String city;

    public User(String email, int icon, String firstname, String surname, String street, int postcode, String city) {
        this.email = email;
        this.icon = icon;
        this.firstname = firstname;
        this.surname = surname;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
    }
}
