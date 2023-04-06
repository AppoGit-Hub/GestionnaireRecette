package model;

public class Utensil {
    private String name;
    private boolean isElectic;
    private LevelPrice levelPrice;

    public Utensil(
            String name,
            boolean isElectic,
            LevelPrice levelPrice
    ) {
        this.name = name;
        this.isElectic = isElectic;
        this.levelPrice = levelPrice;
    }

    public String getName() {
        return name;
    }

    public boolean getIsElectic() {
        return isElectic;
    }

    public LevelPrice getLevelPrice() {
        return levelPrice;
    }

    @Override
    public String toString() {
        return name;
    }
}
