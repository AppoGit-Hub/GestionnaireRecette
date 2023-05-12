package model;
import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SearchDietTableModel extends AbstractTableModel {
    private String[] columnNames;
    private ArrayList<Recipe> recipes;

    public SearchDietTableModel(ArrayList<Recipe> recipes) {
        this.columnNames = new String[] {
                "Title",
                "Publication Date",
                "Number People",
                "Complexitu Level",
                "Author"
        };
        setRecipes(recipes);
    }

    @Override
    public int getRowCount() {
        return recipes.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    public void setRecipes(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }
}