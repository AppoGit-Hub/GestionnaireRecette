package model;

public class LineRecipe {
    private String ingredient;
    private int recipe;
    private int quantity;
    private Unit unit;

    public LineRecipe(
            String ingredient,
            int recipe,
            int quantity,
            Unit unit
    ) {
        this.ingredient = ingredient;
        this.recipe = recipe;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getIngredient() {
        return ingredient;
    }

    public int getRecipe() {
        return recipe;
    }

    public int getQuantity() {
        return quantity;
    }

    public Unit getUnit() {
        return unit;
    }
}
