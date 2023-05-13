package model;

public class LineRecipe extends LineRecipeDisplay {
    private int recipe;

    public LineRecipe(String ingredient, int recipe, int quantity, Unit unit) {
        super(ingredient, quantity, unit);
        this.setRecipe(recipe);
    }

    public void setRecipe(int recipe) {
        this.recipe = recipe;
    }

    public int getRecipe() {
        return recipe;
    }
}
