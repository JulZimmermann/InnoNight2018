package team3.innonight.fhws.innonight;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import team3.innonight.fhws.innonight.model.Category;
import team3.innonight.fhws.innonight.service.CategoryService;
import team3.innonight.fhws.innonight.viewAdapters.EntryAdapter;

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

        EntryAdapter<Category> adapter = new EntryAdapter<>(entrys, R.layout.mainviewentry, this::onChoosedCategory);
        RecyclerView recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    private void onChoosedCategory(String category) {
        Bundle bundle = new Bundle();
        bundle.putString("category", category);

        CategoryFragment fragment = new CategoryFragment();
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.category_fragment, fragment)
                .addToBackStack(null)
                .commit();
    }

}
