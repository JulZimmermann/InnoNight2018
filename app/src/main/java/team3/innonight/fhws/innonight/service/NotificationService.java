package team3.innonight.fhws.innonight.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

import team3.innonight.fhws.innonight.R;
import team3.innonight.fhws.innonight.model.Notification;

public class NotificationService {
    private NotificationManager mNotificationManager;
    private Context c;

    private static NotificationService instance;

    private NotificationService(){}

    public static void setContext(NotificationManager m, Context c) {
        if (NotificationService.instance == null) {
            NotificationService.instance = new NotificationService();
            NotificationService.instance.mNotificationManager = m;
            NotificationService.instance.c = c;
        }
    }

    public static NotificationService getInstance() {
        return NotificationService.instance;
    }

    private List<Consumer<NotificationChanged>> changedCallbacks = new ArrayList<>();
    public void registerNotificationChangedEvent(Consumer<NotificationChanged> c) {
        this.changedCallbacks.add(c);
    }

    public void addNotification(Notification n) {
        showNotification("Stadt Würzburg", n.name);
        for(Consumer<NotificationChanged> c : this.changedCallbacks)
            c.accept(new NotificationChanged(n, NotificationChanged.Type.Added));
    }

    public void changeNotificationStatus(Notification n, Notification.Status nStatus) {
        n.status = nStatus;
        for(Consumer<NotificationChanged> c : this.changedCallbacks)
            c.accept(new NotificationChanged(n, NotificationChanged.Type.Changed));
    }

    public static List<Notification> getAllNotification() {

        List<Notification> ls = new ArrayList<Notification>();
        //ls.add(new Notification("Personalausweiß kann abgeholt werden fertig", Notification.Status.Done, "22.06.2018"));
        //ls.add(new Notification("Schlagloch gemeldet", Notification.Status.Pending, "-"));
        return ls;
    }


    private void showNotification(String title, String content) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("default",
                    "YOUR_CHANNEL_NAME",
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("YOUR_NOTIFICATION_CHANNEL_DISCRIPTION");
            mNotificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(c, "default")
                .setSmallIcon(R.mipmap.ic_launcher) // notification icon
                .setContentTitle(title) // title for notification
                .setContentText(content)// message for notification
                //.setSound(alarmSound) // set alarm sound for notification
                .setAutoCancel(true); // clear notification after click
        //Intent intent = new Intent(c, MainActivity.class);
        //PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        //mBuilder.setContentIntent(pi);
        mNotificationManager.notify(0, mBuilder.build());
    }
}
