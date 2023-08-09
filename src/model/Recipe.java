package model;

import exception.*;

import java.time.LocalDate;

public class Recipe {
    private int code;
    private String title;
    private boolean isHot;
    private LocalDate publicationDate;
    private String description;
    private Integer timePreparation;
    private Integer noteAuthor;
    private boolean isSalted;
    private Integer numberPeopleConcerned;
    private Integer complexity;
    private Integer speciality;
    private Integer person;

    public Recipe(
        int code,
        String title,
        boolean isHot,
        LocalDate publicationDate,
        Integer timePreparation,
        boolean isSalted,
        Integer numberPeopleConcerned,
        Integer complexity,
        Integer person
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
    public Integer getTimePreparation() {
        return timePreparation;
    }
    public void setNoteAuthor(Integer note) {
        this.noteAuthor =  note;
    }
    public Integer getNoteAuthor() {
        return noteAuthor;
    }
    public boolean getIsSalted() {
        return isSalted;
    }
    public Integer getNumberPeopleConcerned() {
        return numberPeopleConcerned;
    }
    public Integer getComplexity() {
        return complexity;
    }
    public Integer getSpeciality() {
        return speciality;
    }
    public Integer getPerson() {
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
    public void setTimePreparation(Integer timePreparation) {
        this.timePreparation = timePreparation;
    }
    public void setIsSalted(boolean salted) {
        this.isSalted = salted;
    }
    public void setNumberPeopleConcerned(Integer numberPeopleConcerned) {
        this.numberPeopleConcerned = numberPeopleConcerned;
    }
    public void setComplexity(Integer complexity) {
        this.complexity = complexity;
    }
    public void setPerson(Integer person) {
        this.person = person;
    }
    public void setDescription(String description) {
        if (description.isBlank() || description.isEmpty()) {
            this.description = null;
        } else {
            this.description = description;
        }
    }
    public void setSpeciality(Integer speciality) {
        this.speciality = speciality;
    }
    @Override
    public String toString() {
        return title + " " + publicationDate;
    }
}
