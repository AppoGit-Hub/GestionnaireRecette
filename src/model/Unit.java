package model;

public class Unit {
    private int id;
    private String name;

    public Unit(int id, String name) {
        this.id = id;
        this.setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return getName();
    }
}
