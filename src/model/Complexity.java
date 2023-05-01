package model;

public enum Complexity {
    LOW("Low"),
    MID("Mid"),
    HIGH("High");

    private String complexity;

    Complexity(String complexity) {
        this.complexity = complexity;
    }

    public String getComplexity() {
        return complexity;
    }
}
