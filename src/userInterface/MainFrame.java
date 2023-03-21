package userInterface;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private MenuBar menuBar = new MenuBar();

    public MainFrame() {
        this.setMenuBar(this.menuBar);
    }
}
