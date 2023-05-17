package business;

import dataAccess.PersonDataBaseAccess;
import exception.PersonException;
import interfaceAccess.PersonDataAccess;
import model.Person;

import java.util.ArrayList;

public class PersonManager {
    private PersonDataAccess personAccess;

    public PersonManager() {
        setPersonAccess(new PersonDataBaseAccess());
    }

    public void setPersonAccess(PersonDataAccess personAccess) {
        this.personAccess = personAccess;
    }

    public ArrayList<Person> readAllPerson() throws PersonException {
        return this.personAccess.readAllPerson();
    }

    public Person readPerson(int person) throws PersonException {
        return this.personAccess.readPerson(person);
    }
}
