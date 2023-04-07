package model;

public class FoodCategory {
    private int id;
    private String name;
    private Diet[] diets;

    public FoodCategory(
            int id,
            String name,
            Diet[] diets
    ) {
        this.id = id;
        this.name = name;
        this.diets = diets;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Diet[] getDiets() {
        return diets;
    }
}
