package dataAccess;

import exception.AllCountryException;
import exception.AllPersonException;
import exception.PersonException;
import interfaceAccess.PersonDataAccess;
import model.Country;
import model.Person;

import java.sql.*;
import java.util.ArrayList;

public class PersonDataBaseAccess implements PersonDataAccess {

    @Override
    public ArrayList<Person> getAllPerson() throws AllPersonException {
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
            throw new AllPersonException(exception.getMessage());
        }
    }

    @Override
    public Person getPerson(int person) throws PersonException {
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
            throw new PersonException(exception.getMessage());
        }
    }
}
