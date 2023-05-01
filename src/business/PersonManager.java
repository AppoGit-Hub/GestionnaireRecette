package business;

import dataAccess.PersonDataBaseAccess;
import exception.AllPersonException;
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

    public ArrayList<Person> getAllPerson() throws AllPersonException {
        return this.personAccess.getAllPerson();
    }
}
