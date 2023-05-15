package userInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class MainFrame extends JFrame implements ActionListener {
    private JMenuBar menuBar = new JMenuBar();
    private PublishRecipePanel publishRecipePanel;
    private ModificationRecipePanel modificationRecipePanel = new ModificationRecipePanel();
    private EliminationRecipePanel eliminationRecipePanel = new EliminationRecipePanel();
    private ListingRecipePanel listingRecipePanel = new ListingRecipePanel();

    private SearchIngredientPanel searchIngredientPanel = new SearchIngredientPanel();
    private SearchDietPanel searchDietPanel = new SearchDietPanel();
    private SearchRecipePanel searchRecipePanel = new SearchRecipePanel();

    private AddCommentPanel addCommentPanel = new AddCommentPanel();

    private JPanel currentPanel;
    private HashMap<String, JPanel> menus = new HashMap<>();

    private static final int SCREEN_RESOLUTION_X = 1920;
    private static final int SCREEN_RESOLUTION_Y = 1080;
    private static final int WINDOWS_RESOLUTION_X = 700;
    private static final int WINDOWS_RESOLUTION_Y = 500;

    public MainFrame() {
        this.publishRecipePanel = new PublishRecipePanel();


        JMenu crud = new JMenu("CRUD");
        JMenuItem recipePublication = this.createMenuItem("Publication de Recette", this.publishRecipePanel);
        JMenuItem recipeModification = this.createMenuItem("Modification de Recette", this.modificationRecipePanel);
        JMenuItem recipeElimination = this.createMenuItem("Elimination de Recette", this.eliminationRecipePanel);
        JMenuItem recipeListing = this.createMenuItem("Liste des Recettes", this.listingRecipePanel);
            crud.add(recipePublication);
        crud.add(recipeModification);
        crud.add(recipeElimination);
        crud.add(recipeListing);

        JMenu search = new JMenu("Recherches");
        JMenuItem ingredient = this.createMenuItem("Ingredient", this.searchIngredientPanel);
        JMenuItem diet = this.createMenuItem("Regime Alimentaire", this.searchDietPanel);
        JMenuItem recipe = this.createMenuItem("Recette", this.searchRecipePanel);

        search.add(ingredient);
        search.add(diet);
        search.add(recipe);

        JMenu jobTask = new JMenu("Tache Metier");
        JMenuItem comment = this.createMenuItem("Ajout Commentaire", this.addCommentPanel);

        jobTask.add(comment);

        this.menuBar.add(crud);
        this.menuBar.add(search);
        this.menuBar.add(jobTask);

        this.setJMenuBar(this.menuBar);
        this.addWindowListener(new MainFrameListener());

        this.setBounds(
            (SCREEN_RESOLUTION_X / 2) - (WINDOWS_RESOLUTION_X / 2),
            (SCREEN_RESOLUTION_Y / 2) - (WINDOWS_RESOLUTION_Y / 2),
            WINDOWS_RESOLUTION_X,
            WINDOWS_RESOLUTION_Y
        );
        this.setVisible(true);
    }

    public JMenuItem createMenuItem(String label, JPanel panel) {
        JMenuItem menuItem = new JMenuItem(label);
        menuItem.addActionListener(this);
        this.menus.put(label, panel);
        return menuItem;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String action = event.getActionCommand();
        if (this.currentPanel != null) {
            this.remove(this.currentPanel);
        }
        this.currentPanel = this.menus.get(action);
        this.add(this.currentPanel);
        this.repaint();
        this.revalidate();
    }
}
