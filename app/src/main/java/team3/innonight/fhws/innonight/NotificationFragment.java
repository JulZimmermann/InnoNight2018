package team3.innonight.fhws.innonight;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import team3.innonight.fhws.innonight.model.Notification;
import team3.innonight.fhws.innonight.service.NotificationChanged;
import team3.innonight.fhws.innonight.service.NotificationService;
import team3.innonight.fhws.innonight.viewAdapters.EntryAdapter;
import team3.innonight.fhws.innonight.viewAdapters.NotificationHolder;

public class NotificationFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notifications, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.buildListView(view,view.getContext());
    }



    private void buildListView(@NonNull View view, Context context) {
        EntryAdapter<Notification, NotificationHolder> adapter =
                new EntryAdapter<>(NotificationService.getInstance().getExistingNotifications(), R.layout.notificationentry, (i) -> {
                    if (i.description != null)
                        Toast.makeText(context, i.description, Toast.LENGTH_LONG).show();
                }, NotificationHolder::new, (i) -> {
                    DialogInterface.OnClickListener dialogClickListener = (dialog, which) -> {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                NotificationService.getInstance().removeNotification(i);
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                break;
                        }
                    };

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Wollen sie die gewählte Benachrichtigung Löschen?").setPositiveButton("Ja", dialogClickListener)
                            .setNegativeButton("Nein", dialogClickListener).show();
                });


        NotificationService.getInstance().registerNotificationChangedEvent((n) -> {
            if (getActivity() == null)
                return;

            getActivity().runOnUiThread(() -> {
                if (n.type == NotificationChanged.Type.Added)
                    adapter.add(n.n);
                else if (n.type == NotificationChanged.Type.Deleted)
                    adapter.remove(n.n);
                else
                    adapter.notifyDataSetChanged();
            });

        });
        RecyclerView recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (Notification n : adapter.getAll())
                {
                    if (n.status == Notification.Status.Pending) {
                        NotificationService.getInstance().changeNotificationStatus(n, Notification.Status.Done, "Ihre Antrag wurde ohne Beanstandung bearbeitet.");
                        break;

                    }

                }
            }
        }, 8000, 8000);

    }

}
