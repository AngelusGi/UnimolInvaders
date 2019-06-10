package UniMolInvaders.Logic;

import UniMolInvaders.GUI.MenuGUI;
import UniMolInvaders.GUI.Start;

/********************************
 *
 *   user:      angel
 *   date:      02/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/


public abstract class Nemico {

    public static final int DESTRA = 1;
    public static final int SINISTRA = -1;
    private static final int DIREZIONE_COLPO = 1;

    private int posX;
    private int posY;
    private int spostamentoX;
    private int spostamentoY;

    private int DIM_NEMICO_X;
    private int DIM_NEMICO_Y;

    public boolean isVivo;
    private int vita;

    private Colpo colpo;


    public Nemico(int posX, int posY, int velocita){
        setPosX(posX);
        setPosY(posY);
        setVivo(true);
        setVelocita(velocita);

    }

    protected boolean decrementaVita(){
        //se la vita è maggiore di 1 la decrementa
        if (getVita() > 1) {
            setVita(getVita() - 1 );
        } else {
            //altrimenti lo setta come morto
            setVivo(false);
        }

        return isVivo();
    }


    public void muovi(){

        //BORDO SX
        if (this.posX + getSpostamentoX()  < 0){
            setSpostamentoX( getSpostamentoX() * DESTRA);
//            this.posY = posY + 67;
            setSpostamentoY( getSpostamentoY() + 50);

        //BORDO DX
        } else if (this.posX + getSpostamentoX() > Start.DIM_FINESTRA_LARGHEZZA - getDIM_NEMICO_X() - 20) {
            setSpostamentoX(getSpostamentoX() * SINISTRA);
            setSpostamentoY( getSpostamentoY() + 50);

        }

        this.posX += getSpostamentoX();
    }

    public void spara(){

        if (!colpo.isSparato()){
            colpo = new Colpo(this.getPosX(), this.getPosY(), DIREZIONE_COLPO);
            colpo.setSparato(true);
            colpo.muovi(getPosY());
        }

    }


    public void setVelocita(int livello){

        if ((livello <= 1)){
            setSpostamentoX(10);
//            setSpostamentoY(getSpostamentoY() * livello);
        }
        setSpostamentoX(getSpostamentoX() * livello);
        setSpostamentoY(getSpostamentoY() * livello);
    }


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

    private int getSpostamentoY() {
        return spostamentoY;
    }

    protected void setSpostamentoY(int spostamentoY) {
        this.spostamentoY = spostamentoY;
    }

    protected int getVita() {
        return vita;
    }

    protected void setVita(int vita) {
        this.vita = vita;
    }

    protected boolean isVivo() {
        return isVivo;
    }

    private void setVivo(boolean vivo) {
        isVivo = vivo;
    }

    public int getDIM_NEMICO_X() {
        return DIM_NEMICO_X;
    }

    protected void setDIM_NEMICO_X(int DIM_NEMICO_X) {
        this.DIM_NEMICO_X = DIM_NEMICO_X;
    }

    public int getDIM_NEMICO_Y() {
        return DIM_NEMICO_Y;
    }

    protected void setDIM_NEMICO_Y(int DIM_NEMICO_Y) {
        this.DIM_NEMICO_Y = DIM_NEMICO_Y;
    }
}
