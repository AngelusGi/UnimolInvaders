package UniMolInvaders.Logic;

/**
 * gestisce la componente logica dei colpi
 */
public abstract class Shot {


    public static final int MAX_WAIT_TO_SHOT = 1500;
    protected static final int dimX = 5;
    protected static final int dimY = 10;
    private static final int PLAYER_DIRECTION = -1;
    private static final int DISTANCE = 25;
    private static final int INITIAL_SPEED = 5;
    protected int posX;
    protected int posY;
    protected int speed;
    private boolean alive;
    private boolean direction;

    public Shot(int posX, int posY, boolean direction) {
        this.posX = posX;
        this.posY = posY;
        this.speed = INITIAL_SPEED;
        setAlive(true);
        this.direction = direction;
        if (this.direction) {
            this.speed *= PLAYER_DIRECTION;
            this.posY -= DISTANCE;
        } else {
            this.posY += DISTANCE;
        }

    }

    public static boolean getPlayerDirection() {
        return true;
    }

    protected static int getDimX() {
        return dimX;
    }

    protected static int getDimY() {
        return dimY;
    }

    public boolean isDirection() {
        return direction;
    }

    protected int getPosX() {
        return posX;
    }

    protected int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    protected int getSpeed() {
        return speed;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}


