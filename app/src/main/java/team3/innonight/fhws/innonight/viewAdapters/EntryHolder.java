package team3.innonight.fhws.innonight.viewAdapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import team3.innonight.fhws.innonight.R;
import team3.innonight.fhws.innonight.model.Category;

public class EntryHolder extends BindAbleHolder<Category> {

    public TextView text;
    public ImageView image;

    public EntryHolder(@NonNull View itemView) {
        super(itemView);
        text = (TextView) itemView.findViewById(R.id.category_name);
        image = (ImageView) itemView.findViewById(R.id.category_icon);
    }

    @Override
    public void bind(Category item) {
        this.text.setText(item.getName());
        this.image.setImageResource(item.getIcon());
    }

}
