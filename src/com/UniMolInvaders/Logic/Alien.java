package UniMolInvaders.Logic;


public abstract class Alien extends Enemy {

    /********************************
     *
     *   user:      angel
     *   date:      02/02/2019
     *   project:   UnimolInvaders
     *   angelus_gi / angelusgi
     *
     ********************************/


    private static final int LIFE_POINTS = 1;
    private static final int SPEED_Y = 10;


    protected Alien(int posX, int posY, int level) {
        super(posX, posY, level);
        setLifePoints(LIFE_POINTS);
        setSpeedY(SPEED_Y);
    }

}
