package userInterface;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

public class VegetableJumpingPanel extends JPanel {
    private HashSet<ImageVegetable> setImageVegetable;
    private VegetableMoveThread theMoveThread;
    private Boolean continued;

    public VegetableJumpingPanel() {
        setImageVegetable = new HashSet<>();
        this.continued = true;
        //setBackground(Color.WHITE);
        setLayout(null);
        theMoveThread = new VegetableMoveThread(this);
        theMoveThread.start();
    }

    @Override
    public void paint(Graphics aGraphic){
        super.paint(aGraphic);
        //this.removeAll(); //pour vider et voir si cela à un effet
        for(ImageVegetable aImageVegetable : setImageVegetable){
            aImageVegetable.setLocation(aImageVegetable.getPositionX(),aImageVegetable.getPositionY());
            aImageVegetable.setBounds(new Rectangle(100,100));
            this.add(aImageVegetable);
            System.out.println(aImageVegetable.getIcon());
            this.setBackground(Color.BLUE);
            System.out.println("partie paint de vegetableJumpingPanel"+this.continued);
            revalidate();
        }
    }

    public HashSet<ImageVegetable> getImageVegetableSet() {
        return setImageVegetable;
    }
}
