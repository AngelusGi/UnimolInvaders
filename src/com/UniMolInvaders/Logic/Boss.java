package UniMolInvaders.Logic;

/********************************
 *
 *   user:      angel
 *   date:      02/02/2019
 *   project:   UnimolInvaders
 *   angelus_gi / angelusgi
 *
 ********************************/

/**
 * Gestisce l'inizializzazione del Boss
 */
public abstract class Boss extends Enemy {

    private static final int LIFE_POINTS = 15;
    private static final int SPEED_Y = 30;

    /**
     * Costruttore del Boss
     *
     * @param posX  posizione orizzontale iniziale
     * @param posY  posizione verticale iniziale
     * @param level numero di livello raggiunto che serve per impostare la velocità di spostamento
     */
    protected Boss(int posX, int posY, int level) {
        super(posX, posY, level);
        setSpeedY(SPEED_Y);
        setLifePoints(LIFE_POINTS);
    }

}
