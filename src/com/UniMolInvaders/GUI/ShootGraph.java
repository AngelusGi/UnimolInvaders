package UniMolInvaders.GUI;

import UniMolInvaders.Logic.Shot;

import java.awt.*;

/**
 * Gestisce la componente grafica dei colpi
 */
public class ShootGraph extends Shot {

    public ShootGraph(int posX, int posY, boolean direction) {
        super(posX, posY, direction);
    }

    /**
     * Muove il colpo, controlla se è stato lanciato da un giocatore o da un nemico e setta la direzione
     */
    private void move() {
        if ((getPosY() + getSpeed() + getDimY() > ContentSwitch.WIN_HEIGHT) || (getPosY() + getSpeed() + getDimY() < 10)) {
            setAlive(false);
        } else {
            setPosY(getPosY() + getSpeed());
        }
    }

    public Rectangle getBounds() {
        move();
        return new Rectangle(getPosX(), getPosY(), getDimX(), getDimY());
    }

    public void draw(Graphics graphics) {

        graphics.setColor(Color.YELLOW);
        graphics.fillRect(getBounds().x, getBounds().y, getBounds().width, getBounds().height);
    }
}
