package UniMolInvaders.Logic;

/********************************
 *
 *   user:      angel
 *   date:      02/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/


public abstract class Boss extends Enemy {

    private static final int LIFE_POINTS = 15;
    private static final int SPEED_Y = 30;

    protected Boss(int posX, int posY, int level) {
        super(posX, posY, level);
        setSpeedY(SPEED_Y);
        setLifePoints(LIFE_POINTS);
    }

}
