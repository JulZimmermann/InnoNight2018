package team3.innonight.fhws.innonight.model;

import java.time.LocalDate;

import team3.innonight.fhws.innonight.R;

public class Notification {
    public enum Status {
        Pending,
        Done,
        Rejected
    }

    public enum Type {
        Feedback,
        Form
    }

    public String name;
    public String description;
    public Status status;
    public LocalDate dueDate;
    public Type type = Type.Form;

    public Notification(String name, Status status) {
        this.name = name;
        this.status = status;
    }


    public Notification(String name, Status status, LocalDate dueDate) {
        this(name, status);
        this.dueDate = dueDate;
    }

    public Notification(String name, Status status, String description) {
        this.name = name;
        this.status = status;
        this.description = description;
    }

    public Notification(String name, Status status, String description, Type type) {
        this(name, status, description);
        this.type = type;
    }

    public Notification(String name, Status status, LocalDate dueDate, String description) {
        this(name, status, dueDate);
        this.description = description;
    }

    public int getStatusAsIcon() {
        switch (this.status) {
            case Pending:
                return  R.drawable.ic_autorenew_black_24dp;
            case Done:
                return R.drawable.ic_beenhere_black_24dp;
            case Rejected:
                return R.drawable.ic_do_not_disturb_alt_black_24dp;
        }


        return R.drawable.ic_launcher_background;
    }

}
