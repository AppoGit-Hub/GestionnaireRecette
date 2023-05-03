package model;

import java.time.LocalDate;

public class Person {
    private int id;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private String password;

    public Person(int id, String firstname, String lastname, LocalDate birthday, String password) {
        this.setId(id);
        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.setBirthday(birthday);
        this.setPassword(password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + " " + birthday;
    }
}
