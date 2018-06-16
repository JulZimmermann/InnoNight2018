package team3.innonight.fhws.innonight.service;

import team3.innonight.fhws.innonight.model.Notification;

public class NotificationChanged {
    public Notification n;
    public boolean added;

    public NotificationChanged(Notification n, boolean added) {
        this.n = n;
        this.added = added;
    }
}
