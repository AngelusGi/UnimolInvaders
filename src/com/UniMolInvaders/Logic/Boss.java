package UniMolInvaders.Logic;

/********************************
 *
 *   user:      angel
 *   date:      02/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/


public class Boss extends Enemy {

    private int lifePoints = 15;
    private int speedY = 30;

    public Boss(int posX, int posY, int speedX) {
        super(posX, posY, speedX);
        setLifePoints(lifePoints);
        setSpeedY(speedY);

    }


}
