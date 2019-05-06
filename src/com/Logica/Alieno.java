package Logica;

/********************************
 *
 *   user:      angel
 *   date:      02/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/


public class Alieno extends Nemico {

    private static int VITA_ALIENO = 1;
    private int SPOSTAMENTO_Y = 2;
    private int SPOSTAMENTO_X = 2;

    protected Alieno(){
        this(VITA_ALIENO, ALIENO_NORMALE);
    }

    protected Alieno(int vita, int tipo) {
        super(vita, tipo);

    }

    @Override
    protected void setVelocita(int livello) {
        if (livello>0){
            this.SPOSTAMENTO_X = SPOSTAMENTO_X * 2;
            this.SPOSTAMENTO_Y = SPOSTAMENTO_Y * 2;
        }
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
