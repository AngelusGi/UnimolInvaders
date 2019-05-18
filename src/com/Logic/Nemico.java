package Logic;

/********************************
 *
 *   user:      angel
 *   date:      02/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/


public abstract class Nemico {

    protected int posX;
    protected int posY;
    private int spostamentoX;
    private int spostamentoY;

    private static final int DESTRA = 1;
    private static final int SINISTRA = -1;

    private int vita;
    private boolean isVivo;


    protected abstract boolean decrementaVita(Colpo colpo);



    protected void move(int posX, int posY, int spostamentoX, int spostamentoY, int xDimNemico, int yDimNemico, int larghezzaFinestra, int altezzaFinestra) {

        //todo
        int DIM_ALIENO, pos_muri, LARGHEZZA_FIN;

        //BORDO SX
        if (posX + spostamentoX <= 0) {
            posX = posX + spostamentoX;
            spostamentoX = DESTRA;
        }

        //BORDO DX
        if (posX + spostamentoX > larghezzaFinestra - xDimNemico - 10) {
            //sposta a destra
            moveDown(posX, posY, spostamentoX, spostamentoY, larghezzaFinestra);
            spostamentoX = SINISTRA;
        }

        //BORDO BASSO
        if (posY + spostamentoY > altezzaFinestra - 50){
            //collider muretti?
            if (posY + spostamentoY > altezzaFinestra - 50){
                moveDown(posX, posY, spostamentoX, spostamentoY, larghezzaFinestra);
            }

        }

    }

    protected void spara(Colpo colpo){
        if (!colpo.isSparato()){
            colpo.setSparato(true);
            //todo spostamento alieno
        }
    }


    protected void moveDown(int posX, int posY, int spostamentoX, int spostamentoY, int larghezzaFinestra){
        //SPOSTAMENTO IN BASSO ARRIVATO AL BORDO
        if ((posX + spostamentoX >= larghezzaFinestra) || (posX + spostamentoX <= 0)) {
            //collider muretti?
           setPosY(getPosY() + spostamentoY);
        }
    }


    protected void setVelocita(int livello){
        setSpostamentoX(getSpostamentoX() * livello);
        setSpostamentoY(getSpostamentoY() * livello);
    };


    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getSpostamentoX() {
        return spostamentoX;
    }

    public void setSpostamentoX(int spostamentoX) {
        this.spostamentoX = spostamentoX;
    }

    public int getSpostamentoY() {
        return spostamentoY;
    }

    public void setSpostamentoY(int spostamentoY) {
        this.spostamentoY = spostamentoY;
    }

    public int getVita() {
        return vita;
    }

    public void setVita(int vita) {
        this.vita = vita;
    }

    public boolean isVivo() {
        return isVivo;
    }

    public void setVivo(boolean vivo) {
        isVivo = vivo;
    }
}
