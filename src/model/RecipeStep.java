package model;

public class RecipeStep {
    private Recipe recipe;
    private int number;
    private String description;

    public RecipeStep(
            Recipe recipe,
            int number,
            String description
    ) {
        this.recipe = recipe;
        this.number = number;
        this.description = description;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
