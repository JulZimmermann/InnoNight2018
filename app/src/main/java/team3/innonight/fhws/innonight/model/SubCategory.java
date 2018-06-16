package team3.innonight.fhws.innonight.model;

import team3.innonight.fhws.innonight.viewAdapters.ListElement;

public class SubCategory implements ListElement {
    public String name;
    public int icon;

    public SubCategory(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getIcon() {
        return this.icon;
    }
}
