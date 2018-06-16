package team3.innonight.fhws.innonight;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import team3.innonight.fhws.innonight.model.User;

public class UserActitvity  extends AppCompatActivity {

    private EditText etEmail;
    private EditText etFirstname;
    private EditText etSurname;
    private EditText etStreet;
    private EditText etPostcode;
    private EditText etCity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        // get view elements
        etEmail = findViewById(R.id.evEmail);
        etFirstname = findViewById(R.id.evFirstname);
        etSurname = findViewById(R.id.evSecondname);
        etStreet = findViewById(R.id.evStreet);
        etPostcode = findViewById(R.id.evPostcode);
        etCity = findViewById(R.id.evCity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setUserToView();
    }

    private void setUserToView() {

        // get user object from main
        User user = (User) getIntent().getSerializableExtra("User");
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
