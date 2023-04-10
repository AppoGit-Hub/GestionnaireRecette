package model;

public class Ingredient {
    private String name;
    private Integer minPerservationTemperature;
    private Integer maxPerservationTemperature;
    private int season;
    private int type;

    public Ingredient(
            String name,
            Integer minPerservationTemperature,
            Integer maxPerservationTemperature,
            int season,
            int type
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

    public int getSeason() {
        return season;
    }

    public int getType() {
        return type;
    }
}
