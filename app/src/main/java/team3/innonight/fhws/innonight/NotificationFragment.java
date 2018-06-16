package team3.innonight.fhws.innonight;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
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

        this.notifications = NotificationService.getInstance().getAllNotification();
        this.buildListView(view,view.getContext());



    }

    private List<Notification> notifications = new ArrayList<>();

    private void buildListView(@NonNull View view, Context context) {
        EntryAdapter<Notification, NotificationHolder> adapter =
                new EntryAdapter<>(this.notifications, R.layout.notificationentry, (i) -> {
                    if (i.description != null)
                        Toast.makeText(context, i.description, Toast.LENGTH_LONG).show();
                }, (v) -> {
                    return new NotificationHolder(v);
                }, (i) -> {
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which){
                                case DialogInterface.BUTTON_POSITIVE:
                                    NotificationService.getInstance().removeNotification(i);
                                    break;

                                case DialogInterface.BUTTON_NEGATIVE:
                                    break;
                            }
                        }
                    };

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Wollen sie die gewählte Benachrichtigung Löschen?").setPositiveButton("Ja", dialogClickListener)
                            .setNegativeButton("Nein", dialogClickListener).show();
                });


        NotificationService.getInstance().registerNotificationChangedEvent((n) -> {
            getActivity().runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    if (n.type == NotificationChanged.Type.Added)
                        adapter.add(n.n);
                    else if (n.type == NotificationChanged.Type.Deleted)
                        adapter.remove(n.n);
                    else
                        adapter.notifyDataSetChanged();
                }
            });

        });
        RecyclerView recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                NotificationService.getInstance().addNotification(new Notification("Hallo tool:D ", Notification.Status.Pending, "",
                        "Ihre Meldung wurde an die entsprechende Stelle weitergeleitet und wird zeitnah behoben"));
            }
        }, 1000);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (adapter.getItemCount() > 0)
                    NotificationService.getInstance().changeNotificationStatus(adapter.getAll().get(0), Notification.Status.Done);
            }
        }, 7000);
    }

}
