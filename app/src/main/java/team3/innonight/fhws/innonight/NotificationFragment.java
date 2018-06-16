package team3.innonight.fhws.innonight;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import team3.innonight.fhws.innonight.model.Notification;
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
        this.buildListView();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                NotificationService.getInstance().addNotification(new Notification("Hallo tool:D ", Notification.Status.Done, ""));
            }
        }, 1000);
        this.buildListView(view);
    }

    private List<Notification> notifications = new ArrayList<>();

    private void buildListView(@NonNull View view) {
        EntryAdapter<Notification, NotificationHolder> adapter =
                new EntryAdapter<>(this.notifications, R.layout.notificationentry, (i) -> {

                }, (v) -> {
                    return new NotificationHolder(v);
                });

        NotificationService.getInstance().registerNotificationChangedEvent((n) -> {
            getActivity().runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    if (n.added)
                        adapter.add(n.n);
                    else
                        adapter.remove(n.n);
                }
            });

        });
        RecyclerView recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

}
