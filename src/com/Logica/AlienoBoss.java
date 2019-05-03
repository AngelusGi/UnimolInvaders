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
    private static int SPOSTAMENTO_Y = 15;

    public AlienoBoss(){
        this(VITA_ALIENO_BOSS, ALIENO_BOSS);
    }

    private AlienoBoss(int vita, int tipo) {
        super(vita, tipo);
    }

    @Override
    protected void move(int posX, int posY) {

        super.move(posX, posY);
    }

    @Override
    protected void moveDown(int posX, int posY) {
        this.posY = posY + SPOSTAMENTO_Y;
    }


    // todo inserire immagine
    // todo inserire sparo
}
