package model;

import java.time.LocalDate;

public class Recipe {
    private int code;
    private String title;
    private boolean isHot;
    private LocalDate publicationDate;
    private String description;
    private int timePreparation;
    private String noteAuthor;
    private boolean isSalted;
    private int numberPeopleConcerned;
    private Complexity complexity;
    private int speciality;
    private int person;

    public Recipe(
        int code,
        String title,
        boolean isHot,
        LocalDate publicationDate,
        int timePreparation,
        boolean isSalted,
        int numberPeopleConcerned,
        Complexity complexity,
        int person
    ) {
        this.code = code;
        this.title = title;
        this.isHot = isHot;
        this.publicationDate = publicationDate;
        this.timePreparation = timePreparation;
        this.isSalted = isSalted;
        this.numberPeopleConcerned = numberPeopleConcerned;
        this.complexity = complexity;
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

    public int getTimePreparation() {
        return timePreparation;
    }

    public String getNoteAuthor() {
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

    public int getSpeciality() {
        return speciality;
    }

    public int getPerson() {
        return person;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setTimePreparation(int timePreparation) {
        this.timePreparation = timePreparation;
    }

    public void setSalted(boolean salted) {
        this.isSalted = salted;
    }

    public void setNumberPeopleConcerned(int numberPeopleConcerned) {
        this.numberPeopleConcerned = numberPeopleConcerned;
    }

    public void setComplexity(Complexity complexity) {
        this.complexity = complexity;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNoteAuthor(String noteAuthor) {
        this.noteAuthor = noteAuthor;
    }

    public void setSpeciality(int speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return title + " " + publicationDate;
    }
}
