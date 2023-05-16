package exception;

import java.time.LocalDate;

public class RecipePublicationDateException extends Exception {
    private LocalDate wrongPublicationDate;
    public RecipePublicationDateException(LocalDate wrongPublicationDate) {
        super("Recipe publication date must exists");
        this.wrongPublicationDate = wrongPublicationDate;
    }

    public LocalDate getWrongPublicationDate() {
        return wrongPublicationDate;
    }
}
