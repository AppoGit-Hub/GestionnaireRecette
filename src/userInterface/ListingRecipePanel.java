package userInterface;

import controller.RecipeController;
import exception.AllRecipeException;
import exception.DeleteRecipeException;
import model.Recipe;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListingRecipePanel extends JPanel implements ActionListener {
    private AllRecipePanel allRecipePanel;
    private JScrollPane jScrollPane;
    private JTable jTable;
    private JPanel jNorthBottonPanel;
    private JButton deleteButton,addButton,changeButton;
    private ListSelectionModel listSelectionModelRecipe;
    private RecipeController recipeController;
    private ArrayList<Recipe> setRecipe;

    public ListingRecipePanel(){
        jNorthBottonPanel = new JPanel();
        deleteButton = new JButton("Elimination");
        this.deleteButton.addActionListener(this);
        this.deleteButton.setActionCommand("delete recipe");//on donne un string au event
        addButton = new JButton("Ajout");
        changeButton = new JButton("Modifier");
        this.changeButton.addActionListener(this);
        this.changeButton.setActionCommand("change recipe");
        jNorthBottonPanel.add(addButton);
        jNorthBottonPanel.add(changeButton);
        jNorthBottonPanel.add(deleteButton);
        this.add(jNorthBottonPanel, BorderLayout.NORTH);

        this.allRecipePanel = new AllRecipePanel();
        this.jTable = new JTable(allRecipePanel);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//pour ne permettre que une seul selectionµ
        this.listSelectionModelRecipe = jTable.getSelectionModel( );
        TableColumn column = jTable.getColumnModel().getColumn(3);
        column.setPreferredWidth(100);
        jScrollPane = new JScrollPane(jTable);
        this.add(jScrollPane);

    }
    public void actionPerformed (ActionEvent e){
        String source = e.getActionCommand();
        int indexRecipeSelection = this.listSelectionModelRecipe.getMinSelectionIndex();//renvoie le plus petit index selectionner ou -1 si aucun
        if(indexRecipeSelection != -1){
            try{this.recipeController = new RecipeController();
                if(source.equals("delete recipe")){
                    this.setRecipe = recipeController.getAllRecipe();
                    int codeRecipe = setRecipe.get(indexRecipeSelection).getCode();
                    recipeController.deleteRecipe(codeRecipe);
                    this.repaint();
                    this.revalidate();// j'ai lu un truc qui dit que les deux c'est mieux

                }
            }catch(DeleteRecipeException exception){
                System.out.println("erreur au niveau de l'elimination d'une recipe");
            }catch(AllRecipeException exception){
                System.out.println("erreur : getAllRecipe");
            }
        }
        else{
            System.out.println("il faut selectionner pour changer");
        }
    }
}
