package model;

public class Period {
    private Integer recipe;
    private Integer menuType;

    public Period(Integer recipe, Integer menuType) {
        setRecipe(recipe);
        setMenuType(menuType);
    }

    public void setRecipe(Integer recipe) {
        this.recipe = recipe;
    }

    public Integer getRecipe() {
        return recipe;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public Integer getMenuType() {
        return menuType;
    }
}
