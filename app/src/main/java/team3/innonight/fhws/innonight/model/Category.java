package team3.innonight.fhws.innonight.model;

public class Category {
    public String name;
    public int icon;

    public Category(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return this.name;
    }

    public int getIcon() {
        return this.icon;
    }
}
