package UniMolInvaders.Logic;

import java.awt.*;

/********************************
 *
 *   user:      angel
 *   date:      06/05/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/

public class Shot {

    private boolean isSparato;
    private int danno;

    private int velocita = 5;
    private int posX;
    private int posY;

    private static final int DIM_X = 11;
    private static final int DIM_Y = 29;

    protected Rectangle area;

    public Shot(int posX, int posY, int direzione) {
        setSparato(false);
        setDanno(1);
        setPosX(posX);
        setPosY(posY);
        setVelocita(direzione);
        area = new Rectangle(new Point(posX, posX), new Dimension(getDimX(), getDimY()));
    }



    public int getDimX() {
        return DIM_X;
    }

    public int getDimY() {
        return DIM_Y;
    }


    public void setVelocita(int direzione) {
        this.velocita *= direzione;
    }


    protected void muovi(int posY) {

        setPosY(getPosY() + velocita);
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

}
