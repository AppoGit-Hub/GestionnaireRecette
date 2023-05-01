package model;

public class Ingredient {
    private String name;
    private Float minPreservationTemperature;
    private Float maxPreservationTemperature;
    private int season;
    private int type;

    public Ingredient(String name, Float minPreservationTemperature, Float maxPreservationTemperature, int season, int type) {
        this.setName(name);
        this.setMinMaxPreservaationTemperature(minPreservationTemperature, maxPreservationTemperature);
        this.setSeason(season);
        this.setType(type);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name.length() > 0) {
            this.name = name;
        }
    }

    public Float getMinPerservationTemperature() {
        return minPreservationTemperature;
    }

    public void setMinPreservationTemperature(Float temperature) {
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

    public Float getMaxPerservationTemperature() {
        return maxPreservationTemperature;
    }

    public void setMaxPreservationTemperature(Float temperature) {
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

    public void setMinMaxPreservaationTemperature(Float min, Float max) {
        this.minPreservationTemperature = min;
        this.maxPreservationTemperature = max;
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

    @Override
    public String toString() {
        return this.name;
    }
}
