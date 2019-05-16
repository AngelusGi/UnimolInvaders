package Logica;

import javax.swing.*;
import java.awt.*;

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
    private static final int DIM_ALIENO_X = 50;
    private static final int DIM_ALIENO_Y = 67;
    private boolean isVivo;
    private int posX;
    private int posY;
    private int spostamentoY = 2;
    private int spostamentoX = 2;

    private ImageIcon immagineAlieno;
    private Colpo colpo;

    public Alieno() {
        setVitaAlieno(1);
        setVivo(true);
        immagineAlieno = new ImageIcon(this.getClass().getResource("./Resources/alieno.png"));

    }


    public void disegnaAlieno(Graphics graphics) {
        if (isVivo()) {
            graphics.drawImage(immagineAlieno.getImage(), getPosX(), getPosY(), DIM_ALIENO_X, DIM_ALIENO_Y, null);
        }
    }

    // todo inserire immagine
    // todo inserire sparo


    @Override
    protected boolean decrementaVita(Colpo colpo) {
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
        if (livello > 0) {
            this.spostamentoX = spostamentoX * 2;
            this.spostamentoY = spostamentoY * 2;
        }
    }


}
