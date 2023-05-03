package model;

public class LineRecipe {
    private String ingredient;
    private int recipe;
    private int quantity;
    private Unit unit;

    public LineRecipe(String ingredient, int recipe, int quantity, Unit unit) {
        this.setIngredient(ingredient);
        this.setRecipe(recipe);
        this.setQuantity(quantity);
        this.setUnit(unit);
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public int getRecipe() {
        return recipe;
    }

    public void setRecipe(int recipe) {
        this.recipe = recipe;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
