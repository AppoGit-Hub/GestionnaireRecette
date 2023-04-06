package model;

public class Follower {
    private Person child;
    private Person parent;

    public Follower(
            Person child,
            Person parent
    ) {
        this.child = child;
        this.parent = parent;
    }

    public Person getChild() {
        return child;
    }

    public Person getParent() {
        return parent;
    }
}
