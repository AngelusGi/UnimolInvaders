package UniMolInvaders.Logic;

import UniMolInvaders.GUI.ContentSwitch;
import UniMolInvaders.GUI.ShootGraph;

import java.awt.*;

public abstract class Character {

    private int posX;
    private int posY;
    private int speedX;

    private int dimX;
    private int dimY;
    private boolean alive;
    private int lifePoints;
    private long latestShot;
    private ShootGraph shot;
    private boolean fireDirection;

    //costruttore per gli alieni
    protected Character(int posX, int posY, int level, boolean fireDirection) {
        setPosX(posX);
        setPosY(posY);
        setSpeedX(level);
        setAlive(true);
        setFireDirection(fireDirection);
    }

    //costruttore per il giocatore
    protected Character(int posX, int posY, int lifePoints, int dimX, int dimY, boolean fireDirection) {
        setPosX(posX);
        setPosY(posY);
        setLifePoints(lifePoints);
        setAlive(true);
        setDimX(dimX);
        setDimY(dimY);
        setFireDirection(fireDirection);
    }

    public Rectangle getBounds() {
        return new Rectangle(getPosX(), getPosY(), getDimX(), getDimY());
    }

    public boolean decrementLife() {
        //se la lifePoints è maggiore di 1 la decrementa
        if (getLifePoints() > 1) {
            setLifePoints(getLifePoints() - 1);
        } else {
            //altrimenti lo setta come morto
            setAlive(false);
        }

        return isAlive();
    }

    protected void setFireDirection(boolean fireDirection) {
        this.fireDirection = fireDirection;
    }

    public void tryToFire() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - latestShot > ShootGraph.MAX_WAIT_TO_SHOT) {
            shot = new ShootGraph(getPosX() + getDimX() / 2, getPosY(), fireDirection);
            ContentSwitch.getGame().getShoot().add(shot);
            latestShot = System.currentTimeMillis();
        }
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public boolean isAlive() {
        return alive;
    }

    private void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getDimX() {
        return dimX;
    }

    public void setDimX(int dimX) {
        this.dimX = dimX;
    }

    public int getDimY() {
        return dimY;
    }

    public void setDimY(int dimY) {
        this.dimY = dimY;
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

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public ShootGraph getShot() {
        return shot;
    }

}
