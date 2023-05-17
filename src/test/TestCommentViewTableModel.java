package test;

import model.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tachemetier.AddCommentPanel;
import tachemetier.CommentViewTableModel;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCommentViewTableModel {


private CommentViewTableModel commentViewTableModel;

    @BeforeEach
    public void setUp() throws Exception {
        ArrayList<Comment> comments = new ArrayList<>();
        comments.add(new Comment(2,2,"c'est ok",3,"un commentaire",3));
        comments.add(new Comment(2,2,"c'est ok",3,"un commentaire",3));
        comments.add(new Comment(2,2,"c'est ok",3,"un commentaire",3));
        commentViewTableModel = new CommentViewTableModel(comments);

}
    @Test
    public void getColumnName(){
        assertEquals("Message",commentViewTableModel.getColumnName(1));
    }
   @Test
   public void getColumnCount(){
        assertEquals(5,commentViewTableModel.getColumnCount());
   }
   @Test
   public void getRowCount(){
        assertEquals(3,commentViewTableModel.getRowCount());
   }
   
}

