package model;

public class Order {
    private Recipe recipe;
    private MealCategory mealCategory;

    public Order(
            Recipe recipe,
            MealCategory mealCategory
    ) {
        this.recipe = recipe;
        this.mealCategory = mealCategory;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public MealCategory getMealCategory() {
        return mealCategory;
    }
}
