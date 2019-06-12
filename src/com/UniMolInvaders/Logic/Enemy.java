package UniMolInvaders.Logic;

import UniMolInvaders.GUI.ContentSwitch;

import java.awt.*;

/********************************
 *
 *   user:      angel
 *   date:      02/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/


public abstract class Enemy {

    public static final int RIGHT = 1;
    public static final int LELFT = -1;
    private static final int SHOT_DIRECTION = 1;
    protected Rectangle area;
    private int posX;
    private int posY;
    private int speedX;
    private int speedY;
    private int dimX;
    private int dimY;
    private boolean alive;
    private int lifePoints;
    private Shot shot;

    public Enemy(int posX, int posY, int speed) {
        setPosX(posX);
        setPosY(posY);
        setAlive(true);
        setSpeedX(speed);
        area = new Rectangle(new Point(posX, posY), new Dimension(getDimX(), getDimY()));
    }

    protected boolean decrementLife() {
        //se la lifePoints è maggiore di 1 la decrementa
        if (getLifePoints() > 1) {
            setLifePoints(getLifePoints() - 1);
        } else {
            //altrimenti lo setta come morto
            setAlive(false);
        }

        return isAlive();
    }


    public void move() {

        //BORDO SX
        if (this.posX + getSpeedX() < 0) {
            setSpeedX(getSpeedX() * RIGHT);
//            this.posY = posY + 67;
            setSpeedY(getSpeedY() + 50);

            //BORDO DX
        } else if (this.posX + getSpeedX() > ContentSwitch.WIM_WIDTH - getDimX() - 20) {
            setSpeedX(getSpeedX() * LELFT);
            setSpeedY(getSpeedY() + 50);

        }

        this.posX += getSpeedX();
    }

    protected boolean damage(Shot shot) {
        return this.area.intersects(shot.area);
    }

    public void shoot() {

        if (!shot.isSparato()) {
            shot = new Shot(this.getPosX(), this.getPosY(), SHOT_DIRECTION);
            shot.setSparato(true);
            shot.muovi(getPosY());
        }

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

    public void setSpeedX(int levelNumber) {

        if ((levelNumber < 2)) {
            this.speedX = 10;
        } else {
            this.speedX *= levelNumber;
        }

    }

    private int getSpeedY() {
        return speedY;
    }

    protected void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    protected int getLifePoints() {
        return lifePoints;
    }

    protected void setLifePoints(int lifePoints) {
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

    protected void setDimX(int dimX) {
        this.dimX = dimX;
    }

    public int getDimY() {
        return dimY;
    }

    protected void setDimY(int dimY) {
        this.dimY = dimY;
    }
}
