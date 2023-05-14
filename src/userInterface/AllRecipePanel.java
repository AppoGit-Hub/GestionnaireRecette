package userInterface;

import controller.RecipeController;
import exception.AllRecipeException;
import model.Recipe;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class AllRecipePanel extends AbstractTableModel {
    private RecipeController recipeController;
    private ArrayList<String> columnName;
    private ArrayList<Recipe> contentRecipe;
    public AllRecipePanel(){
        try {
            columnName = new ArrayList<>();
            contentRecipe = new ArrayList<>();
            recipeController = new RecipeController();
            contentRecipe = recipeController.getAllRecipe();
            columnName.add("Identifiant");
            columnName.add("Titre");
            columnName.add("Chaux");
            columnName.add("Date de publication");
            columnName.add("num auteur");
            columnName.add("Temps de préparation");
            columnName.add("Note de l'auteur");
            columnName.add("Salé");
            columnName.add("Pour combien de personne");
            columnName.add("Niveau de complexité");
        }catch(Exception exception){
            System.out.println(exception.getMessage()+"niveau allRecipePanel");// je deteste les exceptions merde de merde
        }
    }
    public int getColumnCount(){return columnName.size();}//là encore je ne sais pas si c'est mieux de trouver un fonction de mysql qui donner le nombre de colonne de la table ou simple de donner directement le nombre de colonne attendue
    public int getRowCount() {
        try {
            return recipeController.getNextCode();//si cela commence à un alors ça vas sinon faire plus un
        } catch (Exception exception) {
            System.exit(0);// normalement l'instruction après ne fonctionnera jamais
            return 10;//je ne sais pas comment faire pour que le return ne renvoie rien et que le code s'arrete juste
        }
    }
    public String getColumnName(int col){
        return columnName.get(col);
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
                object = ((recipe.getPublicationDate() != null)?
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
    public Class getColumnClass(int column){//je ne suis plus sur si column commence à 0 ou 1 donc on verra youppie !!!
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
        }//truc sert à dire quelle type est la column pour l'affichage
        return classe;
    }

}
