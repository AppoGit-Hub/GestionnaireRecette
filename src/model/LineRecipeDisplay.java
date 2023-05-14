package model;

public class LineRecipeDisplay {
    private String ingredient;
    private int quantity;
    private Unit unit;

    public LineRecipeDisplay(String ingredient, int quantity, Unit unit) {
        this.setIngredient(ingredient);
        this.setQuantity(quantity);
        this.setUnit(unit);
    }
    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
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

    @Override
    public String toString() {
        return ingredient + " " + quantity + " " + unit;
    }
}