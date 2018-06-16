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
    public Status status;
    public Calendar dueDate;

    public int getStatusAsIcon() {
        return R.drawable.ic_control_point_black_24dp;
    }

}