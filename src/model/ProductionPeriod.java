package model;

import java.time.LocalDate;

public class ProductionPeriod {
    private int id;
    private LocalDate dateBeginning;
    private LocalDate dateEnding;

    public ProductionPeriod(int id, LocalDate dateBeginning, LocalDate dateEnding) {
        this.setId(id);
        this.setDateBeginning(dateBeginning);
        this.setDateEnding(dateEnding);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateBeginning() {
        return dateBeginning;
    }

    public void setDateBeginning(LocalDate dateBeginning) {
        this.dateBeginning = dateBeginning;
    }

    public LocalDate getDateEnding() {
        return dateEnding;
    }

    public void setDateEnding(LocalDate dateEnding) {
        this.dateEnding = dateEnding;
    }
}
