package team3.innonight.fhws.innonight.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.function.Consumer;

public class MainEntryAdapter extends RecyclerView.Adapter<MainViewEntryHolder> {
    private List<MainEntry> entry;
    private int itemLayout;
    private Consumer<View> clickCallback;

    public MainEntryAdapter(List<MainEntry> entry, int itemLayout, Consumer<View> clickCallback) {
        this.entry = entry;
        this.itemLayout = itemLayout;
        this.clickCallback = clickCallback;
    }


    @NonNull
    @Override
    public MainViewEntryHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        v.setOnClickListener(clickCallback::accept);
        return new MainViewEntryHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewEntryHolder mainViewEntryHolder, int i) {
        final MainEntry item = entry.get(i);
        mainViewEntryHolder.itemView.setTag(item);
        mainViewEntryHolder.text.setText(item.name);
        mainViewEntryHolder.image.setImageResource(item.icon);

    }

    @Override
    public int getItemCount() {
        return entry.size();
    }
}
