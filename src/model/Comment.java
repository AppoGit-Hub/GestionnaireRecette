package model;

import exception.*;

public class Comment {
    private Integer recipe;
    private Integer number;
    private String message;
    private Integer rating;
    private String title;
    private Integer person;

    public Comment(Integer recipe, Integer number, String message, Integer rating, String title, Integer person) throws Exception {
        this.setRecipe(recipe);
        this.setNumber(number);
        this.setMessage(message);
        this.setRating(rating);
        this.setTitle(title);
        this.setPerson(person);
    }

    public Integer getRecipe() {
        return recipe;
    }

    public void setRecipe(Integer recipe) throws CommentSetRecipeException {
        if (recipe >= 0) {
            this.recipe = recipe;
        } else {
            throw new CommentSetRecipeException(recipe);
        }
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) throws CommentSetNumberException {
        if (number >= 0) {
            this.number = number;
        } else {
            throw new CommentSetNumberException(number);
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) throws CommentSetMessageException {
        if (message != null && message.length() > 0) {
            this.message = message;
        } else {
            throw new CommentSetMessageException(message);
        }
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) throws CommentSetRatingException {
        if (rating >= 0 && rating <= 10) {
            this.rating = rating;
        } else {
            throw new CommentSetRatingException(rating);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        /*
        if (title != null && title.length() > 0) {
            this.title = title;
        } else {
            throw new CommentSetTitleException(title);
        }
        */
    }

    public Integer getPerson() {
        return person;
    }

    public void setPerson(Integer person) throws CommentSetPersonException {
        if (person >= 0) {
            this.person = person;
        } else {
            throw new CommentSetPersonException(person);
        }
    }
}
