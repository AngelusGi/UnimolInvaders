package AAA;

import java.awt.*;

public class Colpo {

    static final int dimX = 5;
    static final int dimY = 10;
    static final int DIR_GIOCATORE = -1;
    int posX;
    int posY;
    int velocita;
    private boolean vivo;

    public Colpo(int posX, int posY, boolean direzionePersonaggio) {
        this.posX = posX;
        this.posY = posY;

        this.velocita = 2;

        if (direzionePersonaggio) {
            this.posY -= 10;
            this.velocita *= DIR_GIOCATORE;
        }
        setVivo(true);
        muovi();
    }

    public void muovi() {
        if ((posY + velocita > Start.DIM_FINESTRA_ALTEZZA) || (posY + velocita < 0)) {
            setVivo(false);
        } else {
            posY += velocita;
        }
    }

    public Rectangle getBounds() {
        muovi();
        return new Rectangle(posX, posY, dimX, dimY);
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
}
