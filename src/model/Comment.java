package model;

public class Comment {
    private int recipe;
    private int number;
    private String message;
    private int rating;
    private String title;
    private int person;

    public Comment(int recipe, int number, String message, int rating, String title, int person) {
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

    public void setRecipe(int recipe) {
        if (recipe >= 0) {
            this.recipe = recipe;
        } else {
            // throw exception ?
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number >= 0) {
            this.number = number;
        } else {
            // throw exception ?
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        if (message.length() > 0) {
            this.message = message;
        } else {
            // throw exception ?
        }
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating >= 0 && rating <= 10) {
            this.rating = rating;
        } else {
            // throw exception ?
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (this.title.length() > 0) {
            this.title = title;
        } else {
            // throw exception ?
        }
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        if (person >= 0) {
            this.person = person;
        } else {
            // throw exception ?
        }
    }
}
