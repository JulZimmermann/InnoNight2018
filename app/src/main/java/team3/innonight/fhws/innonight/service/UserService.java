package team3.innonight.fhws.innonight.service;

import team3.innonight.fhws.innonight.R;
import team3.innonight.fhws.innonight.model.User;

public class UserService {

    public static User getUser() {
        return new User("pierre.muster@example.de", R.drawable.ic_user_male_alt, "Pierre", "Muster", "Musterstraße 8", "909999", "Würzburg");

    }

}
