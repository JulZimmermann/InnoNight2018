package team3.innonight.fhws.innonight;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import team3.innonight.fhws.innonight.model.User;
import team3.innonight.fhws.innonight.service.CategoryService;

public class UserFragment extends Fragment {

    private EditText etEmail;
    private EditText etFirstname;
    private EditText etSurname;
    private EditText etStreet;
    private EditText etPostcode;
    private EditText etCity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // get view elements
        etEmail = view.findViewById(R.id.evEmail);
        etFirstname = view.findViewById(R.id.evFirstname);
        etSurname = view.findViewById(R.id.evSecondname);
        etStreet = view.findViewById(R.id.evStreet);
        etPostcode = view.findViewById(R.id.evPostcode);
        etCity = view.findViewById(R.id.evCity);

        setUserToView();
    }

    private void setUserToView() {

        User user = null;

        Bundle arguments = getArguments();
        if(arguments != null) {
            if(arguments.containsKey("User")) {
                user = (User) arguments.getSerializable("User");
            }
        }

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
