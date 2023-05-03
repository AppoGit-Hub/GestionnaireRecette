package model;

public class FavoriteRecipe {
    private int recipe;
    private int person;

    public FavoriteRecipe(int recipe, int person) {
        setPerson(person);
        setRecipe(recipe);
    }

    public void setRecipe(int recipe) {
        this.recipe = recipe;
    }
    public int getRecipe() {
        return recipe;
    }
    public void setPerson(int person) {
        this.person = person;
    }
    public int getPerson() {
        return person;
    }
}

