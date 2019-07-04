package UniMolInvaders.Logic;

/**
 * Gestisce l'inizializzazione del singolo alieno
 */
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

    /**
     * Costruttore dell'alieno
     *
     * @param posX  posizione orizzontale iniziale
     * @param posY  posizione verticale iniziale
     * @param level numero di livello raggiunto che serve per impostare la velocità di spostamento
     */
    protected Alien(int posX, int posY, int level) {
        super(posX, posY, level);
        setLifePoints(LIFE_POINTS);
        setSpeedY(SPEED_Y);
    }

}
