package Logic;

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


public class Personaggio {

    private final static int DESTRA = 1;
    private final static int SINISTRA = -1;
    private int posX;
    private int posY;

    private int vita;
    boolean isVivo;
    boolean hasFired;

//    private Image immaginePersonaggio;
    private final int DIM_NAVICELLA_X = 39;
    private final int DIM_NAVICELLA_Y = 60;

    private Colpo colpo;


    public Personaggio() {
        setVita(10);
        setVivo(true);
        setHasFired(false);
        setPosX(350);
        setPosY(640);
//        immaginePersonaggio = new ImageIcon(this.getClass().getResource("navicellaPersonaggio.png")).getImage();
    }


    protected boolean decrementaVita(Colpo colpo) {
        //se la vita è maggiore di 1 la decrementa
        if (getVita() > 1) {
            setVita(getVita() - colpo.getDanno());
        } else {
            //altrimenti lo setta come morto
            setVivo(false);
        }

        return isVivo();
    }


    protected void moveLeft(int posX, int posY){
        this.posX = posX + SINISTRA;
    }


    protected void moveRight(int posX, int posY){
        this.posX = posX + DESTRA;
    }


//    public void disegnaPersonaggio(Graphics graphics) {
//        if (isVivo()) {
//            graphics.drawImage(immaginePersonaggio, getPosX(), getPosY(), DIM_NAVICELLA_X, DIM_NAVICELLA_Y, null);
//        }
//    }


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


//    public Image getImmaginePersonaggio() {
//        return immaginePersonaggio;
//    }


    public int getDIM_NAVICELLA_X() {
        return DIM_NAVICELLA_X;
    }


    public int getDIM_NAVICELLA_Y() {
        return DIM_NAVICELLA_Y;
    }


}
