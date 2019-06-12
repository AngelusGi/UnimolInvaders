package UniMolInvaders.Logic;


public class Alien extends Enemy {

    /********************************
     *
     *   user:      angel
     *   date:      02/02/2019
     *   project:   UnimolInvaders
     *   angelus_gi / angelusgi
     *
     ********************************/


    private static final int lifePoints = 1;
    private static final int speedY = 10;


    public Alien(int posX, int posY, int speedX) {
        super(posX, posY, speedX);
        setLifePoints(lifePoints);
        setSpeedY(speedY);
    }

}
