package userInterface;

import model.Country;
import model.FoodCategory;
import model.SearchRecipeResult;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.ArrayList;

public class SearchRecipeTableModel extends AbstractTableModel {
    private String[] columnNames;
    private ArrayList<SearchRecipeResult> searchRecipeResult;

    public SearchRecipeTableModel(ArrayList<SearchRecipeResult> searchRecipeResult) {
        this.columnNames = new String[] {
            "Titre",
            "Prénom",
            "Nom",
            "Pays"
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
        return switch (columnIndex) {
            case 0 -> resultRecipe.getRecipetitle();
            case 1 -> resultRecipe.getPersonFirstName();
            case 2 -> resultRecipe.getPersonLastName();
            case 3 -> resultRecipe.getCountryName();
            default -> null;
        };
    }

    public Class getColumnClass(int column){
        return switch (column) {
            case 0 -> String.class;
            case 1 -> String.class;
            case 2 -> String.class;
            default -> Country.class;
        };
    }

}
