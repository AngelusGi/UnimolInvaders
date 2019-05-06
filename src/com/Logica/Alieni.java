package Logica;

public class Alieni extends Alieno {

    private int AlieniX = 5;
    private int AlieniY = 3;
    private int livello;

    private Alieno[][] matrixAliens;

    protected Alieni(int livello){
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
