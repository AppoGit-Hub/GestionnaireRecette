package model;

public class Comment {
    private int recipe;
    private int number;
    private String message;
    private int rating;
    private String title;
    private int person;

    public Comment(
            int recipe,
            int number,
            String message,
            int rating,
            String title,
            int person
    ) {
        this.recipe = recipe;
        this.number = number;
        this.message = message;
        this.rating = rating;
        this.title = title;
        this.person = person;
    }

    public int getRecipe() {
        return recipe;
    }

    public int getNumber() {
        return number;
    }

    public String getMessage() {
        return message;
    }

    public int getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    public int getPerson() {
        return person;
    }
}
