package team3.innonight.fhws.innonight.viewAdapters;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import team3.innonight.fhws.innonight.R;
import team3.innonight.fhws.innonight.model.Category;
import team3.innonight.fhws.innonight.model.Notification;

public class NotificationHolder extends BindAbleHolder<Notification>  {

    public TextView mainText;
    public TextView dueDate;
    public ImageView image;

    public NotificationHolder(@NonNull View itemView) {
        super(itemView);
        mainText = (TextView) itemView.findViewById(R.id.notification_main);
        //dueDate = (TextView) itemView.findViewById(R.id.notification_dueDate);
        image = (ImageView) itemView.findViewById(R.id.notification_status_icon);
    }

    @Override
    public void bind(Notification item) {
        this.mainText.setText(item.name);
        this.image.setImageResource(item.getStatusAsIcon());
        //this.dueDate.setText(item.dueDate.toString());
    }

}
