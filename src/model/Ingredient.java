package model;

public class Ingredient {
    private String name;
    private Integer minPreservationTemperature;
    private Integer maxPreservationTemperature;
    private int season;
    private int type;

    public Ingredient(String name, Integer minPreservationTemperature, Integer maxPreservationTemperature, int season, int type) {
        this.setName(name);
        this.setMinPreservationTemperature(minPreservationTemperature);
        this.setMaxPreservationTemperature(maxPreservationTemperature);
        this.setSeason(season);
        this.setType(type);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (this.name.length() > 0) {
            this.name = name;
        }
    }

    public Integer getMinPerservationTemperature() {
        return minPreservationTemperature;
    }

    public void setMinPreservationTemperature(Integer temperature) {
        if (temperature != null) {
            if (temperature < this.maxPreservationTemperature) {
                this.minPreservationTemperature = temperature;
            } else {
                // throw exception ?
            }
        } else {
            this.minPreservationTemperature = temperature;
        }
    }

    public Integer getMaxPerservationTemperature() {
        return maxPreservationTemperature;
    }

    public void setMaxPreservationTemperature(Integer temperature) {
        if (temperature != null) {
            if (temperature > this.minPreservationTemperature) {
                this.maxPreservationTemperature = temperature;
            } else {
                // throw exception ?
            }
        } else {
            this.maxPreservationTemperature = temperature;
        }
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        if (season >= 0) {
            this.season = season;
        } else {
            // throw exception ?
        }
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        if (type >= 0) {
            this.type = type;
        } else {
            // throw exception ?
        }
    }
}
