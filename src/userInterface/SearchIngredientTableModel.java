package userInterface;

import model.Complexity;
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
    public int getRowCount() {
        return searchIngredientResults.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return this.columnNames[column];
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
                return resultRecipe.getDateBegining();
            case 4:
                return resultRecipe.getDateEnding();
            case 5:
                return resultRecipe.getLineRecipeQuantity();
        }
        return null;
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

    public void setSearchIngredientResults(ArrayList<SearchIngredientResult> searchIngredientResults) {
        this.searchIngredientResults = searchIngredientResults;
    }
}
