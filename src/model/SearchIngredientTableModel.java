package model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class SearchIngredientTableModel extends AbstractTableModel {
    private String[] columnNames;
    private ArrayList<SearchIngredientResult> searchIngredientResults;

    public SearchIngredientTableModel(ArrayList<SearchIngredientResult> searchIngredientResults) {
        this.columnNames = new String[] {
            "Recipe",
            "Ingredient",
            "FoodCategory",
            "Date Begining",
            "Date Ending",
            "Quantity"
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

    public void setSearchIngredientResults(ArrayList<SearchIngredientResult> searchIngredientResults) {
        this.searchIngredientResults = searchIngredientResults;
    }
}
