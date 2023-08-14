package userInterface;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

public class VegetableJumpingPanel extends JPanel {
    private HashSet<ImageVegetable> setImageVegetable;

    public VegetableJumpingPanel() {
        setImageVegetable = new HashSet<>();
        setLayout(null);
    }

    @Override
    public void paint(Graphics aGraphic){
        super.paint(aGraphic);
        try {
            synchronized(setImageVegetable) {
                for(ImageVegetable aImageVegetable : setImageVegetable){
                    aImageVegetable.setLocation(aImageVegetable.getPositionX(),aImageVegetable.getPositionY());
                    this.add(aImageVegetable);
                }
            }
        } catch (Exception exception) {
            //System.out.println(exception.getMessage());
        }
    }

    public HashSet<ImageVegetable> getImageVegetableSet() {
        return setImageVegetable;
    }
}
