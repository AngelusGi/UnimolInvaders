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
    private static int SPOSTAMENTO_Y = 5;

    public Alieno(){
        this(VITA_ALIENO, ALIENO_NORMALE);
    }

    protected Alieno(int vita, int tipo) {
        super(vita, tipo);

    }

    
    protected void moveDown(int posY){
        this.posY = posY + SPOSTAMENTO_Y;
    }

    // todo inserire immagine
    // todo inserire sparo

}
