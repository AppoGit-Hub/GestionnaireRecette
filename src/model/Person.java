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
        if (this.id >= 0) {
            this.id = id;
        } else {
            // throw exception ?
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        if (firstname.length() > 0) {
            this.firstname = firstname;
        } else {
            // throw exception ?
        }
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        if (lastname.length() > 0) {
            this.lastname = lastname;
        } else {
            // throw exception ?
        }
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
        if (password.length() > 0) {
            this.password = password;
        } else {
            // throw exception ?
        }
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + " " + birthday;
    }
}
