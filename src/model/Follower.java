package model;

public class Follower {
    private int child;
    private int parent;

    public Follower(int child, int parent) {
        this.setChild(child);
        this.setParent(parent);
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }
}
