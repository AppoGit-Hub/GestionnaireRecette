package model;

public class Equipment {
    private String utensil;
    private int recipe;

    public Equipment(
            String utensil,
            int recipe
    ) {
        this.utensil = utensil;
        this.recipe = recipe;
    }

    public String getUtensil() {
        return utensil;
    }

    public int getRecipe() {
        return recipe;
    }
}
