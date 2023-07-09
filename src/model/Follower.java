package model;

public class Follower {
    private Integer child;
    private Integer parent;

    public Follower(Integer child, Integer parent) {
        this.setChild(child);
        this.setParent(parent);
    }

    public Integer getChild() {
        return child;
    }

    public void setChild(Integer child) {
        this.child = child;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }
}
