package model;

import java.time.LocalDate;

public class SearchDietResult {
    private int code;
    private String title;
    private LocalDate publicationDate;
    private Integer numberPeople;
    private Complexity complexity;
    private String firstname;
    private String lastname;

    public SearchDietResult(int code, String title, LocalDate publicationDate, Integer numberPeople, Complexity complexity, String firstname, String lastname) {
        setCode(code);
        setTitle(title);
        setPublicationDate(publicationDate);
        setNumberPeople(numberPeople);
        setComplexity(complexity);
        setFirstname(firstname);
        setLastname(lastname);
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setNumberPeople(Integer numberPeople) {
        this.numberPeople = numberPeople;
    }

    public void setComplexity(Complexity complexity) {
        this.complexity = complexity;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public int getNumberPeople() {
        return numberPeople;
    }

    public Complexity getComplexity() {
        return complexity;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
