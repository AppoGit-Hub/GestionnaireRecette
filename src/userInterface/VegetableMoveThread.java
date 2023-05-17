package userInterface;

import java.util.Random;

public class VegetableMoveThread extends Thread {
    private VegetableJumpingPanel presentationPage;
    private boolean continued;
    private Random random;
    private int counter;
    public VegetableMoveThread( VegetableJumpingPanel presentationPage,Boolean continued){
        this.presentationPage = presentationPage;
        this.continued = continued;
        this.random = new Random();
        this.counter = 0;
    }

    public void run(){
        presentationPage.getImageVegetableSet().add(new ImageVegetable(10,500,"panier.png"));
        while(continued) {
            try{
                Thread.sleep(190);
                for( ImageVegetable aImageVegetable : presentationPage.getImageVegetableSet()){
                    aImageVegetable.move();
                }
                presentationPage.getImageVegetableSet().removeIf(ImageVegetable::needBeEliminated);
                presentationPage.repaint();

                counter++;

                // create fake space between each vegetable
                if (counter > 1) {
                    int number = this.random.nextInt(3);

                    String urlImage = switch(number) {
                        case 0 -> "poireau.png";
                        case 1 -> "citrouille.png";
                        default -> "carotte.png";
                    };

                    presentationPage.getImageVegetableSet().add(new ImageVegetable(10,500,urlImage));

                    counter = 0;
                }
            }
            catch(Exception exception){
                System.out.println(exception.getMessage());
            }
        }
    }
    public void setContinued(boolean continued) {
        this.continued = continued;
    }
}
