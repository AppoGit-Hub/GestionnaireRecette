package model;

public class Order {
    private String recipe;
    private int mealCategory;

    public Order(
            String recipe,
            int mealCategory
    ) {
        this.recipe = recipe;
        this.mealCategory = mealCategory;
    }

    public String getRecipe() {
        return recipe;
    }

    public int getMealCategory() {
        return mealCategory;
    }
}
