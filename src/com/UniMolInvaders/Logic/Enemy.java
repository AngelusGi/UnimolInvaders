package UniMolInvaders.Logic;

import UniMolInvaders.GUI.ContentSwitch;

/********************************
 *
 *   user:      angel
 *   date:      02/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/

/**
 * Gestisce la componete logica comune a tutti i nemici
 */
public abstract class Enemy extends Character {

    public static final int CHANGE_DIR = -1;
    private static final boolean SHOT_DIRECTION = false;
    private int speedY;
    private static final int INITIAL_SPEED_X = 10;


    protected Enemy(int posX, int posY, int level) {
        super(posX, posY, level, SHOT_DIRECTION);
    }

    /**
     * gestisce il movimento di tutti i nemici e la collisione con i bordi del frame
     */
    public void move() {

        if (this.getPosX() + this.getSpeedX() < 0) {
            //gestisce bordo SX e scende tutti gli aliens di 30px
            this.changeDirection(CHANGE_DIR);
            setPosY(getPosY() + this.speedY);


        } else if (this.getPosX() + this.getSpeedX() > ContentSwitch.WIN_WIDTH - this.getDimX() - 10) {

            //gestisce bordo SX e scende tutti gli aliens di 30px
            this.changeDirection(CHANGE_DIR);
            this.setPosY(this.getPosY() + this.speedY);

        } else {

            //sposta gli aliens lungo l'assse X
            this.setPosX(this.getPosX() + this.getSpeedX());
        }

    }

    /**
     * imposta la velocità di spostamento che aumenta con l'aumentare del livello raggiunto
     *
     * @param levelNumber livello della partita
     */
    @Override
    public void setSpeedX(int levelNumber) {

        if (levelNumber < 2) {
            super.setSpeedX(INITIAL_SPEED_X);
        } else {
            super.setSpeedX(INITIAL_SPEED_X * levelNumber);
        }
    }

    /**
     * cambia la direzione di movimento nel momento in cui si raggiunge il bordo
     * @param directionTo direzione di spostamento (destra/sinistra)
     */
    public void changeDirection(int directionTo) {
        super.setSpeedX(getSpeedX() * directionTo);
    }

    /**
     * imposta la velocità di dicesa lungo l'asse Y
     * @param speedY velocità asse y
     */
    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }
}
