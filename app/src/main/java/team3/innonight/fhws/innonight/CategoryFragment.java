package team3.innonight.fhws.innonight;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import team3.innonight.fhws.innonight.model.Category;
import team3.innonight.fhws.innonight.service.CategoryService;
import team3.innonight.fhws.innonight.viewAdapters.EntryAdapter;
import team3.innonight.fhws.innonight.viewAdapters.EntryHolder;

public class CategoryFragment extends Fragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Category> entrys = null;

        Bundle arguments = getArguments();
        if(arguments != null) {
            if(arguments.containsKey("category")) {
                String category = arguments.getString("category");
                if (category != null) {
                    entrys = CategoryService.getSubCategorys(category);
                }
            }
        }

        if(entrys == null) {
            entrys = CategoryService.getAllSuperCategorys();
        }

        EntryAdapter<Category, EntryHolder> adapter = new EntryAdapter<>(entrys, R.layout.mainviewentry, this::onChoosedCategory, EntryHolder::new);
        RecyclerView recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    private void onChoosedCategory(Category category) {
        Bundle bundle = new Bundle();
        bundle.putString("category", category.name);

        Fragment fragment = CategoryService.getFragmentForCategory(category.name);
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.main_fragment, fragment)
                .addToBackStack(null)
                .commit();
    }

}
