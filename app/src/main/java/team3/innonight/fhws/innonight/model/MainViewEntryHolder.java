package team3.innonight.fhws.innonight.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import team3.innonight.fhws.innonight.R;

public class MainViewEntryHolder extends RecyclerView.ViewHolder {

    public TextView text;
    public ImageView image;

    public MainViewEntryHolder(@NonNull View itemView) {
        super(itemView);
        text = (TextView) itemView.findViewById(R.id.category_name);
        image = (ImageView) itemView.findViewById(R.id.category_icon);
    }

}
