package team3.innonight.fhws.innonight.service;

import java.util.ArrayList;
import java.util.List;

import team3.innonight.fhws.innonight.R;
import team3.innonight.fhws.innonight.model.SubCategory;
import team3.innonight.fhws.innonight.model.SuperCategory;

public class CategoryService {
    public static List<SuperCategory> getAllSuperCategorys() {
        List<SuperCategory> ls = new ArrayList<SuperCategory>();
        ls.add(new SuperCategory("Auto", R.drawable.ic_directions_car_black_24dp));
        ls.add(new SuperCategory("Wohnung", R.drawable.ic_location_city_black_24dp));
        return ls;
    }

    public static List<SubCategory> getSubCategorys(String name) {
        List<SubCategory> ls = new ArrayList<SubCategory>();
        switch(name) {
            case "Auto":
                ls.add(new SubCategory("Anmelden", R.drawable.ic_control_point_black_24dp));
                ls.add(new SubCategory("Abmelden", R.drawable.ic_local_parking_black_24dp));
                break;
        }


        return ls;
    }
}
