package team3.innonight.fhws.innonight.service;

import java.util.ArrayList;
import java.util.List;

import team3.innonight.fhws.innonight.R;
import team3.innonight.fhws.innonight.model.SuperCategory;

public class CategoryService {
    public static List<SuperCategory> getAllEntrys() {
        List<SuperCategory> ls = new ArrayList<SuperCategory>();
        ls.add(new SuperCategory("Auto", R.drawable.ic_directions_car_black_24dp));
        ls.add(new SuperCategory("Wohnung", R.drawable.ic_location_city_black_24dp));
        return ls;
    }
}
