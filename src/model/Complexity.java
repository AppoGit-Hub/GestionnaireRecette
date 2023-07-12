package model;

public class Complexity {
    private int id;
    private String name;

    public Complexity(int id, String name) {
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
}
