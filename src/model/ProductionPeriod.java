package model;

import java.time.LocalDate;

public class ProductionPeriod {
    private int id;
    private LocalDate dateBeginning;
    private LocalDate dateEnding;

    public ProductionPeriod(
            int id,
            LocalDate dateBeginning,
            LocalDate dateEnding
    ) {
        this.id = id;
        this.dateBeginning = dateBeginning;
        this.dateEnding = dateEnding;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDateBeginning() {
        return dateBeginning;
    }

    public LocalDate getDateEnding() {
        return dateEnding;
    }
}
