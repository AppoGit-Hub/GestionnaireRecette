package userInterface;

import model.FoodCategory;
import model.SearchIngredientResult;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.ArrayList;

public class SearchIngredientTableModel extends AbstractTableModel {
    private String[] columnNames;
    private ArrayList<SearchIngredientResult> searchIngredientResults;

    public SearchIngredientTableModel(ArrayList<SearchIngredientResult> searchIngredientResults) {
        this.columnNames = new String[] {
            "Recette",
            "Ingredient",
            "Categorie de Nourriture",
            "Date de Debut",
            "Date de Fin",
            "Quantités"
        };
        setSearchIngredientResults(searchIngredientResults);
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }
    @Override
    public int getRowCount() {
        return searchIngredientResults.size();
    }

    @Override
    public String getColumnName(int column) {
        return this.columnNames[column];
    }

    public Class getColumnClass(int column){
        return switch (column) {
            case 0 -> String.class;
            case 1 -> Integer.class;
            case 2 -> FoodCategory.class;
            case 3 -> LocalDate.class;
            case 4 -> LocalDate.class;
            default -> Integer.class;
        };
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SearchIngredientResult resultRecipe = searchIngredientResults.get(rowIndex);
        switch (columnIndex) {
            case 0 :
                return resultRecipe.getRecipeTitle();
            case 1:
                return resultRecipe.getIngredient();
            case 2:
                return resultRecipe.getFoodCategory();
            case 3:
                LocalDate dateBegining = resultRecipe.getDateBegining();
                if (dateBegining == null) {
                    return "Inéxistante";
                } else {
                    return dateBegining;
                }
            case 4:
                LocalDate dateEnding = resultRecipe.getDateEnding();
                if (dateEnding == null) {
                    return "Inéxistante";
                } else {
                    return dateEnding;
                }
            case 5:
                return resultRecipe.getLineRecipeQuantity();
        }
        return null;
    }

    public void setSearchIngredientResults(ArrayList<SearchIngredientResult> searchIngredientResults) {
        this.searchIngredientResults = searchIngredientResults;
    }
}
