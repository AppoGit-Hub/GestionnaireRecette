package userInterface;

import javax.swing.*;

public class ImageVegetable extends JLabel {
    private int positionX;
    private int positionY;
    private int x = 0;
    public ImageVegetable(int positionX,int positionY,String urlImage){
        super(new ImageIcon(urlImage));
        this.positionX = positionX;
        this.positionY = positionY;
        setSize(100,100);
    }
    public void move() {
        positionX += 20;
        positionY = 250 +  (int) (200 * Math.sin(25 * x));
        x += 1;
        System.out.println(String.format("%d - %d", positionX, positionY));
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


