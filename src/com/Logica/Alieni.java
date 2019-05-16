package Logica;

/********************************
 *
 *   user:      angel
 *   date:      06/05/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/

public class Alieni extends Alieno {

    private int numAlieniY = 4;
    private int numAlieniX = 4;
    private int livello;

    private Alieno alieno;
    private Alieno[][] matrixAliens;


    public Alieni(int livello) {
        matrixAliens = new Alieno[numAlieniX][numAlieniY];
        this.livello = livello;

    }


//    protected void inizializzaAlieni(ArrayList<Alieno> alieni){
//        for (int i = 0; i < 5; i++) {
//            alieni.add(i, alieno);
//        }
////        //Lista provare a implementare come lista
//
//    }


    protected void inizializzaAlieni(Alieno[][] matrixAliens){
        for (int riga = 0; riga < matrixAliens.length; riga++) {
            for (int colonna = 0; colonna < matrixAliens[riga].length; colonna++) {
                matrixAliens[riga][colonna] = new Alieno();
                matrixAliens[riga][colonna].setVelocita(livello);
            }
        }
    }


    public Alieno[][] getMatrixAliens() {
        return matrixAliens;
    }


}
