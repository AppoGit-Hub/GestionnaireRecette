package model;

public class MenuType {
    private int id;
    private String name;

    public MenuType(
            int id,
            String name
    ) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
