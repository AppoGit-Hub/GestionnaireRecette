package userInterface;

import controller.CommentController;
import controller.PersonController;
import controller.RecipeController;
import exception.CommentException;
import exception.TypeException;
import model.Comment;
import model.FormBuilder;
import model.Person;
import model.Recipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddCommentPanel extends JPanel implements ActionListener {
    private JTextArea commentFormMessage;
    private JSpinner commentFormRating;
    private JTextField commentFormTitle;
    private JComboBox<Person> commentFormAuthor;
    private DefaultComboBoxModel<Person> commentFormAuthorModel;
    private JButton commentFormPublish;
    private JComboBox<Recipe> recipeViewComboBox;
    private DefaultComboBoxModel<Recipe> recipeViewComboBoxModel;
    private JTable commentTable;
    private RecipeController recipeController;
    private PersonController personController;
    private CommentController commentController;

    private JTabbedPane tabs;
    private static final int RATING_MIN_VALUE = 0;
    private static final int RATING_MAX_VALUE = 10;

    public AddCommentPanel() {
        this.setLayout(new BorderLayout());

        this.recipeController = new RecipeController();
        this.personController = new PersonController();
        this.commentController = new CommentController();
        this.commentFormTitle = new JTextField();
        this.commentFormMessage = new JTextArea(10, 10);
        SpinnerNumberModel commentRatingLimit = new SpinnerNumberModel(RATING_MAX_VALUE / 2, RATING_MIN_VALUE, RATING_MAX_VALUE, 1);
        this.commentFormRating = new JSpinner(commentRatingLimit);
        this.commentFormAuthorModel = new DefaultComboBoxModel<Person>();
        this.commentFormAuthor = new JComboBox<Person>(commentFormAuthorModel);
        this.commentFormPublish = new JButton("Create");
        this.commentFormPublish.addActionListener(this);
        this.recipeViewComboBoxModel = new DefaultComboBoxModel<Recipe>();
        this.recipeViewComboBox = new JComboBox<Recipe>(recipeViewComboBoxModel);
        this.recipeViewComboBox.addActionListener(this);
        this.commentTable = new JTable();

        JPanel commentNorthPanel = new JPanel();
        commentNorthPanel.add(new JLabel("Recipes:"));
        commentNorthPanel.add(recipeViewComboBox);

        JPanel commentCreatorPanel = new JPanel();
        commentCreatorPanel.setLayout(new BorderLayout());
        JPanel commentFormPanel = new FormBuilder()
                .addLabelAnd(new JLabel("Title"), commentFormTitle)
                .addLabelAnd(new JLabel("Message"), commentFormMessage)
                .addLabelAnd(new JLabel("Rating"), commentFormRating)
                .addLabelAnd(new JLabel("Author"), commentFormAuthor)
                .build();
        commentCreatorPanel.add(commentFormPanel, BorderLayout.CENTER);
        commentCreatorPanel.add(commentFormPublish, BorderLayout.SOUTH);

        JPanel commentViewPanel = new JPanel();
        commentViewPanel.setLayout(new BorderLayout());
        commentViewPanel.add(new JScrollPane(commentTable), BorderLayout.CENTER);

        this.setAllRecipe();
        this.setAllAuthor();

        this.tabs = new JTabbedPane();
        this.tabs.insertTab("Create", null, commentCreatorPanel, "Create Comment", 0);
        this.tabs.insertTab("View", null, commentViewPanel, "View Comment", 1);

        this.add(commentNorthPanel, BorderLayout.NORTH);
        this.add(this.tabs, BorderLayout.CENTER);
    }

    public void setAllRecipe() {
        try {
            ArrayList<Recipe> recipes = this.recipeController.readAllRecipe();
            this.recipeViewComboBoxModel.addAll(recipes);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.WARNING_MESSAGE);
        }
    }

    public void setAllAuthor() {
        try {
            ArrayList<Person> authors = this.personController.readAllPerson();
            this.commentFormAuthorModel.addAll(authors);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.WARNING_MESSAGE);
        }
    }

    private void setCommentForRecipe(int recipeCode) throws CommentException, Exception {
        ArrayList<Comment> commentsFromRecipe = this.commentController.readAllComment(recipeCode);
        this.commentTable.setModel(new CommentViewTableModel(commentsFromRecipe));
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String eventName = event.getActionCommand();
        Recipe recipe = (Recipe) this.recipeViewComboBox.getSelectedItem();
        if (eventName.equals("Create")) {
            if (recipe != null) {
                try {
                    int nextNumber = this.commentController.getNumberComment(recipe.getCode()) + 1;
                    String message = this.commentFormMessage.getText();
                    int rating = (int) this.commentFormRating.getValue();
                    String title = this.commentFormTitle.getText();
                    Person author = (Person) this.commentFormAuthor.getSelectedItem();
                    if (author != null && message.length() > 0) {
                        Comment comment = new Comment(recipe.getCode(), nextNumber, message, rating, title, author.getId());
                        this.commentController.createComment(comment);
                        this.setCommentForRecipe(recipe.getCode());
                    } else {
                        if (author == null) {
                            JOptionPane.showMessageDialog(null, "You must chosse an author", "Chosse an Author", JOptionPane.ERROR_MESSAGE);
                        } else if (message.length() == 0) {
                            JOptionPane.showMessageDialog(null, "You must write an message", "Write a Message", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "An error occured while creating the comment", "An Error Occured", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "You must select a recipe", "Select a Recipe", JOptionPane.ERROR_MESSAGE);
            }
        } else if (eventName.equals("comboBoxChanged")) {
            if (recipe != null) {
                try {
                    this.setCommentForRecipe(recipe.getCode());
                } catch (CommentException exception) {
                    JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "An error occured while creating the comment", "An Error Occured", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
