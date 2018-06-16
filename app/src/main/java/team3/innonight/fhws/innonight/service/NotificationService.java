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

import team3.innonight.fhws.innonight.R;
import team3.innonight.fhws.innonight.model.Notification;

public class NotificationService {
    private NotificationManager mNotificationManager;
    private Context c;

    public NotificationService(NotificationManager m, Context c) {
        this.mNotificationManager = m;
        this.c = c;

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                showNotification("Hallo :D" , "Spamm");
            }
        }, 1000, 1000);

    }

    public static List<Notification> getAllNotification() {

        List<Notification> ls = new ArrayList<Notification>();
        ls.add(new Notification("Perso fertig", Notification.Status.Done, "22.06.2018"));
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
