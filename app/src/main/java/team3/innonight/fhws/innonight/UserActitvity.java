package team3.innonight.fhws.innonight;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import team3.innonight.fhws.innonight.model.User;

public class UserActitvity  extends AppCompatActivity {

    private User user;

    EditText etEmail;
    EditText etFirstname;
    EditText etSurname;
    EditText etStreet;
    EditText etPostcode;
    EditText etCity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        // get view elements
        etEmail = (EditText) findViewById(R.id.evEmail);
        etFirstname = (EditText) findViewById(R.id.evFirstname);
        etSurname = (EditText) findViewById(R.id.evSecondname);
        etStreet = (EditText) findViewById(R.id.evStreet);
        etPostcode = (EditText) findViewById(R.id.evPostcode);
        etCity = (EditText) findViewById(R.id.evCity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setUserToView();
    }

    private void setUserToView() {

        // get user object from main
        user = (User) getIntent().getSerializableExtra("User");
        if (user == null) return;

        // set attributes
        etEmail.setText(user.getEmail());
        etFirstname.setText(user.getFirstname());
        etSurname.setText(user.getSurname());
        etStreet.setText(user.getStreet());
        etPostcode.setText(user.getPostcode());
        etCity.setText(user.getCity());
    }
}
