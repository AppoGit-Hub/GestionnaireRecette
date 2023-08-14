package test;

import exception.*;
import model.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import userInterface.CommentViewTableModel;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCommentViewTableModel {
    private Comment comment;

    @BeforeEach
    public void setUp() throws Exception {
        this.comment = new Comment(0, 0, "test message", 1, "test title", 0);
    }

    @Test
    public void setRecipeTest() throws CommentSetRecipeException {
        assertThrows(CommentSetRecipeException.class, () -> {
            this.comment.setRecipe(-1);
        });
        assertEquals(this.comment.getRecipe(), 0);
        this.comment.setRecipe(1);
        assertEquals(this.comment.getRecipe(), 1);
    }

    @Test
    public void setNumberTest() throws CommentSetNumberException {
        assertThrows(CommentSetNumberException.class, () -> {
            this.comment.setNumber(-1);
        });
        assertEquals(this.comment.getNumber(), 0);
        this.comment.setNumber(1);
        assertEquals(this.comment.getNumber(), 1);
    }

    @Test
    public void setMessageTest() throws CommentSetMessageException {
        assertThrows(CommentSetMessageException.class, () -> {
            this.comment.setMessage(null);
        });
        assertThrows(CommentSetMessageException.class, () -> {
            this.comment.setMessage("");
        });
        assertEquals(this.comment.getMessage(), "test message");
        this.comment.setMessage("test message 2");
        assertEquals(this.comment.getMessage(), "test message 2");
    }

    @Test
    public void setRatingTest() throws CommentSetRatingException {
        assertThrows(CommentSetRatingException.class, () -> {
            this.comment.setRating(-1);
        });
        assertThrows(CommentSetRatingException.class, () -> {
            this.comment.setRating(11);
        });
        assertEquals(this.comment.getRating(), 1);
        this.comment.setRating(5);
        assertEquals(this.comment.getRating(), 5);
    }
    @Test
    public void setTitleTest()  {
        assertEquals(this.comment.getTitle(), "test title");
        this.comment.setTitle("test title 2");
        assertEquals(this.comment.getTitle(), "test title 2");
    }

    @Test
    public void setPersonTest() throws CommentSetPersonException {
        assertThrows(CommentSetPersonException.class, () -> {
            this.comment.setPerson(-1);
        });
        assertEquals(this.comment.getPerson(), 0);
        this.comment.setPerson(1);
        assertEquals(this.comment.getPerson(), 1);
    }
}

