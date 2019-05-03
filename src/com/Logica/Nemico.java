package Logica;

/********************************
 *
 *   user:      angel
 *   date:      02/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/


public abstract class Nemico {

    protected static final int ALIENO_BOSS = 1;
    protected static final int ALIENO_NORMALE = 0;

    protected int posX = 0;
    protected int posY = 0;

    private int spostamentoX = 5;
    private int spostamentoY = 5;


    private static final int DESTRA = 1;
    private static final int SINISTRA = -1;

    private int tipo;
    private int vita;

    public Nemico(int vita, int tipo) {
        this.vita = vita;
        this.tipo = tipo;
    }


    protected void move(int posX, int posY) {

        //todo
        int DIM_ALIENO, pos_muri, LARGHEZZA_FIN;

        //BORDO SX
        if (this.posX + spostamentoX < 0) {
            spostamentoX = DESTRA;
            this.posX = posX + spostamentoX;
        }

        //BORDO DX
        if (this.posX + spostamentoX > LARGHEZZA_FIN - DIM_ALIENO - 20) {
            //sposta in basso
            moveDown();

            spostamentoX = SINISTRA;
        }

        //BORDO BASSO
        if (this.posY + spostamentoY > pos_muri - DIM_ALIENO - 20){
            //collider muretti?

        }

    }


    protected abstract void moveDown(int posX, int posY);

}
