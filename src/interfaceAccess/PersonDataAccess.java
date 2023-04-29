package interfaceAccess;

import model.Person;
import java.time.LocalDate;

public interface PersonDataAccess {
    Person getPerson(String firstname, String lastname, LocalDate birthday);
}
