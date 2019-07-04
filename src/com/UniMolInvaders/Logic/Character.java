package UniMolInvaders.Logic;

import UniMolInvaders.GUI.ContentSwitch;
import UniMolInvaders.GUI.ShootGraph;

import java.awt.*;

/**
 * Gestione di base di un qualunque personaggio
 */
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

    /**
     * gestione del rettangolo che rappresenta l'entità
     *
     * @return
     */
    public Rectangle getBounds() {
        return new Rectangle(getPosX(), getPosY(), getDimX(), getDimY());
    }

    /**
     * decrementa la vita dell'entità
     * @return dopo aver decrementato la vita, è ancora vivo o è morto
     */
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

    /**
     * ogni entità ha una direzione diversa per il colpo
     * @param fireDirection
     */
    protected void setFireDirection(boolean fireDirection) {
        this.fireDirection = fireDirection;
    }

    /**
     * Spara un colpo a una distanza temporale minima di 1,5 secondi
     */
    public void tryToFire() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - latestShot > ShootGraph.MAX_WAIT_TO_SHOT) {
            shot = new ShootGraph(getPosX() + getDimX() / 2, getPosY(), fireDirection);
            ContentSwitch.getGame().getShoot().add(shot);
            latestShot = System.currentTimeMillis();
        }
    }

    /**
     * Restituisce i punti di vita dell'entità
     * @return lifePoints
     */
    public int getLifePoints() {
        return lifePoints;
    }

    /**
     * Imposta i punti di vita dell'entità
     * @param lifePoints
     */
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    /**
     * Stato di vita dell'entità
     * @return
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Imposta lo stato di vita dell'entità
     * @param alive
     */
    private void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * Dimensione sull'asse X (orizzontale) dell'entità
     * @return dimX
     */
    public int getDimX() {
        return dimX;
    }

    /**
     * Imposta la dimensione sull'asse X (orizzontale) dell'entità
     * @param dimX
     */
    public void setDimX(int dimX) {
        this.dimX = dimX;
    }

    /**
     * Dimensione sull'asse Y (verticale) dell'entità
     * @return dimY
     */
    public int getDimY() {
        return dimY;
    }

    /**
     * Imposta la dimensione sull'asse Y (verticale) dell'entità
     * @param dimY
     */
    public void setDimY(int dimY) {
        this.dimY = dimY;
    }

    /**
     * restituisce la posizione sull'asse orizzontale (X)
     * @return
     */
    public int getPosX() {
        return posX;
    }

    /**
     * imposta la posizione sull'asse orizzontale (X)
     * @param posX
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * restituisce la posizione sull'asse verticale (Y)
     * @return
     */
    public int getPosY() {
        return posY;
    }

    /**
     * imposta la posizione sull'asse verticale (Y)
     * @param posY
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * restituisce la velocità di spostamento sull'asse X (orizzontale)
     * @return
     */
    public int getSpeedX() {
        return speedX;
    }

    /**
     * imposta la velocità di spostamento sull'asse X (orizzontale)
     * @param speedX
     */
    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

//    public ShootGraph getShot() {
//        return shot;
//    }

}
