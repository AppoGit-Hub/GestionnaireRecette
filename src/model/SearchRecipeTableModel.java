package model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class SearchRecipeTableModel extends AbstractTableModel {
    private String[] columnNames;
    private ArrayList<SearchRecipeResult> searchRecipeResult;

    public SearchRecipeTableModel(ArrayList<SearchRecipeResult> searchRecipeResult) {
        this.columnNames = new String[] {
            "Title",
            "Firstname",
            "Lastname",
            "Country"
        };
        setSearchRecipeResult(searchRecipeResult);
    }

    public void setSearchRecipeResult(ArrayList<SearchRecipeResult> searchRecipeResult) {
        this.searchRecipeResult = searchRecipeResult;
    }

    @Override
    public int getRowCount() {
        return searchRecipeResult.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SearchRecipeResult resultRecipe = searchRecipeResult.get(rowIndex);
        switch (columnIndex) {
            case 0 :
                return resultRecipe.getRecipetitle();
            case 1:
                return resultRecipe.getPersonFirstName();
            case 2:
                return resultRecipe.getPersonLastName();
            case 3:
                return resultRecipe.getCountryName();
        }
        return null;
    }
}
