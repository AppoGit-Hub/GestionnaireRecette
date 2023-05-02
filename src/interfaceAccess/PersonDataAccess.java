package interfaceAccess;

import exception.AllPersonException;
import exception.PersonException;
import model.Person;
import java.time.LocalDate;
import java.util.ArrayList;

public interface PersonDataAccess {
    ArrayList<Person> getAllPerson() throws AllPersonException;
    Person getPerson(int person) throws PersonException;
}
