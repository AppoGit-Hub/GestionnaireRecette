package userInterface;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JMenuBar menuBar = new JMenuBar();

    public MainFrame() {
        this.setJMenuBar(this.menuBar);

        this.setBounds(100, 100, 500, 500);
        this.setVisible(true);
    }
}
