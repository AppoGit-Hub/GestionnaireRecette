package interfaceAccess;

import exception.AllPersonException;
import model.Person;
import java.time.LocalDate;
import java.util.ArrayList;

public interface PersonDataAccess {
    ArrayList<Person> getAllPerson() throws AllPersonException;
}
