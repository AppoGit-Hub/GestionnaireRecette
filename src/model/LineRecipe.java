package model;

public class LineRecipe extends LineRecipeDisplay {
    private Integer recipe;

    public LineRecipe(String ingredient, Integer recipe, Integer quantity, Integer unit) {
        super(ingredient, quantity, unit);
        this.setRecipe(recipe);
    }

    public void setRecipe(Integer recipe) {
        this.recipe = recipe;
    }

    public Integer getRecipe() {
        return recipe;
    }
}
