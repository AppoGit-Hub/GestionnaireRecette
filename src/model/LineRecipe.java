package model;

public class LineRecipe {
    private Ingredient ingredient;
    private Recipe recipe;
    private int quantity;
    private Unit unit;

    public LineRecipe(
            Ingredient ingredient,
            Recipe recipe,
            int quantity,
            Unit unit
    ) {
        this.ingredient = ingredient;
        this.recipe = recipe;
        this.quantity = quantity;
        this.unit = unit;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public int getQuantity() {
        return quantity;
    }

    public Unit getUnit() {
        return unit;
    }
}
