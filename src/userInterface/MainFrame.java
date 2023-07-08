package userInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    private JPanel currentPanel;
    private static final int SCREEN_RESOLUTION_X = 1920;
    private static final int SCREEN_RESOLUTION_Y = 1080;
    private static final int WINDOWS_RESOLUTION_X = 700;
    private static final int WINDOWS_RESOLUTION_Y = 500;

    public MainFrame() {
        this.currentPanel = new WelcomePanel();
        this.add(currentPanel);

        JMenu crud = new JMenu("CRUD");
        JMenuItem recipePublication = new JMenuItem("Publication de Recette");
        JMenuItem recipeModification = new JMenuItem("Modification de Recette");
        JMenuItem recipeElimination = new JMenuItem("Listing des Recettes");
        JMenuItem recipeListing = new JMenuItem("Elimination de Recette");

        recipePublication.addActionListener(this);
        recipeModification.addActionListener(this);
        recipeElimination.addActionListener(this);
        recipeListing.addActionListener(this);

        crud.add(recipePublication);
        crud.add(recipeModification);
        crud.add(recipeElimination);
        crud.add(recipeListing);

        JMenu search = new JMenu("Recherches");
        JMenuItem ingredient = new JMenuItem("Ingredient");
        JMenuItem diet = new JMenuItem("Regime Alimentaire");
        JMenuItem recipe = new JMenuItem("Recette");

        search.addActionListener(this);
        ingredient.addActionListener(this);
        diet.addActionListener(this);
        recipe.addActionListener(this);

        search.add(ingredient);
        search.add(diet);
        search.add(recipe);

        JMenu jobTask = new JMenu("Tache Metier");
        JMenuItem comment = new JMenuItem("Ajout Commentaire");

        jobTask.addActionListener(this);
        comment.addActionListener(this);

        jobTask.add(comment);

        JMenu vegetableThread = new JMenu("Saut de légume");
        JMenuItem vegetableMoving = new JMenuItem("Saut de légume");

        vegetableThread.addActionListener(this);
        vegetableMoving.addActionListener(this);

        vegetableThread.add(vegetableMoving);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(crud);
        menuBar.add(search);
        menuBar.add(jobTask);
        menuBar.add(vegetableThread);

        this.setJMenuBar(menuBar);
        this.addWindowListener(new MainFrameListener());

        this.setBounds(
                (SCREEN_RESOLUTION_X / 2) - (WINDOWS_RESOLUTION_X / 2),
                (SCREEN_RESOLUTION_Y / 2) - (WINDOWS_RESOLUTION_Y / 2),
                WINDOWS_RESOLUTION_X,
                WINDOWS_RESOLUTION_Y
        );

        setVisible(true);
    }

    private JPanel gePanel(String name) {
        // TODO : do this a better way. Maybe with generics ? or even state design pattern ?
        switch (name) {
            case "Publication de Recette" -> {
                return new PublishRecipePanel();
            }
            case "Modification de Recette" -> {
                return new ModificationRecipePanel();
            }
            case "Listing des Recettes" -> {
                return new ListingRecipePanel();
            }
            case "Elimination de Recette" -> {
                return new EliminationRecipePanel();
            }
            case "Ingredient" -> {
                return new SearchIngredientPanel();
            }
            case "Regime Alimentaire" -> {
                return new SearchDietPanel();
            }
            case "Recette" -> {
                return new SearchRecipePanel();
            }
            case "Ajout Commentaire" -> {
                return new AddCommentPanel();
            }
            case "Saut de légume" -> {
                VegetableJumpingPanel vegetablePanel = new VegetableJumpingPanel();
                VegetableMoveThread moveThread = new VegetableMoveThread(vegetablePanel);
                moveThread.start();

                return vegetablePanel;
            }
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String action = event.getActionCommand();
        if (currentPanel != null) {
            this.remove(currentPanel);
        }
        currentPanel = this.gePanel(action);
        this.add(currentPanel);
        this.revalidate();
        this.repaint();
    }
}
