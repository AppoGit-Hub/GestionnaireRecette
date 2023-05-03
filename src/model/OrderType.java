package model;

public class OrderType {
    private int recipe;
    private int mealCategory;

    public OrderType(int recipe, int mealCategory) {
        setRecipe(recipe);
        setMealCategory(mealCategory);
    }

    public int getRecipe() {
        return recipe;
    }

    public void setRecipe(int recipe) {
        this.recipe = recipe;
    }

    public int getMealCategory() {
        return mealCategory;
    }

    public void setMealCategory(int mealCategory) {
        this.mealCategory = mealCategory;
    }
}
