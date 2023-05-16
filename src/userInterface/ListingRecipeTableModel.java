package userInterface;

import controller.RecipeController;
import exception.NumberRecipeException;
import model.Recipe;

import javax.swing.table.AbstractTableModel;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class ListingRecipeTableModel extends AbstractTableModel {
    private RecipeController recipeController;
    private String[] columnName;
    private ArrayList<Recipe> contentRecipe;
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
            return recipeController.getNumberRecipe();
        }catch (NumberRecipeException exception){
            System.out.println("erreur : getnumberRecipe");
            return 0;
        }
    }
    public String getColumnName(int col){
        return columnName[col];
    }
    public Object getValueAt(int row, int col){
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
                        java.util.Date.from(recipe.getPublicationDate().atStartOfDay(ZoneId.systemDefault()).toInstant())
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
        Class aClass;
        if(column == 0 || column == 5 || column == 6|| column == 8 || column == 9 || column == 4)
            aClass = Integer.class;
        else{
            if (column == 1 ) {
                aClass = String.class;
            }
            else {
                if(column == 2 || column == 7){
                    aClass = Boolean.class;
                }
                else{
                    aClass = Date.class;
                }
            }
        }
        return aClass;
    }

}
