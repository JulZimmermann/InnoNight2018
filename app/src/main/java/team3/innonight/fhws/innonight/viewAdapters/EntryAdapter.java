package team3.innonight.fhws.innonight.viewAdapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class EntryAdapter<T, H extends BindAbleHolder<T>> extends RecyclerView.Adapter<H> {
    private List<T> entry;
    private int itemLayout;
    private Consumer<T> clickCallback;

    private Function<View, H> createHolder;

    public EntryAdapter(List<T> entry, int itemLayout, Consumer<T> clickCallback, Function<View, H> createHolder) {
        this.entry = entry;
        this.itemLayout = itemLayout;
        this.clickCallback = clickCallback;
        this.createHolder = createHolder;
    }


    @NonNull
    @Override
    public H onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);

        H holder = this.createHolder.apply(v);


        v.setOnClickListener(x -> {
            int pos = holder.getAdapterPosition();
            clickCallback.accept(entry.get(pos));
        });

        return holder;
    }


    public void add(T item) {
        this.entry.add(item);
        notifyItemInserted(this.entry.size());
    }

    public void remove(T item) {
        int position = this.entry.indexOf(item);
        this.entry.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onBindViewHolder(@NonNull H EntryHolder, int i) {
        final T item = entry.get(i);
        EntryHolder.itemView.setTag(item);
        EntryHolder.bind(item);

    }

    @Override
    public int getItemCount() {
        return entry.size();
    }
}
