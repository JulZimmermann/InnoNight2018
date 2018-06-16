package team3.innonight.fhws.innonight.model;

import java.io.Serializable;

public class User implements Serializable {
    private String email;
    private int icon;
    private String firstname;
    private String surname;
    private String street;
    private String postcode;
    private String city;

    public User() {}

    public User(String email, int icon, String firstname, String surname, String street, String postcode, String city) {
        this.email = email;
        this.icon = icon;
        this.firstname = firstname;
        this.surname = surname;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public int getIcon() {
        return icon;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getStreet() {
        return street;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

}
