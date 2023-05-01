package controller;

import business.PersonManager;
import exception.AllPersonException;
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

    public ArrayList<Person> getAllPerson() throws AllPersonException {
        return this.manager.getAllPerson();
    }
}
