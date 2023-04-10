package model;

public class Follower {
    private int child;
    private int parent;

    public Follower(
            int child,
            int parent
    ) {
        this.child = child;
        this.parent = parent;
    }

    public int getChild() {
        return child;
    }

    public int getParent() {
        return parent;
    }
}
