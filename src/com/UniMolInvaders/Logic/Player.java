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


public class Player extends Character {

    public static final int DIM_X = 39;
    public static final int DIM_Y = 60;
    private static final boolean PLAYER_DIRECTION = true;
    private static int LIFE_POINTS = 5;
    public final int RIGHT = 5;
    public final int LEFT = -5;
    public final int STOP = 0;

    protected Player(int posX, int posY) {
        super(posX, posY, LIFE_POINTS, DIM_X, DIM_Y, PLAYER_DIRECTION);
        setSpeedX(STOP);
    }

    public void move() {

        //BORDO
        if ((getPosX() + getSpeedX() > 5) && (getPosX() + getSpeedX() < ContentSwitch.WIN_WIDTH - DIM_X - 20)) {
            setPosX(getPosX() + getSpeedX());
        }
    }

}
