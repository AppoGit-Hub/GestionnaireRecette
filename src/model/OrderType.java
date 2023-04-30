package model;

public class OrderType {
    private int recipe;
    private int mealCategory;

    public OrderType(int recipe, int mealCategory) {
        this.recipe = recipe;
        this.mealCategory = mealCategory;
    }

    public int getRecipe() {
        return recipe;
    }

    public int getMealCategory() {
        return mealCategory;
    }
}
