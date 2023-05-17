package userInterface;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

// Sometimes its working, sometimes it's not. It is working
// on Benjamin's PC but not a Guyri's PC
public class VegetableJumpingPanel extends JPanel {
    private HashSet<ImageVegetable> setImageVegetable;
    private VegetableMoveThread theMoveThread;
    private Boolean continued;

    public VegetableJumpingPanel() {
        setImageVegetable = new HashSet<>();
        this.continued = true;
        //setBackground(Color.WHITE);
        setLayout(null);
        theMoveThread = new VegetableMoveThread(this, continued);
        theMoveThread.start();
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
            // oopsie...
            //System.out.println(exception.getMessage());
        }
    }

    public HashSet<ImageVegetable> getImageVegetableSet() {
        return setImageVegetable;
    }
}
