package model;

public class Equipment {
    private String utensil;
    private int recipe;

    public Equipment(String utensil, int recipe) {
        setUtensil(utensil);
        setRecipe(recipe);
    }
    public void setUtensil(String utensil) {
        this.utensil = utensil;
    }
    public String getUtensil() {
        return utensil;
    }
    public void setRecipe(int recipe) {
        this.recipe = recipe;
    }
    public int getRecipe() {
        return recipe;
    }
}
