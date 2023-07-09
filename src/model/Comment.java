package model;

import exception.*;

public class Comment {
    private int recipe;
    private int number;
    private String message;
    private int rating;
    private String title;
    private int person;

    public Comment(int recipe, int number, String message, int rating, String title, int person) throws Exception {
        this.setRecipe(recipe);
        this.setNumber(number);
        this.setMessage(message);
        this.setRating(rating);
        this.setTitle(title);
        this.setPerson(person);
    }

    public int getRecipe() {
        return recipe;
    }

    public void setRecipe(int recipe) throws CommentSetRecipeException {
        if (recipe >= 0) {
            this.recipe = recipe;
        } else {
            throw new CommentSetRecipeException(recipe);
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) throws CommentSetNumberException {
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) throws CommentSetRatingException {
        if (rating >= 0 && rating <= 10) {
            this.rating = rating;
        } else {
            throw new CommentSetRatingException(rating);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws CommentSetTitleException {
        if (title != null && title.length() > 0) {
            this.title = title;
        } else {
            throw new CommentSetTitleException(title);
        }
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) throws CommentSetPersonException {
        if (person >= 0) {
            this.person = person;
        } else {
            throw new CommentSetPersonException(person);
        }
    }
}
