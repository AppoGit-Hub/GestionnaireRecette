package model;

public class OrderType {
    private Integer recipe;
    private Integer mealCategory;

    public OrderType(Integer recipe, Integer mealCategory) {
        setRecipe(recipe);
        setMealCategory(mealCategory);
    }

    public Integer getRecipe() {
        return recipe;
    }

    public void setRecipe(Integer recipe) {
        this.recipe = recipe;
    }

    public Integer getMealCategory() {
        return mealCategory;
    }

    public void setMealCategory(Integer mealCategory) {
        this.mealCategory = mealCategory;
    }
}
