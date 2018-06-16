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
import android.widget.TextView;

import team3.innonight.fhws.innonight.model.Auto;
import team3.innonight.fhws.innonight.model.Notification;
import team3.innonight.fhws.innonight.model.User;
import team3.innonight.fhws.innonight.service.CategoryService;
import team3.innonight.fhws.innonight.service.NotificationService;
import team3.innonight.fhws.innonight.service.UserService;

public class AutoAnmeldenUebersichtFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_auto_anlegen_uebersicht, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Auto auto = null;

        Bundle arguments = getArguments();
        if(arguments != null) {
            if(arguments.containsKey("auto")) {
                auto = (Auto) arguments.getSerializable("auto");
            }
        }

        User user = UserService.getUser();

        TextView benutzer = view.findViewById(R.id.evBenutzer);
        benutzer.setText(String.format("%s %s", user.getFirstname(), user.getSurname()));

        TextView kennzeichen = view.findViewById(R.id.evKennzeichen);
        kennzeichen.setText(auto.getKennzeichen());

        TextView schluesselnumer = view.findViewById(R.id.evSchluesselnummer);
        schluesselnumer.setText(auto.getSchluesselnummer());

        TextView typnummer = view.findViewById(R.id.evTypnummer);
        typnummer.setText(auto.getTypnummer());

        TextView versicherungsnummer = view.findViewById(R.id.evVersicherungsnummer);
        versicherungsnummer.setText(auto.getVersicherungsnummer());

        Button absenden = view.findViewById(R.id.btnAbsenden);

        final Auto fAuto = auto;
        absenden.setOnClickListener(v -> onAbsenden(v, fAuto));

        benutzer.clearComposingText();
        kennzeichen.clearComposingText();
        schluesselnumer.clearComposingText();


    }

    private void onAbsenden(View view, Auto auto) {
        NotificationService.getInstance().addNotification(
                new Notification(
                        String.format("Anmeldung %s", auto.getKennzeichen()),
                        Notification.Status.Pending, "Ihr Antrag wird bearbeitet"
                        ));


        Fragment fragment = new CategoryFragment();
        FragmentManager fragmentManager = getFragmentManager();

        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        fragmentManager.beginTransaction()
                .replace(R.id.main_fragment, fragment)
                .commit();
    }
}
