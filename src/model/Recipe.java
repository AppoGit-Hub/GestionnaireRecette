package model;

import java.time.LocalDate;

public class Recipe {
    private int code;
    private String title;
    private boolean isHot;
    private LocalDate publicationDate;
    private String description;
    private LocalDate timePreparation;
    private Integer noteAuthor;
    private boolean isSalted;
    private int numberPeopleConcerned;
    private Complexity complexity;
    private Country speciality;
    private Person person;

    public Recipe(
        int code,
        String title,
        boolean isHot,
        LocalDate publicationDate,
        String description,
        LocalDate timePreparation,
        Integer noteAuthor,
        boolean isSalted,
        int numberPeopleConcerned,
        Complexity complexity,
        Country speciality,
        Person person
    ) {
        this.code = code;
        this.title = title;
        this.isHot = isHot;
        this.publicationDate = publicationDate;
        this.description = description;
        this.timePreparation = timePreparation;
        this.noteAuthor = noteAuthor;
        this.isSalted = isSalted;
        this.numberPeopleConcerned = numberPeopleConcerned;
        this.complexity = complexity;
        this.speciality = speciality;
        this.person = person;
    }

    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public boolean getIsHot() {
        return isHot;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getTimePreparation() {
        return timePreparation;
    }

    public Integer getNoteAuthor() {
        return noteAuthor;
    }

    public boolean getIsSalted() {
        return isSalted;
    }

    public int getNumberPeopleConcerned() {
        return numberPeopleConcerned;
    }

    public Complexity getComplexity() {
        return complexity;
    }

    public Country getSpeciality() {
        return speciality;
    }

    public Person getPerson() {
        return person;
    }
}
