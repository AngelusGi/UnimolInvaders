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


public abstract class Enemy extends Character {

    public static final int CHANGE_DIR = -1;
    private static final boolean SHOT_DIRECTION = false;
    private int speedY;
    private static final int INITIAL_SPEED_X = 10;


    protected Enemy(int posX, int posY, int level) {
        super(posX, posY, level, SHOT_DIRECTION);
    }

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


    @Override
    public void setSpeedX(int levelNumber) {

        if (levelNumber < 2) {
            super.setSpeedX(INITIAL_SPEED_X);
        } else {
            super.setSpeedX(getSpeedX() * levelNumber);
        }
    }

    public void changeDirection(int directionTo) {
        super.setSpeedX(getSpeedX() * directionTo);
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }
}
