package model;

public class RecipeStep {
    private int recipe;
    private int number;
    private String description;

    public RecipeStep(int recipe, int number, String description) {
        setRecipe(recipe);
        setNumber(number);
        setDescription(description);
    }

    public int getRecipe() {
        return recipe;
    }
    public void setRecipe(int recipe) {
        this.recipe = recipe;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return this.description;
    }
}
