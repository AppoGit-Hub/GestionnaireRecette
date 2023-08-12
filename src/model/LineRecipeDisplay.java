package model;

public class LineRecipeDisplay {
    private String ingredient;
    private Integer recipe;
    private Integer quantity;
    private Unit unit;

    public LineRecipeDisplay(String ingredient, Integer quantity, Unit unit) {
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

    public Integer getQuantity() {
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
        if (this.unit.getId() == 0) {
            return String.format("%d %s", quantity, ingredient);
        } else {
            return String.format("%d %s de %s", quantity, unit, ingredient);
        }
    }
}
