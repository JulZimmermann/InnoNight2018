package team3.innonight.fhws.innonight.service;

import java.util.ArrayList;
import java.util.List;

import team3.innonight.fhws.innonight.R;
import team3.innonight.fhws.innonight.model.Category;

public class CategoryService {
    public static List<Category> getAllSuperCategorys() {
        List<Category> ls = new ArrayList<Category>();
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
}
