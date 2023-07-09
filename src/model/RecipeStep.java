package model;

public class RecipeStep {
    private Integer recipe;
    private Integer number;
    private String description;

    public RecipeStep(Integer recipe, Integer number, String description) {
        setRecipe(recipe);
        setNumber(number);
        setDescription(description);
    }

    public Integer getRecipe() {
        return recipe;
    }
    public void setRecipe(Integer recipe) {
        this.recipe = recipe;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
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
