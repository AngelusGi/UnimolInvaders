package UniMolInvaders.AAA;

import java.awt.*;

public class Alieno extends Personaggio {

    boolean visible;
    boolean moveRight;
    boolean moveLeft;
    static final int DIM_ALINEO = 25;

    protected static final int DESTRA = 2;
    protected static final int SINISTRA = -2;
    static final int DIREZIONE_COLPO = 1;

    public Alieno(int posX, int posY, int velocita){
        super(posX, posY, velocita);
        this.moveLeft = false;
        this.moveRight = true;
        this.visible = true;
    }


    public void paint(Graphics graphics) {

        //RENDE I BORDI DEI COMPONENTI 2D PIù SMUSSATI
//        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setColor(Color.RED);
        graphics.fillRect(posX, posY, DIM_ALINEO, DIM_ALINEO);

    }

    public Rectangle getBounds() {
        return new Rectangle(posX, posY, DIM_ALINEO, DIM_ALINEO);
    }

    protected void muovi(){

        //BORDO SX
        if (this.posX + velocita < 0){
            velocita = DESTRA;
            this.posY = posY + 67;

        } else if (this.posX + velocita > Start.DIM_FINESTRA_LARGHEZZA - DIM_ALINEO - 20) {
            //BORDO DX
            velocita = SINISTRA;
            this.posY = posY + 67;

        }

            this.posX = posX + velocita;
    }


}
