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
        if (ingredient.length() > 0) {
            this.ingredient = ingredient;
        } else {
            // throw exception ?
        }
    }

    public int getRecipe() {
        return recipe;
    }

    public void setRecipe(int recipe) {
        if (recipe >= 0) {
            this.recipe = recipe;
        } else {
            // throw exception ?
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            // throw exception ?
        }
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
