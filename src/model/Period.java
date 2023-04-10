package model;

public class Period {
    private int recipe;
    private int menuType;

    public Period(
            int recipe,
            int menuType
    ) {
        this.recipe = recipe;
        this.menuType = menuType;
    }

    public int getRecipe() {
        return recipe;
    }

    public int getMenuType() {
        return menuType;
    }
}
