package model;

public class LineRecipe {
    private String ingredient;
    private Integer recipe;
    private Integer quantity;
    private Integer unit;

    public LineRecipe(String ingredient, Integer recipe, Integer quantity, Integer unit) {
        this.setRecipe(recipe);
    }
    public Integer getRecipe() {
        return recipe;
    }
    public void setRecipe(Integer recipe) {
        this.recipe = recipe;
    }
    public String getIngredient() {
        return ingredient;
    }
    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Integer getUnit() {
        return unit;
    }
    public void setUnit(Integer unit) {
        this.unit = unit;
    }
}
