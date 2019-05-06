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

    private int vitaAlieno;
    private int spostamentoY = 2;
    private int spostamentoX = 2;
    private boolean isVivo;


    protected Alieno() {
        setVitaAlieno(1);
        setVivo(true);
    }


    public void setVitaAlieno(int vitaAlieno) {
        this.vitaAlieno = vitaAlieno;
    }

    public boolean isVivo() {
        return isVivo;
    }

    public void setVivo(boolean vivo) {
        isVivo = vivo;
    }

    @Override
    protected void setVelocita(int livello) {
        if (livello>0){
            this.spostamentoX = spostamentoX * 2;
            this.spostamentoY = spostamentoY * 2;
        }
    }

    @Override
    protected boolean decrementaVita() {

        //ammazza il singolo alieno
        setVivo(false);

        return isVivo();
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
