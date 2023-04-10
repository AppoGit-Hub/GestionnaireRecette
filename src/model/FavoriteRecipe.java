package model;

public class FavoriteRecipe {
    private int recipe;
    private int person;

    public FavoriteRecipe(
            int recipe,
            int person
    ) {
        this.recipe = recipe;
        this.person = person;
    }

    public int getRecipe() {
        return recipe;
    }

    public int getPerson() {
        return person;
    }
}

