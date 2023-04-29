package model;

import java.time.LocalDate;

public class ProductionPeriod {
    private int id;
    private LocalDate dateBeginning;
    private LocalDate dateEnding;

    public ProductionPeriod(int id, LocalDate dateBeginning, LocalDate dateEnding) {
        this.setId(id);
        this.setPeriod(dateBeginning, dateEnding);
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
        if (this.dateBeginning.isBefore(this.dateEnding)) {
            this.dateBeginning = dateBeginning;
        }
    }

    public LocalDate getDateEnding() {
        return dateEnding;
    }

    public void setDateEnding(LocalDate dateEnding) {
        if (this.dateBeginning.isBefore(this.dateEnding)) {
            this.dateEnding = dateEnding;
        }
    }

    private void setPeriod(LocalDate dateBeginning, LocalDate dateEnding) {
        if (dateBeginning.isBefore(dateEnding)) {
            this.dateBeginning = dateBeginning;
            this.dateEnding = dateEnding;
        }
    }
}
