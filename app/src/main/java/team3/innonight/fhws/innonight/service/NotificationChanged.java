package team3.innonight.fhws.innonight.service;

import team3.innonight.fhws.innonight.model.Notification;

public class NotificationChanged {
    public Notification n;
    public Type type;

    public enum Type {
        Added,
        Changed,
        Deleted
    }

    public NotificationChanged(Notification n, Type type) {
        this.n = n;
        this.type = type;
    }
}
