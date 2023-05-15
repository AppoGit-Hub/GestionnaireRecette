package model;

import controller.PersonController;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CommetViewTableModel extends AbstractTableModel {
    private String[] columnNames;
    private ArrayList<Comment> comments;
    private PersonController personController;

    public CommetViewTableModel(ArrayList<Comment> comments) {
        this.personController = new PersonController();
        this.columnNames = new String[] {
                "Title",
                "Message",
                "Rating",
                "Author FirstName",
                "Author LastName"
        };
        setComments(comments);
    }

    @Override
    public String getColumnName(int col){
        return this.columnNames[col];
    }

    @Override
    public int getRowCount() {
        return comments.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Comment comment = comments.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return comment.getTitle();
            case 1:
                return comment.getMessage();
            case 2:
                return comment.getRating();
            case 3:
                try {
                    Person author = personController.getPerson(comment.getPerson());
                    return author.getFirstname();
                } catch (Exception exception) {
                    System.out.printf(exception.getMessage());
                }
            case 4:
                try {
                    Person author = personController.getPerson(comment.getPerson());
                    return author.getLastname();
                } catch (Exception exception) {
                    System.out.printf(exception.getMessage());
                }
        }
        return null;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
}
