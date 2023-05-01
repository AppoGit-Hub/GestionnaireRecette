package model;

public enum Unit {
    NONE("None"),
    GRAM("gram"),
    KILOGRAM("Kilogram"),
    POUND("Pound"),
    OUNCE("ounce"),
    TONNE("tonne"),
    LITER("Liter"),
    MILLILITER("Milliliter"),
    GALLON("Gallon"),
    PINT("Pint"),
    QUART("Quart");

    private String unit;

    Unit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return this.unit;
    }
}
