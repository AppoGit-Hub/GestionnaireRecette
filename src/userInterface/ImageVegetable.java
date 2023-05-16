package userInterface;

import javax.swing.*;

public class ImageVegetable extends JLabel {
    private int positionX;
    private int positionY;
    private boolean goUp;
    public ImageVegetable(int positionX,int positionY,String urlImage){
        super(new ImageIcon(urlImage));
        this.positionX = positionX;
        this.positionY = positionY;
        //setSize(100,100);
        goUp = true;
        //setVisible(true);// car pourquoi pas ahhhhhaahahahahahha...
    }
    public void move(){
        positionY += ((goUp)? 30 : -30);
        if(positionY > 600 || positionY <= 100)
            goUp = !goUp;
        positionX += 20;
    }
    public int getPositionX() {
        return positionX;
    }
    public int getPositionY() {
        return positionY;
    }
    public boolean needBeEliminated(){
        return positionX >= 1200;
    }
}


