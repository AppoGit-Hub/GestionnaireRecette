package model;

public class Utensil {
    private String name;
    private boolean isElectic;
    private LevelPrice levelPrice;

    public Utensil(String name, boolean isElectic, LevelPrice levelPrice) {
        setIsElectic(isElectic);
        setLevelPrice(levelPrice);
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean getIsElectic() {
        return isElectic;
    }

    public void setIsElectic(boolean electic) {
        this.isElectic = electic;
    }

    public LevelPrice getLevelPrice() {
        return levelPrice;
    }

    public void setLevelPrice(LevelPrice levelPrice) {
        this.levelPrice = levelPrice;
    }

    @Override
    public String toString() {
        return name;
    }
}
