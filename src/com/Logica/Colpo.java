package Logica;

import javax.swing.*;
import java.awt.*;

/********************************
 *
 *   user:      angel
 *   date:      06/05/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/

public class Colpo {

    private static final int SPOSTAMENTO = 5;
    private boolean sparato;

    private int posX;
    private int posY;
    private int danno;

    private static final int DIM_COLPO_X = 20;
    private static final int DIM_COLPO_Y = 53;
    private ImageIcon immagineColpo;

    public Colpo(int posX, int posY) {
        setSparato(false);
        setDanno(1);
        setPosX(posX);
        setPosY(posY);
        immagineColpo = new ImageIcon(this.getClass().getResource("./Resources/colpo.png"));
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
        return !sparato;
    }

    public void setSparato(boolean sparato) {
        this.sparato = sparato;
    }

    public int getDanno() {
        return danno;
    }

    private void setDanno(int danno) {
        this.danno = danno;
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

        Alieno[][] matrixAliens = alieni.getMatrixAliens();

        for (int riga = 0; riga < matrixAliens.length; riga++) {
            for (int colonna = 0; colonna < matrixAliens[riga].length; colonna++) {
                return isColpito = collisione(matrixAliens[riga][colonna].getPosX(), matrixAliens[riga][colonna].getPosY(),
                        this.getPosX(), this.getPosY());
            }
        }
        return isColpito;
    }

    private boolean collisione(int personaggioPosX, int personaggioPosY, int colpoPosX, int colpoPosY) {

        //todo collisione nemico colpo

        return true;

    }

    protected boolean isColpito(Personaggio giocatore) {

        return collisione(giocatore.getPosX(), giocatore.getPosY(), this.getPosX(), this.getPosY());

    }

    public void disegnaColpo(Graphics graphics) {
        if (isSparato()) {
            graphics.drawImage(immagineColpo.getImage(), getPosX(), getPosY(), DIM_COLPO_X, DIM_COLPO_Y, null);
        }
    }


    protected void spara(int posX, int posY) {
//        //quando spara ritorna un booleano per sparare un solo colpo per volta


        if (isSparato()) {


        } else {
            setSparato(true);
//            todo colpo.muovi();
        }

    }

}
