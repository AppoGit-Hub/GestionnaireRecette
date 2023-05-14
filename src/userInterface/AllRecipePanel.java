package userInterface;

import controller.RecipeController;
import exception.AllRecipeException;
import exception.NextCodeRecipeException;
import model.Recipe;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class AllRecipePanel extends AbstractTableModel {
    private RecipeController recipeController;
    private String[] columnName;
    private ArrayList<Recipe> contentRecipe;
    public AllRecipePanel() {
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
        try {
            this.contentRecipe = recipeController.getAllRecipe();
        } catch(Exception exception) {
            System.out.println(exception.getMessage() + "niveau allRecipePanel");
        }
    }
    public int getColumnCount() {
        return columnName.length;
    }
    public int getRowCount() {
        try {
            return recipeController.getNextCode();
        } catch (NextCodeRecipeException exception) {
            System.out.printf(exception.getMessage());
            return 0;
        }
    }
    public String getColumnName(int col){
        return columnName[col];
    }
    public Object getValueAt(int row,int col){
        Recipe recipe = contentRecipe.get(row);
        Object object;
        switch(col){
            case 0 :
                object = recipe.getCode();
                break;
            case 1 :
                object = recipe.getTitle();
                break;
            case 2 :
                object = recipe.getIsHot();
                break;
            case 3 :
                object = ((recipe.getPublicationDate() != null) ?
                    object = java.util.Date.from(recipe.getPublicationDate().atStartOfDay(ZoneId.systemDefault()).toInstant())
                : null);
                break;
            case 4 :
                object = recipe.getPerson();
                break;
            case 5 :
                object = recipe.getTimePreparation();
                break;
            case 6 :
                object = recipe.getNoteAuthor();
                break;
            case 7 :
                object = recipe.getIsSalted();
                break;
            case 8 :
                object = recipe.getNumberPeopleConcerned();
                break;
            default :
                object = recipe.getComplexity();
                break;
        }
        return object;
    }
    public Class getColumnClass(int column){
        Class classe;
        if(column == 0 || column == 5 || column == 6|| column == 8 || column == 9 || column == 4)
            classe = Integer.class;
        else{
            if (column == 1 ) {
                classe = String.class;
            }
            else {
                if(column == 2 || column == 7){
                    classe = Boolean.class;
                }
                else{
                    classe = Date.class;
                }
            }
        }
        return classe;
    }

}
