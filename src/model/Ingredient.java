package model;

public class Ingredient {
    private String name;
    private Integer minPerservationTemperature;
    private Integer maxPerservationTemperature;
    private ProductionPeriod season;
    private FoodCategory type;

    public Ingredient(
            String name,
            Integer minPerservationTemperature,
            Integer maxPerservationTemperature,
            ProductionPeriod season,
            FoodCategory type
    ) {
        this.name = name;
        this.minPerservationTemperature = minPerservationTemperature;
        this.maxPerservationTemperature = maxPerservationTemperature;
        this.season = season;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Integer getMinPerservationTemperature() {
        return minPerservationTemperature;
    }

    public Integer getMaxPerservationTemperature() {
        return maxPerservationTemperature;
    }

    public ProductionPeriod getSeason() {
        return season;
    }

    public FoodCategory getType() {
        return type;
    }
}
