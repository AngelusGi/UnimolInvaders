package UniMolInvaders.Logic;

import UniMolInvaders.GUI.ContentSwitch;
import UniMolInvaders.GUI.ShotGraph;

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
    public static final int CHANGE_DIR = -1;
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
    private ShotGraph shot;

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

        if (this.getPosX() + this.getSpeedX() < 0) {
            //gestisce bordo SX e scende tutti gli aliens di 30px
            this.changeDirection(CHANGE_DIR);
            this.setPosY(this.getPosY() + this.getSpeedY());


        } else if (this.getPosX() + this.getSpeedX() > ContentSwitch.WIN_WIDTH - this.getDimX() - 10) {

            //gestisce bordo SX e scende tutti gli aliens di 30px
            this.changeDirection(CHANGE_DIR);
            this.setPosY(this.getPosY() + this.getSpeedY());

        } else {

            //sposta gli aliens lungo l'assse X
            this.setPosX(this.getPosX() + this.getSpeedX());
        }

    }

    public void moveShoot() {
        if (shot != null) {
            if (shot.isShooted())
                shot.run();
        }
    }

    public void shoot() {

        if (shot == null) {

            shot = new ShotGraph(this.getPosX() + this.dimX / 2, this.getPosY() + this.dimY, ShotGraph.ENEMY_DIRECTION);
            if (shot.isShooted()) {
                shot.setShooted(false);
            } else {

            }
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

    public void changeDirection(int change) {
        this.speedX *= change;
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
