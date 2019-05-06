package Logica;

/********************************
 *
 *   user:      angel
 *   date:      02/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/


public class AlienoBoss extends Alieno {

    private static int VITA_ALIENO_BOSS = 15;
    private int SPOSTAMENTO_Y = 5;
    private int SPOSTAMENTO_X = 5;

    protected AlienoBoss(){
        this(VITA_ALIENO_BOSS, ALIENO_BOSS);
        this.posX = 10;
        this.posY = 10;
    }

    @Override
    protected void setVelocita(int livello) {
        if (livello>1){
            this.SPOSTAMENTO_X = SPOSTAMENTO_X * 2;
            this.SPOSTAMENTO_Y = SPOSTAMENTO_Y * 2;
        }
    }



    private AlienoBoss(int vita, int tipo) {
        super(vita, tipo);
    }

    @Override
    protected void move(int posX, int posY, int spostamentoX, int spostamentoY) {
        super.move(posX, posY, spostamentoX, spostamentoY);
    }


    @Override
    protected void moveDown(int posX, int posY) {
        this.posY = posY + SPOSTAMENTO_Y;
    }


    // todo inserire immagine
    // todo inserire sparo
}
