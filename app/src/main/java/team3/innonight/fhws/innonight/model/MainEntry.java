package team3.innonight.fhws.innonight.model;

import team3.innonight.fhws.innonight.viewAdapters.ListElement;

public class MainEntry implements ListElement {
    public String name;
    public int icon;

    public MainEntry(String name, int icon) {
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
