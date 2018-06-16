package team3.innonight.fhws.innonight;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import team3.innonight.fhws.innonight.model.Category;
import team3.innonight.fhws.innonight.model.Notification;
import team3.innonight.fhws.innonight.viewAdapters.EntryAdapter;
import team3.innonight.fhws.innonight.viewAdapters.EntryHolder;
import team3.innonight.fhws.innonight.viewAdapters.NotificationHolder;

public class NotificationList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private List<Notification> notifications = new ArrayList<>();
    private void buildListView() {
        EntryAdapter<Notification, NotificationHolder> adapter =
                new EntryAdapter<>(this.notifications, R.layout.mainviewentry, (i) -> {

                }, (v) -> {
                    return new NotificationHolder(v);
                });
        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

}
