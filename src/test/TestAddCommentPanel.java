package test;

import org.junit.jupiter.api.*;
import tachemetier.AddCommentPanel;

public class TestAddCommentPanel  {
    private AddCommentPanel addCommentPanel;


    @BeforeEach
    public void setUp() throws Exception {
        addCommentPanel = new AddCommentPanel();
    }
    @Test
    public void setAllRecipe(){}
    @Test
    public void setAllAuthor(){}
    @Test
    private void setCommentForRecipe(int recipeCode){}
}
