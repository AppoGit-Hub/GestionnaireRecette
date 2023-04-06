package model;

public class Comment {
    private Recipe recipe;
    private int number;
    private String message;
    private int rating;
    private String title;
    private Person person;

    public Comment(
            Recipe recipe,
            int number,
            String message,
            int rating,
            String title,
            Person person
    ) {
        this.recipe = recipe;
        this.number = number;
        this.message = message;
        this.rating = rating;
        this.title = title;
        this.person = person;
    }

    public Recipe getRecipe() {
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

    public Person getPerson() {
        return person;
    }
}
