package model;

import java.time.LocalDate;

public class Person {
    private int id;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private String password;

    public Person(
            int id,
            String firstname,
            String lastname,
            LocalDate birthday,
            String password
    ) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + " " + birthday;
    }
}
