package model;

public class Restriction {
    private int foodCategory;
    private int diet;

    public Restriction(
            int foodCategory,
            int diet
    ) {
        this.foodCategory = foodCategory;
        this.diet = diet;
    }

    public int getFoodCategory() {
        return foodCategory;
    }

    public int getDiet() {
        return diet;
    }
}
