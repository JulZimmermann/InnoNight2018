package team3.innonight.fhws.innonight.viewAdapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BindAbleHolder<T> extends RecyclerView.ViewHolder {
    public BindAbleHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void bind(T item);
}
