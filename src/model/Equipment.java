package model;

public class Equipment {
    private String utensil;
    private Integer recipe;

    public Equipment(String utensil, Integer recipe) {
        setUtensil(utensil);
        setRecipe(recipe);
    }
    public void setUtensil(String utensil) {
        this.utensil = utensil;
    }
    public String getUtensil() {
        return utensil;
    }
    public void setRecipe(Integer recipe) {
        this.recipe = recipe;
    }
    public Integer getRecipe() {
        return recipe;
    }
}
