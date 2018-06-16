package team3.innonight.fhws.innonight.model;

import java.util.Calendar;

import team3.innonight.fhws.innonight.R;

public class Notification {
    public enum Status {
        Pending,
        Done,
        Rejected
    }

    public String name;
    public String description;
    public Status status;
    public String dueDate;

    public Notification(String name, Status status, String dueDate) {
        this.name = name;
        this.status = status;
        this.dueDate = dueDate;
    }
    public Notification(String name, Status status, String dueDate, String description) {
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
