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

    private static int vitaAlienoBoss = 15;
    private int spostamentoY = 5;
    private int spostamentoX = 5;
    private boolean isVivo;

    protected AlienoBoss(){
        // posiziona il boss sempre in posizione (10, 10)
        this.posX = 10;
        this.posY = 10;
        setVivo(true);
    }

    public static int getVitaAlienoBoss() {
        return vitaAlienoBoss;
    }

    public static void setVitaAlienoBoss(int vitaAlienoBoss) {
        AlienoBoss.vitaAlienoBoss += vitaAlienoBoss;
    }

    @Override
    protected boolean decrementaVita() {
        //se la vita è maggiore di 1 la decrementa
        if (getVitaAlienoBoss() > 1) {
            setVitaAlienoBoss(-1);
        } else {
            //altrimenti lo setta come morto
            setVivo(false);
        }

        return isVivo();
    }

    public boolean isVivo() {
        return isVivo;
    }

    public void setVivo(boolean vivo) {
        isVivo = vivo;
    }

    @Override
    protected void setVelocita(int livello) {
        if (livello>1){
            this.spostamentoX = spostamentoX * 2;
            this.spostamentoY = spostamentoY * 2;
        }
    }


    @Override
    protected void move(int posX, int posY, int spostamentoX, int spostamentoY) {
        super.move(posX, posY, spostamentoX, spostamentoY);
    }


    @Override
    protected void moveDown(int posX, int posY) {
        this.posY = posY + spostamentoY;
    }


    // todo inserire immagine
    // todo inserire sparo
}
