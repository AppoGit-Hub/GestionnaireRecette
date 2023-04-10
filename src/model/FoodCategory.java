package model;

public class FoodCategory {
    private int id;
    private String name;

    public FoodCategory(
            int id,
            String name,
            Diet[] diets
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
}
