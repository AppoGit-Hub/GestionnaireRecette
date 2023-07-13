package dataAccess;

import exception.*;
import interfaceAccess.PersonDataAccess;
import model.Country;
import model.Person;

import java.sql.*;
import java.util.ArrayList;

public class PersonDataBaseAccess implements PersonDataAccess {
    @Override
    public ArrayList<Person> readAllPerson() throws PersonException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM person;";
            PreparedStatement statement = connexion.prepareStatement(query);
            ResultSet data = statement.executeQuery();
            ArrayList<Person> persons = new ArrayList<Person>();
            while (data.next()) {
                int id = data.getInt("id");
                String firstname = data.getString("firstname");
                String lastname = data.getString("lastname");
                Date birthday = data.getDate("birthday");
                String password = data.getString("password");
                Person person = new Person(id, firstname, lastname, birthday.toLocalDate(), password);
                persons.add(person);
            }
            return persons;
        } catch (SQLException exception) {
            throw new PersonException(exception.getMessage(), new AllException(), new ReadException());
        }
    }

    @Override
    public Person readPerson(int person) throws PersonException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM person WHERE id = ?;";

            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, person);
            ResultSet data = statement.executeQuery();
            data.next();

            int id = data.getInt("id");
            String firstname = data.getString("firstname");
            String lastname = data.getString("lastname");
            Date birthday = data.getDate("birthday");
            String password = data.getString("password");

            return new Person(id, firstname, lastname, birthday.toLocalDate(), password);
        } catch (SQLException exception) {
            throw new PersonException(exception.getMessage(), new OneException(), new ReadException());
        }
    }
}
