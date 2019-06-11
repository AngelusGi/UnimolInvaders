package UniMolInvaders.Logic;

import UniMolInvaders.GUI.ContentSwitch;

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

    private final int DESTRA = 5;
    private final int SINISTRA = -5;
    private final int STOP = 0;

    private int posX;
    private int posY;
    private int speedX = 5;
    private static int LIFE_POINTS = 5;

    private int lifePoints;
    boolean alive;
    boolean fired;

    public static final int DIM_X = 39;
    public static final int DIM_Y = 60;

    private Shot shot;


    public Player(int posX, int posY) {
        setPosX(posX);
        setPosY(posY);
        setLifePoints(LIFE_POINTS);
        setAlive(true);
        setFired(false);

    }

    public void move(){

        //BORDO
        if ((this.posX + this.speedX > 5) &&
                (this.posX + this.speedX < ContentSwitch.WIM_WIDTH - DIM_X - 20)){

            this.posX += speedX;
        }

    }


    protected boolean decrementLife() {
        //se la lifePoints è maggiore di 1 la decrementa
        if (getLifePoints() > 1) {
            setLifePoints(getLifePoints() - shot.getDanno());
        } else {
            //altrimenti lo setta come morto
            setAlive(false);
        }

        return isAlive();
    }

    private void shot(){
        //todo

        setFired(true);
    }

    public void keyPressed(KeyEvent keyEvent){
        switch(keyEvent.getKeyCode()){
            case KeyEvent.VK_LEFT:
                setSpeedX(SINISTRA);
                break;
            case KeyEvent.VK_RIGHT:
                setSpeedX(DESTRA);
                break;
            case KeyEvent.VK_SPACE:
                shot();
                break;
        }
    }

    public void keyReleased(KeyEvent keyEvent){
        switch(keyEvent.getKeyCode()){
            case KeyEvent.VK_LEFT:

            case KeyEvent.VK_RIGHT:
                setSpeedX(STOP);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public int getPosX() {
        return posX;
    }


    public int getPosY() {
        return posY;
    }


    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }


    public void setPosX(int posX) {
        this.posX = posX;
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


    public int getDIM_GIOCATORE_X() {
        return DIM_X;
    }


    public int getDIM_GIOCATORE_Y() {
        return DIM_Y;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }


}
