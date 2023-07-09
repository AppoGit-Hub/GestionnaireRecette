package model;

public enum Complexity {
    BASIC(0),
    INTERMEDIATE(1),
    ADVANCED(2),
    EXPERT(3);

    private Integer complexity;

    Complexity(Integer complexity) {
        setComplexity(complexity);
    }

    public void setComplexity(Integer complexity) {
        this.complexity = complexity;
    }

    public Integer getComplexity() {
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
