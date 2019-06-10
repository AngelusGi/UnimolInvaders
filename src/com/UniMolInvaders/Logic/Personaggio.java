package UniMolInvaders.Logic;

import UniMolInvaders.GUI.Start;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/********************************
 *
 *   user:      angel
 *   date:      02/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/


public class Personaggio implements KeyListener {

    private final int DESTRA = 5;
    private final int SINISTRA = -5;
    private final int STOP = 0;
    private int posX;
    private int posY;
    private int spostamentoX = 5;
    private static int NUM_VITE = 5;

    private int vita;
    boolean isVivo;
    boolean hasFired;

    public static final int DIM_GIOCATORE_X = 39;
    public static final int DIM_GIOCATORE_Y = 60;

    private Colpo colpo;


    public Personaggio(int posX, int posY) {
        setPosX(posX);
        setPosY(posY);
        setVita(NUM_VITE);
        setVivo(true);
        setHasFired(false);

    }

    public void muovi(){

        //BORDO
        if ((this.posX + this.spostamentoX > 5) &&
                (this.posX + this.spostamentoX < Start.DIM_FINESTRA_LARGHEZZA - DIM_GIOCATORE_X - 20)){

            this.posX += spostamentoX;
        }

    }


    protected boolean decrementaVita() {
        //se la vita è maggiore di 1 la decrementa
        if (getVita() > 1) {
            setVita(getVita() - colpo.getDanno());
        } else {
            //altrimenti lo setta come morto
            setVivo(false);
        }

        return isVivo();
    }

    private void spara(){
        //todo

        setHasFired(true);
    }

    public void keyPressed(KeyEvent tasto){
        switch(tasto.getKeyCode()){
            case KeyEvent.VK_LEFT:
                setSpostamentoX(SINISTRA);
                break;
            case KeyEvent.VK_RIGHT:
                setSpostamentoX(DESTRA);
                break;
            case KeyEvent.VK_SPACE:
                spara();
                break;
        }
    }

    public void keyReleased(KeyEvent tasto){
        switch(tasto.getKeyCode()){
            case KeyEvent.VK_LEFT:

            case KeyEvent.VK_RIGHT:
                setSpostamentoX(STOP);
                break;
        }
    }


    public int getPosX() {
        return posX;
    }


    public int getPosY() {
        return posY;
    }


    public void setVita(int vita) {
        this.vita = vita;
    }


    public void setPosX(int posX) {
        this.posX = posX;
    }


    public void setPosY(int posY) {
        this.posY = posY;
    }


    public boolean isVivo() {
        return isVivo;
    }


    public void setVivo(boolean vivo) {
        isVivo = vivo;
    }


    public boolean hasFired() {
        return hasFired;
    }


    public void setHasFired(boolean hasFired) {
        this.hasFired = hasFired;
    }


    public int getVita() {
        return vita;
    }


    public int getDIM_GIOCATORE_X() {
        return DIM_GIOCATORE_X;
    }


    public int getDIM_GIOCATORE_Y() {
        return DIM_GIOCATORE_Y;
    }

    public int getSpostamentoX() {
        return spostamentoX;
    }

    public void setSpostamentoX(int spostamentoX) {
        this.spostamentoX = spostamentoX;
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }
}
