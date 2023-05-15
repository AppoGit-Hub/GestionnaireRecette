package model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CommetViewTableModel extends AbstractTableModel {
    private String[] columnNames;
    private ArrayList<Comment> comments;

    public CommetViewTableModel(ArrayList<Comment> comments) {
        this.columnNames = new String[] {
                "Title",
                "Message",
                "Rating",
                "Author ID"
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
                return comment.getPerson();
        }
        return null;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
}
