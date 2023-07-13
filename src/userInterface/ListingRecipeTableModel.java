package userInterface;

import controller.ComplexityController;
import controller.RecipeController;
import exception.NumberRecipeException;
import exception.TypeException;
import model.Complexity;
import model.Recipe;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.ArrayList;

public class ListingRecipeTableModel extends AbstractTableModel {
    private String[] columnName;
    private RecipeController recipeController;
    private ComplexityController complexityController;

    public ListingRecipeTableModel() {
        this.columnName = new String[] {
            "Titre",
            "Est Chaux ?",
            "Date de Publication",
            "Numéro de l'Auteur",
            "Temps de Préparation",
            "Note de l'Auteur",
            "est Salé ?",
            "Pour Combien de Personne",
            "Niveau de Complexité"
        };

        this.recipeController = new RecipeController();
        this.complexityController = new ComplexityController();
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

    public Class getColumnClass(int column){
        return switch (column) {
            case 0 -> String.class;
            case 1 -> Boolean.class;
            case 2 -> LocalDate.class;
            case 3 -> Integer.class;
            case 4 -> LocalDate.class;
            case 5 -> Integer.class;
            case 6 -> Boolean.class;
            case 7 -> Integer.class;
            default -> String.class;
        };
    }

    public Object getValueAt(int row, int col){
        try {
            ArrayList<Recipe> recipes = recipeController.readAllRecipe();
            Recipe recipe = recipes.get(row);

            Complexity complexity = this.complexityController.readComplexity(recipe.getComplexity());

            return switch (col) {
                case 0 -> recipe.getTitle();
                case 1 -> recipe.getIsHot();
                case 2 -> recipe.getPublicationDate();
                case 3 -> recipe.getPerson();
                case 4 -> recipe.getTimePreparation();
                case 5 -> recipe.getNoteAuthor();
                case 6 -> recipe.getIsSalted();
                case 7 -> recipe.getNumberPeopleConcerned();
                case 8 -> complexity.getName();
                default -> null;
            };
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
