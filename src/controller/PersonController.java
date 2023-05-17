package controller;

import business.PersonManager;
import exception.PersonException;
import model.Person;

import java.util.ArrayList;

public class PersonController {
    private PersonManager manager;

    public PersonController() {
        setManager(new PersonManager());
    }

    public void setManager(PersonManager manager) {
        this.manager = manager;
    }

    public ArrayList<Person> readAllPerson() throws PersonException {
        return this.manager.readAllPerson();
    }

    public Person readPerson(int person) throws PersonException {
        return this.manager.readPerson(person);
    }
}
