package model;

public class Order {
    private int recipe;
    private int mealCategory;

    public Order(int recipe, int mealCategory) {
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
