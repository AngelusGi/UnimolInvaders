package UniMolInvaders.AAA;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Giocatore extends Personaggio {

    static final int DIM_GIOCATORE = 25;
    static final int DIREZIONE_COLPO = -1;


    public Giocatore(int posX, int posY, int velocita) {
        super(posX, posY, velocita);
        this.velocita = 0;
    }

    public void paint(Graphics graphics) {

        graphics.setColor(Color.BLUE);
        graphics.fillRect(posX, posY, DIM_GIOCATORE, DIM_GIOCATORE);

    }

    protected void muovi(){

        //BORDO
        if ((this.posX + this.velocita > 5) &&
                (this.posX + this.velocita < Start.DIM_FINESTRA_LARGHEZZA - DIM_GIOCATORE - 20)){

            this.posX += this.velocita;
        }

    }

    public void keyPressed(KeyEvent tasto) {

        switch (tasto.getKeyCode()){
            case KeyEvent.VK_LEFT:
                this.velocita = -2;
                this.muovi();
                break;

            case KeyEvent.VK_RIGHT:
                this.velocita = 2;
                this.muovi();
                break;
        }

    }

    public void keyReleased(KeyEvent tasto) {
        switch (tasto.getKeyCode()){

            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                this.velocita = 0;
                break;

            case KeyEvent.VK_SPACE:
                //todo sparo
                break;

        }

    }

    public Rectangle getDimesnione(){
        return new Rectangle(posX, posY, DIM_GIOCATORE, DIM_GIOCATORE);
    }
}
