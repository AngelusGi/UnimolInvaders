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

    private int AlieniY = 4;
    private int AlieniX = 4;
    private int livello;

    private Alieno[][] matrixAliens;


    public Alieni(int livello) {
        matrixAliens = new Alieno[AlieniX][AlieniY];
        this.livello = livello;

    }


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
