package team3.innonight.fhws.innonight;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import team3.innonight.fhws.innonight.model.Notification;
import team3.innonight.fhws.innonight.service.NotificationService;
import team3.innonight.fhws.innonight.viewAdapters.EntryAdapter;
import team3.innonight.fhws.innonight.viewAdapters.NotificationHolder;

public class Notifications extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        this.notifications = NotificationService.getInstance().getAllNotification();
        this.buildListView();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                NotificationService.getInstance().addNotification(new Notification("Hallo tool:D ", Notification.Status.Done, ""));
            }
        }, 1000);
    }

    private List<Notification> notifications = new ArrayList<>();
    private void buildListView() {
        EntryAdapter<Notification, NotificationHolder> adapter =
                new EntryAdapter<>(this.notifications, R.layout.notificationentry, (i) -> {

                }, (v) -> {
                    return new NotificationHolder(v);
                });

        NotificationService.getInstance().registerNotificationChangedEvent((n) -> {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    if (n.added)
                        adapter.add(n.n);
                    else
                        adapter.remove(n.n);
                }
            });

        });
        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

}
