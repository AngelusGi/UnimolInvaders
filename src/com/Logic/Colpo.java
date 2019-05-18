package Logic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/********************************
 *
 *   user:      angel
 *   date:      06/05/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/

public class Colpo {

    private boolean isSparato;
    private int danno;

    private static final int SPOSTAMENTO = 5;
    private int posX;
    private int posY;

    private final int DIM_COLPO_X = 11;
    private final int DIM_COLPO_Y = 29;


    public Colpo(int posX, int posY) {
        setSparato(false);
        setDanno(1);
        setPosX(posX);
        setPosY(posY);
    }


    private void muovi(int posX, int posY) {
        int traiettoria;
        traiettoria = getPosY() + SPOSTAMENTO;
        setPosY(traiettoria);
    }


    protected boolean isColpito(AlienoBoss alienoBoss) {

        return collisione(alienoBoss.getPosX(), alienoBoss.getPosY(), this.getPosX(), this.getPosY());

    }


    protected boolean isColpito(Alieni alieni) {

        boolean isColpito = false;

        ArrayList<Alieno> listaAlieni = alieni.getListaAlieni();

        for (int num = 0; num < listaAlieni.size(); num++) {
            return isColpito = collisione(listaAlieni.get(num).getPosX(), listaAlieni.get(num).getPosY(),
                    this.getPosX(), this.getPosY());
        }
        return isColpito;
    }


    private boolean collisione(int personaggioPosX, int personaggioPosY, int colpoPosX, int colpoPosY) {

        //todo collisione nemico colpo

        return true;

    }


    protected void spara(int posX, int posY) {
//        //quando spara ritorna un booleano per sparare un solo colpo per volta

        if (isSparato()) {
            muovi(getPosX(), getPosX());
        } else {
            setSparato(true);
//            todo colpo.muovi();
        }

    }



    protected boolean isColpito(Personaggio giocatore) {

        return collisione(giocatore.getPosX(), giocatore.getPosY(), this.getPosX(), this.getPosY());

    }


    public int getPosX() {
        return posX;
    }


    private void setPosX(int posX) {
        this.posX = posX;
    }


    public int getPosY() {
        return posY;
    }


    private void setPosY(int posY) {
        this.posY = posY;
    }


    public boolean isSparato() {
        return !isSparato;
    }


    public void setSparato(boolean isSparato) {
        this.isSparato = isSparato;
    }


    public int getDanno() {
        return danno;
    }


    private void setDanno(int danno) {
        this.danno = danno;
    }


    public int getDimColpoX() {
        return DIM_COLPO_X;
    }

    public int getDimColpoY() {
        return DIM_COLPO_Y;
    }
}
