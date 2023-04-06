package model;

public class MealCategory {
    private int id;
    private String name;

    public MealCategory(
            int id,
            String name
    ) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
