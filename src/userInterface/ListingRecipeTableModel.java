package userInterface;

import controller.RecipeController;
import exception.NumberRecipeException;
import exception.TypeException;
import model.Recipe;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ListingRecipeTableModel extends AbstractTableModel {
    private RecipeController recipeController;
    private String[] columnName;
    public ListingRecipeTableModel() {
        this.columnName = new String[] {
            "Identifiant",
            "Titre",
            "Chaux",
            "Date de publication",
            "num auteur",
            "Temps de préparation",
            "Note de l'auteur",
            "Salé",
            "Pour combien de personne",
            "Niveau de complexité"
        };
        this.recipeController = new RecipeController();
    }
    public int getColumnCount() {
        return columnName.length;
    }
    public int getRowCount() {
        try {
            return recipeController.getNumberRecipe();
        } catch (NumberRecipeException exception) {
            System.out.println(exception.getMessage());
            return 0;
        }
    }
    public String getColumnName(int col){
        return columnName[col];
    }
    public Object getValueAt(int row, int col){
        try {
            ArrayList<Recipe> recipes = recipeController.readAllRecipe();
            Recipe recipe = recipes.get(row);
            return switch (col) {
                case 0 -> recipe.getCode();
                case 1 -> recipe.getTitle();
                case 2 -> recipe.getIsHot();
                case 3 -> recipe.getPublicationDate();
                case 4 -> recipe.getPerson();
                case 5 -> recipe.getTimePreparation();
                case 6 -> recipe.getNoteAuthor();
                case 7 -> recipe.getIsSalted();
                case 8 -> recipe.getNumberPeopleConcerned();
                case 9 -> recipe.getComplexity();
                default -> null;
            };
        } catch (TypeException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }
}
