package model;

public class Period {
    private int recipe;
    private int menuType;

    public Period(int recipe, int menuType) {
        setRecipe(recipe);
        setMenuType(menuType);
    }

    public void setRecipe(int recipe) {
        this.recipe = recipe;
    }

    public int getRecipe() {
        return recipe;
    }

    public void setMenuType(int menuType) {
        this.menuType = menuType;
    }

    public int getMenuType() {
        return menuType;
    }
}
