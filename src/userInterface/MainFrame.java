package userInterface;

import model.MainFrameListener;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane = new JTabbedPane();
    private PublishRecipePanel publishRecipePanel = new PublishRecipePanel();
    private SearchRecipePanel searchRecipePanel = new SearchRecipePanel();

    public MainFrame() {
        this.tabbedPane.insertTab("Publish", null, this.publishRecipePanel, "Publish Panek", 1);
        this.tabbedPane.insertTab("Search", null, this.searchRecipePanel, "Search Panek", 2);

        this.add(this.tabbedPane, BorderLayout.CENTER);
        this.addWindowListener(new MainFrameListener());

        this.setBounds(100, 100, 500, 500);
        this.setVisible(true);
    }
}
