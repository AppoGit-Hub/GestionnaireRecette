package userInterface;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

public class VegetableJumpingbPanel extends JPanel {
    HashSet<ImageVegetable> setImageVegetable;
    private VegetableMoveThread theMoveThread;
    private boolean continued;
    public VegetableJumpingPanel(boolean continued){
        setImageVegetable = new HashSet<>();
        this.continued = continued;
        setBackground(Color.WHITE);
        setLayout(null);
        setSize(3000,3000);
        theMoveThread = new VegetableMoveThread(this,continued);
        theMoveThread.start();
    }
    @Override
    public void paint(Graphics aGraphic){
        super.paint(aGraphic);
        for(ImageVegetable aImageVegetable : setImageVegetable){
            aImageVegetable.setLocation(aImageVegetable.getPositionX(),aImageVegetable.getPositionY());
            add(aImageVegetable);
        }
        //revalidate();//je ne suis pas sur de son utilité dire qu'il y a ajout ? et ajire en concequence
    }

    public HashSet<ImageVegetable> getSetImageVegetable() {
        return setImageVegetable;
    }
}
