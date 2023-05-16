package model;

import exception.*;

import java.time.LocalDate;

public class Recipe {
    private int code;
    private String title;
    private boolean isHot;
    private LocalDate publicationDate;
    private String description;
    private int timePreparation;
    private int noteAuthor;
    private boolean isSalted;
    private int numberPeopleConcerned;
    private Complexity complexity;
    private Integer speciality;
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
        this.setCode(code);
        this.setTitle(title);
        this.setIsHot(isHot);
        this.setPublicationDate(publicationDate);
        this.setTimePreparation(timePreparation);
        this.setIsSalted(isSalted);
        this.setNumberPeopleConcerned(numberPeopleConcerned);
        this.setComplexity(complexity);
        this.setPerson(person);
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

    public void setNoteAuthor(int note) {
        this.noteAuthor = note;
    }

    public int getNoteAuthor() {
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

    public Integer getSpeciality() {
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

    public void setIsHot(boolean hot) {
        this.isHot = hot;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setTimePreparation(int timePreparation) {
        this.timePreparation = timePreparation;
    }

    public void setIsSalted(boolean salted) {
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

    public void setSpeciality(Integer speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return title + " " + publicationDate;
    }
}
