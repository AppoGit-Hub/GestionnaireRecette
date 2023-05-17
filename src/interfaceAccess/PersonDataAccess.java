package interfaceAccess;

import exception.PersonException;
import model.Person;

import java.util.ArrayList;

public interface PersonDataAccess {
    ArrayList<Person> readAllPerson() throws PersonException;
    Person readPerson(int person) throws PersonException;
}
