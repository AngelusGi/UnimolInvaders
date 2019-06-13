package UniMolInvaders.Logic;

import UniMolInvaders.GUI.ContentSwitch;
import UniMolInvaders.GUI.ShotGraph;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/********************************
 *
 *   user:      angel
 *   date:      02/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/


public class Player implements KeyListener {

    public static final int DIM_X = 39;
    public static final int DIM_Y = 60;
    private static int LIFE_POINTS = 5;
    private final int RIGHT = 5;
    private final int LEFT = -5;
    private final int STOP = 0;
    protected Rectangle area;
    private int posX;
    private int posY;
    private int speedX = 5;
    private int lifePoints;
    private boolean alive;
    private boolean fired;

    public Player(int posX, int posY) {
        setPosX(posX);
        setPosY(posY);
        setLifePoints(LIFE_POINTS);
        setAlive(true);
        setFired(false);
        setSpeedX(STOP);
        area = new Rectangle(new Point(posX, posY), new Dimension(getDimX(), getDimY()));
    }

    public void move() {

        //BORDO
        if ((this.posX + this.speedX > 5) &&
                (this.posX + this.speedX < ContentSwitch.WIN_WIDTH - DIM_X - 20)) {

            this.posX += speedX;
        }

    }


    private void shot() {
        //todo
        setFired(true);
    }


    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                setSpeedX(LEFT);
                move();
                break;

            case KeyEvent.VK_RIGHT:
                setSpeedX(RIGHT);
                move();
                break;

            case KeyEvent.VK_SPACE:
                shot();
                break;
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_LEFT:

            case KeyEvent.VK_RIGHT:
                setSpeedX(STOP);
                break;
        }
    }

    protected boolean isDamaged(ShotGraph shot) {
        return this.area.intersects(shot.getArea());
    }

    @Override
    public void keyTyped(KeyEvent e) {

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

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean hasFired() {
        return fired;
    }

    public void setFired(boolean fired) {
        this.fired = fired;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getDimX() {
        return DIM_X;
    }


    public int getDimY() {
        return DIM_Y;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

}
