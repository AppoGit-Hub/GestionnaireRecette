package model;

public class LineRecipeDisplay {
    private String ingredient;
    private Integer quantity;
    private Integer unit;

    public LineRecipeDisplay(String ingredient, Integer quantity, Integer unit) {
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

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return ingredient + " " + quantity + unit;
    }
}
