package team3.innonight.fhws.innonight.service;

import android.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import team3.innonight.fhws.innonight.AutoAnmeldenFragment;
import team3.innonight.fhws.innonight.CategoryFragment;
import team3.innonight.fhws.innonight.R;
import team3.innonight.fhws.innonight.model.Category;

public class CategoryService {

    private static Map<String, Fragment> fragments = new HashMap<>();

    static {
        fragments.put("Auto", new CategoryFragment());
        fragments.put("Wohnung", new CategoryFragment());
        fragments.put("Anmelden", new AutoAnmeldenFragment());
    }

    public static List<Category> getAllSuperCategorys() {
        List<Category> ls = new ArrayList<>();
        ls.add(new Category("Auto", R.drawable.ic_directions_car_black_24dp));
        ls.add(new Category("Wohnung", R.drawable.ic_location_city_black_24dp));
        return ls;
    }

    public static List<Category> getSubCategorys(String name) {
        List<Category> ls = new ArrayList<Category>();
        switch(name) {
            case "Auto":
                ls.add(new Category("Anmelden", R.drawable.ic_control_point_black_24dp));
                ls.add(new Category("Abmelden", R.drawable.ic_local_parking_black_24dp));
                break;
        }


        return ls;
    }

    public static Fragment getFragmentForCategory(String categoryName) {
        return fragments.get(categoryName);
    }

}
