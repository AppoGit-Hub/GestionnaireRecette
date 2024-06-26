package userInterface;

import java.util.Random;

public class VegetableMoveThread extends Thread {
    private VegetableJumpingPanel presentationPage;
    private Random random;
    private boolean continued;
    private int counter;
    public VegetableMoveThread(VegetableJumpingPanel presentationPage){
        this.presentationPage = presentationPage;
        this.continued = true;
        this.random = new Random();
        this.counter = 0;
    }

    public void run(){
        presentationPage.getImageVegetableSet().add(new ImageVegetable(50,50,"panier.png"));
        while(continued) {
            try{
                Thread.sleep(200);
                presentationPage.getImageVegetableSet().removeIf(ImageVegetable::needBeEliminated);
                presentationPage.repaint();

                for(ImageVegetable aImageVegetable : presentationPage.getImageVegetableSet()){
                    aImageVegetable.move();
                }

                counter++;

                // create fake space between each vegetable
                if (counter > 1) {
                    int number = this.random.nextInt(3);

                    String urlImage = switch(number) {
                        case 0 -> "poireau.png";
                        case 1 -> "citrouille.png";
                        default -> "carotte.png";
                    };

                    presentationPage.getImageVegetableSet().add(new ImageVegetable(50,50,urlImage));

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
