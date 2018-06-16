package team3.innonight.fhws.innonight.viewAdapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.function.Consumer;

import team3.innonight.fhws.innonight.model.MainEntry;

public class EntryAdapter<T extends ListElement> extends RecyclerView.Adapter<EntryHolder> {
    private List<T> entry;
    private int itemLayout;
    private Consumer<View> clickCallback;

    public EntryAdapter(List<T> entry, int itemLayout, Consumer<View> clickCallback) {
        this.entry = entry;
        this.itemLayout = itemLayout;
        this.clickCallback = clickCallback;
    }


    @NonNull
    @Override
    public EntryHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        v.setOnClickListener(clickCallback::accept);
        return new EntryHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EntryHolder EntryHolder, int i) {
        final T item = entry.get(i);
        EntryHolder.itemView.setTag(item);
        EntryHolder.text.setText(item.getName());
        EntryHolder.image.setImageResource(item.getIcon());

    }

    @Override
    public int getItemCount() {
        return entry.size();
    }
}
