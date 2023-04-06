package model;

public class FavoriteRecipe {
    private Recipe recipe;
    private Person person;

    public FavoriteRecipe(
            Recipe recipe,
            Person person
    ) {
        this.recipe = recipe;
        this.person = person;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public Person getPerson() {
        return person;
    }
}

