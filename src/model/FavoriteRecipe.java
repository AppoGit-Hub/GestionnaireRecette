package model;

public class FavoriteRecipe {
    private Integer recipe;
    private Integer person;

    public FavoriteRecipe(Integer recipe, Integer person) {
        setPerson(person);
        setRecipe(recipe);
    }

    public void setRecipe(Integer recipe) {
        this.recipe = recipe;
    }
    public Integer getRecipe() {
        return recipe;
    }
    public void setPerson(Integer person) {
        this.person = person;
    }
    public Integer getPerson() {
        return person;
    }
}

