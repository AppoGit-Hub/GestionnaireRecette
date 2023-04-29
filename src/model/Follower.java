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
        if (child >= 0) {
            this.child = child;
        } else {
            // throw exception ?
        }
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        if (parent >= 0) {
            this.parent = parent;
        } else {
            // throw exception ?
        }
    }
}
