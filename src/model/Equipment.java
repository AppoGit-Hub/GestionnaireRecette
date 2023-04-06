package model;

public class Equipment {
    private Utensil utensil;
    private Recipe recipe;

    public Equipment(
            Utensil utensil,
            Recipe recipe
    ) {
        this.utensil = utensil;
        this.recipe = recipe;
    }

    public Utensil getUtensil() {
        return utensil;
    }

    public Recipe getRecipe() {
        return recipe;
    }
}
