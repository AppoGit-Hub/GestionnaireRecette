package userInterface;

public class VegetableMoveThread extends Thread implements Runnable{
    private VegetableJumpingPanel presentationPage;
    private boolean continued;
    public VegetableMoveThread( VegetableJumpingPanel presentationPage){
        this.presentationPage = presentationPage;

    }

    public void run(){
        int counter = 0;
        int counterChangeVegetable = 0;
        while(true){
            try{
                presentationPage.add(new ImageVegetable(10,500,"carotte.png"));
                presentationPage.repaint();
                System.out.println("je suis dans le run");
                Thread.sleep(1000);
                for( ImageVegetable aImageVegetable : presentationPage.getImageVegetableSet()){
                    aImageVegetable.move();
                }
                presentationPage.getImageVegetableSet().removeIf(ImageVegetable::needBeEliminated);//une proposition généré qui correspond à une boucle pour éliminer les éléements qui ont le bool needbeelimanted positif
                presentationPage.repaint();
                counter++;
                if(counter > 5){//je ne sais plus pourquoi j'ai fait cela
                    String urlImage = switch (counterChangeVegetable) {
                        case 1 -> "poireau.png";
                        case 2 -> "citrouille.jpg";
                        default -> "carotte.jfif";
                    };
                    counterChangeVegetable++;
                    if(counterChangeVegetable == 3)
                        counterChangeVegetable = 0;
                    presentationPage.getImageVegetableSet().add(new ImageVegetable(10,500,urlImage));
                    counter = 0;
                    System.out.println("je suis dans le run parenthese > 5");
                }
            }
            catch(Exception aException){
                System.out.println("probleme au niveau de la thread de mouvement");
            }
        }
    }

    public void setContinued(boolean continued) {
        this.continued = continued;
    }
}
