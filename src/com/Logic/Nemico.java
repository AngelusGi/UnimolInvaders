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

    private int DIM_NEMICO_X;
    private int DIM_NEMICO_Y;

    private final int DESTRA = 5;
    private final int SINISTRA = -5;

    private int vita;
    private boolean isVivo;


    protected abstract boolean decrementaVita(Colpo colpo);



    protected void move(Nemico nemico, int larghezzaFinestra, int altezzaFinestra) {

        //BORDO SX
        if (nemico.getPosX() + nemico.getSpostamentoX() <= 0) {
            setPosX(getPosX() + getSpostamentoX());
            setSpostamentoX(SINISTRA);
        } else if (nemico.getPosX() + nemico.getSpostamentoX() <= larghezzaFinestra - nemico.getDIM_NEMICO_X() - 10) {
            //BORDO DX
            //sposta a destra
            moveDown(nemico.getPosX(), nemico.getPosY(), nemico.getSpostamentoX(), nemico.getSpostamentoY(), larghezzaFinestra);
            setSpostamentoX(DESTRA);
        } else if ((nemico.getPosY() + nemico.getSpostamentoY()  > altezzaFinestra - nemico.getDIM_NEMICO_X() - 10) || (nemico.getPosY() + nemico.getSpostamentoY() <= 0)){
            //bordo basso
            //collider muretti?
            if (posY + spostamentoY > altezzaFinestra - 50){
                moveDown(this.getPosX(), nemico.getPosY(), nemico.getSpostamentoX(), nemico.getSpostamentoY(), larghezzaFinestra);
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

    public int getDIM_NEMICO_X() {
        return DIM_NEMICO_X;
    }

    public void setDIM_NEMICO_X(int DIM_NEMICO_X) {
        this.DIM_NEMICO_X = DIM_NEMICO_X;
    }

    public int getDIM_NEMICO_Y() {
        return DIM_NEMICO_Y;
    }

    public void setDIM_NEMICO_Y(int DIM_NEMICO_Y) {
        this.DIM_NEMICO_Y = DIM_NEMICO_Y;
    }
}
