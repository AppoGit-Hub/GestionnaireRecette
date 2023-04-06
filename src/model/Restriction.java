package model;

public class Restriction {
    private FoodCategory foodCategory;
    private Diet diet;

    public Restriction(
            FoodCategory foodCategory,
            Diet diet
    ) {
        this.foodCategory = foodCategory;
        this.diet = diet;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public Diet getDiet() {
        return diet;
    }
}
