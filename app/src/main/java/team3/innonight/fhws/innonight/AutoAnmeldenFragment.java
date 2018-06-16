package team3.innonight.fhws.innonight;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import team3.innonight.fhws.innonight.model.Auto;

public class AutoAnmeldenFragment extends Fragment {

    private EditText etKennzeichen;
    private EditText etSchluesselnummer;
    private EditText etTypnummer;
    private EditText etVersicherungsnummer;
    private Button btnWeiter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_auto_anlegen, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // get view elements
        etKennzeichen = view.findViewById(R.id.evKennzeichen);
        etSchluesselnummer = view.findViewById(R.id.evSchluesselnummer);
        etTypnummer = view.findViewById(R.id.evTypnummer);
        etVersicherungsnummer = view.findViewById(R.id.evVersicherungsnummer);
        btnWeiter = view.findViewById(R.id.btnWeiter);

        btnWeiter.setOnClickListener(this::onWeiter);
    }

    private void onWeiter(View view) {

        Auto auto = new Auto(
                etKennzeichen.getText().toString(),
                etSchluesselnummer.getText().toString(),
                etTypnummer.getText().toString(),
                etVersicherungsnummer.getText().toString());

        Bundle bundle = new Bundle();
        bundle.putSerializable("auto", auto);

        AutoAnmeldenUebersichtFragment fragment = new AutoAnmeldenUebersichtFragment();
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.main_fragment, fragment)
                .addToBackStack(null)
                .commit();
    }

}
