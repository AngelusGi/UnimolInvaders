package com.UnimolInvaders.Logic;

/********************************
 *
 *   user:      angel
 *   date:      02/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/



public class GameController {

    private int levelNumber;

    public GameController(){
        inizializzaAlieni(matrixAliens);

        levelNumber=0;
    }

    private boolean isDipari(int levelNumber) {

        return (levelNumber % 2) != 0;
    }

    private final int AlienNumberX = 5;
    private final int AlienNumberY = 3;

    private Alieno[][] matrixAliens = new Alieno[AlienNumberX][AlienNumberY];

    private void inizializzaAlieni(Alieno[][] matrixAliens){
        for (int i = 0; i < matrixAliens.length; i++) {
            for (int j = 0; j < matrixAliens[i].length; j++) {
                matrixAliens[i][j] = new Alieno();
            }

        }
    }

//    public void stampaLivello(){
//        System.out.print("Livello: " + levelNumber);
//        System.out.println(" è dispari: " + isDipari(levelNumber));
//        if (levelNumber<=5){
//            levelNumber+=1;
//        } else{
//            System.exit(1);
//        }
//
//        stampaLivello();
//    }
//
//    public void stampaAlieni(){
//        for (int i = 0; i < matrixAliens.length; i++) {
//            System.out.print(i+1);
//            for (int j = 0; j < matrixAliens[i].length; j++) {
//                System.out.print(matrixAliens[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }


}
