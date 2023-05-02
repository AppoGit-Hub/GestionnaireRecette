package model;

public enum Complexity {
    BASIC(0),
    INTERMEDIATE(1),
    ADVANCED(2),
    EXPERT(3);

    private int complexity;

    Complexity(int complexity) {
        this.complexity = complexity;
    }

    public int getComplexity() {
        return complexity;
    }

    @Override
    public String toString() {
        switch (this) {
            case BASIC -> {
                return "Basic";
            }
            case INTERMEDIATE -> {
                return "Intermediate";
            }
            case ADVANCED -> {
                return "Advanced";
            }
            case EXPERT -> {
                return "Expert";
            }
        }
        return "Basic";
    }
}
